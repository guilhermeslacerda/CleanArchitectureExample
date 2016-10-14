package persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Bootstrapper;
import services.SaleService;
import ui.Service;

public class InMemoryRepositoryTest {
	private Service service;
	
	@Before
	public void setUp() {
		Bootstrapper.definePersistence(new InMemoryRepository());
		this.service = new SaleService();	
	}

	@Test
	public void testSaveSale() {
		assertEquals(0, service.getAllSales().size());
		createSaleAndAddItems();
		service.saveSale();
		assertEquals(1, service.getAllSales().size());
	}

	private void createSaleAndAddItems() {
		service.newSale(1);
		service.newItemOnSale(20.0, 50.0);
	}
}
