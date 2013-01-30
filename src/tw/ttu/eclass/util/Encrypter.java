package tw.ttu.eclass.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter {
	public static String getMd5Hash(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buffer = str.getBytes();
			md.update(buffer);
			buffer = md.digest();
			StringBuffer sb = new StringBuffer();
			
			for(byte b : buffer){
				sb.append(String.format("%02x", (0xff & b)));
			}
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
