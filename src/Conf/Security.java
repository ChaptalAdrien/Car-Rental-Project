package Conf;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    
    private static final String SALT = "SFt1QyYB9pdoxH6m53cX";
    
    
    public static String hashSaltPswd(String password){
        
        //adding salt to password 
        String passwordSalt = password + SALT;
        
        MessageDigest md;
        try
        {
            // Select the message digest for the hash computation -> SHA-256
            md = MessageDigest.getInstance("SHA-256");


            // Generate the salted hash
            byte[] hashedPassword = md.digest(passwordSalt.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword)
                sb.append(String.format("%02x", b));
            
            String hashedSaltpswd = sb.toString();
            
            return hashedSaltpswd;
        } catch (NoSuchAlgorithmException e)
        {
           e.printStackTrace();
           return "";
        }
    }
    
    
    
    
}