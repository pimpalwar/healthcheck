package com.codility.tasks.spring.healthcheck;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import com.codility.tasks.utility.Inverter;

@SpringBootTest
public class InverterTest {

	@Test
	public void shouldInvertTheString() {
		assertEquals(Inverter.invert("abcd"), "dcba");
	}
	
	@Test
	public void shouldReturnSameSingleLetter() {
		assertEquals(Inverter.invert("a"), "a");
	}
	
	@Test
	public void shouldReturnEmptyStringOnNullAsInput() {
		assertEquals(Inverter.invert(null), "");
	}
}
