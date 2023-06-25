package lib;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;


public class MaHoa {
	// md5
	// sha-1 => thường được sử dụng

	public static String toSHA1(String str) {
		String salt = "abjqfjfntdtnfjtndh;sdjgbjer";
		String result = null;
		str += salt;
		try {
			// Static getInstance method is called with hashing MD5, SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(str.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            result = no.toString(16); 
            while (result.length() < 32) { 
            	result = "0" + result; 
            } 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(toSHA1("123"));
	}
	
}
