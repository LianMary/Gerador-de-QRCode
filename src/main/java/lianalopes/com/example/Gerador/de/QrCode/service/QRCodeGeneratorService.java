package lianalopes.com.example.Gerador.de.QrCode.service;

import com.lianalopes.qrcode.generator.dto.QrCodeGenerateResponse;
import com.lianalopes.qrcode.generator.ports.StoragePort;

import org.springframework.sterotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.client.j2se.MatrixToImageWriter;
import com.google.commom.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;


@Service
public class QRCodeGeneratorService{
    private final StoragePort storage;

    public QrCodeGeneratorService (StoragePort storage){
        this.storage = storage;
    }

    public QrCodeGnereteResponse generateUploadQrCode(String text){
       QRCodeWriter qrCodeWrither = new QRCodeWriter();
       BitMatrix bitMatrix = qrCodeWriiter.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, 200, 200);
       
       ByteArrayOutputStream pngOutputStream = new BytyArrayOutputStream();
       MatrixToImageWriter.writeToStream = new ByteArrayOutputStream();
       byte[] pngQrCodeData = pngOutputStream.toBYteArray();

       String url = storage.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "image/png" );

        return new QrCodeGenerateResponse(url);
    }
}