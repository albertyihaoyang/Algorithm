package yyh;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateMedianTest {

	@Test
	public void test() {
		CalculateMedian cm = new CalculateMedian();
		int[] array = {1, 2, 3};
		int res = cm.getMedian(array);
		assertEquals(2, res);
	}

}
