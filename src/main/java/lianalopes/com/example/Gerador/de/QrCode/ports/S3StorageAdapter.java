package lianalopes.com.example.Gerador.de.QrCode.ports;
import org.springframework.beans.factory.annotation.Value;

import software.amazon.awssdk.services.s3.S3Client;

public class S3StorageAdapter implements StoragePort {
    
    private final S3Client s3Client;
    private final String bucketName;

    public S3StorageAdapter (@Value("${aws.region}") String region, @Value("${aws.s3.bucket-name}") String bucketName){
        
        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder().region(Region.of(this.region)).build();
    } 
    @Override
    public String uploadFile(byte[] fileData, String fileName, String contentType) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
        .builder(bucketName)
        .key(fileName)
        .contentType(contentType)
        .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));

        return String.format("https://%s.s3.%s.amazonaws.com/%s",bucketName,region, fileName);
    }

}