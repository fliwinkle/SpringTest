package com.example.st.util;

import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.UnsupportedEncodingException;

@Converter
public class ColumnEncryptor implements AttributeConverter<String, String> {

    // 암호화 키
    @Value("${spring.database.column.encrypt.key:}")
    private String key;

    private Cipher encryptCipher;
    private Cipher decryptCipher;

    @PostConstruct
    public void init() throws Exception{
        encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLAESKey(key, "UTF-8"));
        decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLAESKey(key, "UTF-8"));
    }

    /**
     * 필드의 값을 데이터베이스 칼럼 값으로 변환하는 코드를 여기 작성합니다.
     */
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            return new String();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 칼럼 값을 필드의 값으로 변환하는 코드를 여기 작성합니다.
     */
    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            return new String();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SecretKeySpec generateMySQLAESKey(final String key, final String encoding) {
        try {
            final byte[] finalKey = new byte[16];
            int i = 0;
            for(byte b : key.getBytes(encoding))
                finalKey[i++%16] ^= b;
            return new SecretKeySpec(finalKey, "AES");
        } catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
