package service;


import static org.junit.Assert.*;

import services.SaleService;
import domain.exceptions.InvalidSaleException;

import org.junit.Before;
import org.junit.Test;

public class SaleServiceTest {
	private SaleService service;

	@Before
	public void setUp() {
		service = new SaleService();
	}

	@Test(expected=InvalidSaleException.class)
	public void testFailToCreateASaleWithNegativeNumber() throws InvalidSaleException {
		service.newSale(-1);
		assertNotNull(service.getSale());
	}

	@Test
	public void testCreateOneSale() {
		service.newSale(2);
		assertNotNull(service.getSale());
	}

	@Test
	public void testAddingOneItem() {
		service.newSale(1);
		service.newItemOnSale(20.0, 50.0);
	}

	@Test(expected=InvalidSaleException.class)
	public void testFailGetSaleNotCreated() {
		service.getSale();
	}
}
