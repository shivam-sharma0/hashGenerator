package com.DotNetCoverter.hashGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class HashUtility {

    public static String getHash(String firstName) throws NoSuchAlgorithmException, Exception {
        String input = firstName;
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(inputBytes);

        // Convert hashedBytes to a hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        // Return a HashResponse Object which contains the hashString
        HashResponse hashResponse = new HashResponse();
        hashResponse.setHash(hexString.toString());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(hashResponse);
    }

    public static class HashResponse {
        private String hash;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}