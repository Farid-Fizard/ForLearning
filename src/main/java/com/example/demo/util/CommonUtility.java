package com.example.demo.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtility {

    public static String generateSha(String input) {
        try {
            // SHA-256 algoritmasını kullanmak için MessageDigest nesnesi oluşturun
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Girdiyi byte dizisine dönüştürün
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Byte dizisini hexadecimal formata dönüştürün
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Algoritma desteklenmiyorsa veya tanınmıyorsa, hata durumunu işleyin
            e.printStackTrace();
        }
        return null;
    }
    // UUID ile token oluşturan fonksiyon
    public static String generateToken() {
        UUID uuid = UUID.randomUUID();
        String input = uuid.toString();
        return generateSha(input);
    }
}
