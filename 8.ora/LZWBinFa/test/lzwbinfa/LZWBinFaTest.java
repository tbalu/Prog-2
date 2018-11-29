package lzwbinfa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LZWBinFaTest {
	private LZWBinFa binFa = new LZWBinFa();

	@Test
	void testGetSzoras() {
		char[] bitek = {'0','1','1','1','1','0','0','1','0','0','1','0','0','1','0','0','0','1','1','1'};
		binFa.biteketFeldolgoz(bitek);
		
		assertEquals(0.9574,binFa.getSzoras(),0.0002);
	}


}
