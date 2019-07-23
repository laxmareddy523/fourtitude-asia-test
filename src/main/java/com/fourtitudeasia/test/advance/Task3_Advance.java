package com.fourtitudeasia.test.advance;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.fourtitudeasia.test.basic.Task3;
import com.fourtitudeasia.test.entity.KeyValue;

@Service
public class Task3_Advance {

	public static String encrypt(String plainText, KeyValue keyValue) throws Exception {
		Task3 lcg = new Task3(keyValue.getModulus(), keyValue.getMultiplier(), keyValue.getIncrement(),
				keyValue.getSeed());
		byte[] bytes = plainText.getBytes("UTF-8");
		int len = bytes.length;
		byte[] xors = new byte[len];
		for (int ix = 0; ix < len; ix += 1) {
			xors[ix] = (byte) ((int) bytes[ix] ^ ((int) lcg.next()));
		}
		return new String(Base64.getEncoder().encode(xors), "UTF-8");
	}

	public static String decrypt(String base64EncodedValue, KeyValue keyValue) throws Exception {

		Task3 lcg = new Task3(keyValue.getModulus(), keyValue.getMultiplier(), keyValue.getIncrement(),
				keyValue.getSeed());
		byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedValue);
		int len = decodedBytes.length;
		byte[] xors = new byte[len];
		for (int ix = 0; ix < len; ix += 1) {
			xors[ix] = (byte) ((int) decodedBytes[ix] ^ ((int) lcg.next()));
		}
		return new String(xors);

	}

}
