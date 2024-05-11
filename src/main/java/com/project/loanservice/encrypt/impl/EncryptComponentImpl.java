package com.project.loanservice.encrypt.impl;

import com.project.loanservice.encrypt.EncryptComponent;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

@Component
public class EncryptComponentImpl implements EncryptComponent {

    @Value("${encrypt.secret-key}")
    private String SECRET_KEY;

    private Base64.Encoder encoder = Base64.getEncoder();
    private Base64.Decoder decoder = Base64.getDecoder();


    @Override
    public String encryptString(String encryptString) {

        try {
            byte[] encryptedString =
                    cipherPkcs5(Cipher.ENCRYPT_MODE, SECRET_KEY)
                            .doFinal(encryptString.getBytes(StandardCharsets.UTF_8));

            return new String(encoder.encode(encryptedString));

        } catch (IllegalArgumentException | GeneralSecurityException e) {
            throw new CustomServiceException(ErrorCode.ENCRYPT_FAIL);
        }
    }

    @Override
    public String decryptString(String decryptString) {

        try {
            byte[] byteString =
                    decoder.decode(decryptString.getBytes(StandardCharsets.UTF_8));

            return new String(cipherPkcs5(Cipher.DECRYPT_MODE, SECRET_KEY)
                    .doFinal(byteString)
            );
        } catch (IllegalArgumentException | GeneralSecurityException e) {
            throw new CustomServiceException(ErrorCode.DECRYPT_FAIL);
        }
    }

    private Cipher cipherPkcs5(Integer opMode, String secretKey) {

        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec sk =
                    new SecretKeySpec(
                            secretKey.getBytes(StandardCharsets.UTF_8), "AES");
            IvParameterSpec iv = new IvParameterSpec(
                    secretKey.substring(0, 16)
                            .getBytes(StandardCharsets.UTF_8)
            );
            c.init(opMode, sk, iv);

            return c;
        } catch (Exception e) {
            throw new CustomServiceException(ErrorCode.CYPHER_GENERATING_FAIL);
        }
    }

}
