package com.devopsusach2020;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.devopsusach2020.model.Pais;
import com.devopsusach2020.rest.RestData;

public class RestDataTest {
	Pais responseTestPais = new Pais();

	@Test
	void testGetPaisPeru() {
		RestData rest = new RestData();
		assertEquals("Peru", rest.getTotalPais("Peru").getCountry());
	}

	@Test
	void testGetPaisChile() {
		RestData rest = new RestData();
		assertEquals("Chile", rest.getTotalPais("Chile").getCountry());
	}

	@Test
	void testGetPaisVacio() {
		RestData rest = new RestData();
		assertThrows(Exception.class, () -> {
			rest.getTotalPais("");
		});
	}
}
