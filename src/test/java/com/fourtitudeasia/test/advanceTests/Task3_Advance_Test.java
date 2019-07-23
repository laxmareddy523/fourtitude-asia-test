package com.fourtitudeasia.test.advanceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fourtitudeasia.test.advance.Task3_Advance;
import com.fourtitudeasia.test.entity.KeyValue;

@RunWith(MockitoJUnitRunner.class)
public class Task3_Advance_Test {

	Task3_Advance encryptDecryptService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before
	public void setUp() {
		initMocks(this);
		encryptDecryptService = new Task3_Advance();
	}

	@Test
	public void testEncryptDecrypt() {
		String text = "Laxmareddy Anireddy";
		String encrypt;
		String decrypt;
		try {
			encrypt = encryptDecryptService.encrypt(text, mockKeyValue());
			logger.info("Encrypted String is :: {} ", encrypt);

			decrypt = encryptDecryptService.decrypt(encrypt, mockKeyValue());
			logger.info("Decrypted String is :: {} ", decrypt);

			assertThat(decrypt).isEqualTo(text);
		} catch (Exception e) {
			logger.debug("Exception occured  :: {} ", e.getStackTrace());
		}
	}

	private KeyValue mockKeyValue() {
		KeyValue keyValue = new KeyValue();

		keyValue.setModulus(256);
		keyValue.setMultiplier(11);
		keyValue.setIncrement(1);
		keyValue.setSeed(0);

		return keyValue;

	}

}
