/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URLData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author mahmed27
 */
public class URLRepository {
    public static final String threatExpertURL = "http://www.threatexpert.com";
    public static final String mitreCWEURL = "https://cwe.mitre.org/data/definitions/";
    
    public static String getMD5OfAFile(File selectedFile) throws NoSuchAlgorithmException, IOException {
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        String checksum = getFileChecksum(md5Digest, selectedFile);
        System.out.println("MD5 Hash:" + checksum);
        return checksum;
    }
        
    public static String getSHA256OfAFile(File selectedFile) throws NoSuchAlgorithmException, IOException {
        MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
        String checksum = getFileChecksum(sha256Digest, selectedFile);
        System.out.println("SHA256 Hash:" + checksum);
        return checksum;
    }
    
    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
   
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
