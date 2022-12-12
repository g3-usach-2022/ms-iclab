package com.devopsusach2020.rest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RestDataTest {
	RestData restData = new RestData("Peru");

	@Test
	public void testGetTotalPais() throws Exception {
		assertEquals(restData.strPais, "Peru");
	}

	@Test
	public void testDiezxciento() throws Exception {	
		
		
	}

	@Test
	public void testGetTotalmundial() throws Exception {

	}

}
