package com.buntoy.wallet.util;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES算法编程实现
 * 
 * @author xzb
 *
 */
public class AESUtil {

	/**
	 * 生成密钥
	 * 
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception {
		// 密钥生成器
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		// 初始化密钥生成器
		keyGen.init(128); // 默认128，获得无政策权限后可用192或256
		// 生成密钥
		SecretKey secretKey = keyGen.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * 加密
	 * 
	 * @throws Exception
	 */
	public static byte[] encryptAES(byte[] data, byte[] key) throws Exception {
		// 恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, "AES");
		// Cipher完成加密
		Cipher cipher = Cipher.getInstance("AES");
		// 根据密钥对cipher进行初始化
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// 加密
		byte[] encrypt = cipher.doFinal(data);

		return encrypt;
	}

	/**
	 * 解密
	 */
	public static byte[] decryptAES(byte[] data, byte[] key) throws Exception {
		// 恢复密钥生成器
		SecretKey secretKey = new SecretKeySpec(key, "AES");
		// Cipher完成解密
		Cipher cipher = Cipher.getInstance("AES");
		// 根据密钥对cipher进行初始化
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] plain = cipher.doFinal(data);
		return plain;
	}
	
	public static String fromBytesToHex(byte[] resultBytes){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < resultBytes.length; i++){
			if(Integer.toHexString(0xFF & resultBytes[i]).length() == 1){
				builder.append("0").append(Integer.toHexString(0xFF & resultBytes[i]));
			}else{
				builder.append(Integer.toHexString(0xFF & resultBytes[i]));
			}
		}
		return builder.toString();
	}
	
	public static byte[] addBytes(byte[] data1, byte[] data2) {  
	    byte[] data3 = new byte[data1.length];  
	    System.arraycopy(data2, 0, data3, 0, data2.length);  
	    System.arraycopy(data1, data2.length, data3, data2.length, data1.length - data2.length);  
	    return data3;  
	  
	}
	public static String byteArrayToStr(byte[] byteArray) {
	    if (byteArray == null) {
	        return null;
	    }
	    String str = new String(byteArray);
	    return str;
	}
	
	public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }
	
	public static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
}
