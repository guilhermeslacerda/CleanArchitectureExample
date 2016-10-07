package domain;


import static org.junit.Assert.*;

import org.junit.Test;

import domain.Item;

public class ItemTest {

	@Test
	public void verifySubTotal() {
		Item i = new Item(50,3);
		assertEquals(150.00, i.getSubTotal(), 0.0);
	}
}
