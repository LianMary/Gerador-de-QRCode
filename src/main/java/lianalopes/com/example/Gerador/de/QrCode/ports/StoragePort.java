package lianalopes.com.example.Gerador.de.QrCode.ports;

public interface StoragePort {
    String uploadFile (byte[] fileData, String fileName, String contentType);
}
