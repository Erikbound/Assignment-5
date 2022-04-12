import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testConvertStringToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("- .... .. ... / .. ... / .- -. / .- -- .- --... .. -. --. / - . ... -");
		assertEquals("this is an amazing test",converter1);
	}

	@Test
	public void testConvertFileToEnglishString() {	
		File file = new File("src/morseCodeIsPrettyCool.txt"); 
		try {
			assertEquals("morse code is pretty cool", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
}
