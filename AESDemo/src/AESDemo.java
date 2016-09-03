import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AESDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "test";
		String password = "12345678";
		System.out.println("Encrypted:" + content);
		byte[] encryResult = encrypt(content, password);
		byte[] decryptResult = decrypt(encryResult, password);
		System.out.println("Decrypted:" + new String(decryptResult));
	}	
		
	
	private static byte[] encrypt(String content, String pwd){
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(pwd.getBytes()));
			SecretKey secretKey =kgen.generateKey();
			byte[] encodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(encodeFormat, "AES");
			Cipher cipher= Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(byteContent);
			return result;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	
	private static byte[] decrypt(byte[] content, String pwd){
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(pwd.getBytes()));
			SecretKey secretKey =kgen.generateKey();
			byte[] encodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(encodeFormat, "AES");
			Cipher cipher= Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] result = cipher.doFinal(content);
			return result;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}	
	
	

}
