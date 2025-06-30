package lianalopes.com.example.Gerador.de.QrCode.controler;

import lianalopes.com.example.Gerador.de.QrCode.DTO.QrCodeGeneretorRequest;
import lianalopes.com.example.Gerador.de.QrCode.DTO.QrCodeGeneretorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrCode")
public class QrCodeControler {

    private final QrCodeGenaratorService qrCodeService;

    public QrCodeControler(QrCodeGeneratorService qrCodeGeneratorService){
        this.qrCodeGeneratorService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGeneretorResponse> generate(@RequestBody QrCodeGeneretorRequest request){
        try{
            QrCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        }catch(Exception e){
            System.out.println(e); 
            return ResponseEntity.internalServerErro().build();
        }
    }

}
