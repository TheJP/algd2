package ch.fhnw.algd2.u07.a02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static void main(String[] args){
		System.out.print("Message: ");
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//e.g.
			//Das Fach Algorithmen und Datenstrukturen 2 macht Spass!
			//Das Fach Algorithmen und Datenstrukturen 1 macht Spass!
			byte[] data = reader.readLine().getBytes("US-ASCII");
			md5.update(data);
			byte[] hash = md5.digest();
			for(int i = 0; i < hash.length; ++i){
				System.out.print(String.format("%02x", hash[i]));
			}
			System.out.println();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
