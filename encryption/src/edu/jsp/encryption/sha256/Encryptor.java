package edu.jsp.encryption.sha256;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

	public static byte[] getSHA(String input) throws NoSuchAlgorithmException {

//			digest instance of hashing using SHA256
		MessageDigest digest = MessageDigest.getInstance("SHA256");

//			digest() method to called to calculate message digest of an input and return array of byte
		return digest.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	public static String toHexString(byte[] hash) {
//		convert byte[] of hash into digest
		BigInteger integer = new BigInteger(1, hash);

//		convert the digest into hex value

		StringBuilder hexString = new StringBuilder(integer.toString(16));

//		pad with leading zeros
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}
		return hexString.toString();
	}
}