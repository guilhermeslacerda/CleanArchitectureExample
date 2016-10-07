package domain;


import static org.junit.Assert.*;

import domain.exceptions.InvalidSaleException;
import domain.Item;
import domain.Sale;

import org.junit.Test;

public class SaleTest {
	private double [][] values = {{20.0, 10.0}, {30.0, 40.0}};
	
	@Test
	public void testAddingTwoItemsOnSale() {
		Sale v = createASaleWithTwoItems();
		assertEquals(2, v.getItems().length);
		
		Item [] items = v.getItems();
		for (int i = 0; i < items.length; i++) {
			assertEquals(values[i][0], items[i].getAmount(), 0.0);
			assertEquals(values[i][1], items[i].getUnitPrice(), 0.0);
		}
	}

	private Sale createASaleWithTwoItems() {
		Sale sale = new Sale(2);
		addTwoItems(sale);
		return sale;
	}

	private void addTwoItems(Sale sale) throws InvalidSaleException {
		for (int i = 0; i < values.length; i++)
			sale.newItem(values[i][0], values[i][1]);
	}

	@Test(expected=InvalidSaleException.class)
	public void testFailToAddingMoreOneItemOnSale() {
			Sale v = createASaleWithTwoItems();
			v.newItem(40.0, 25.0);
	}
}
