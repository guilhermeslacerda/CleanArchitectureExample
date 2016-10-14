package services;

import java.util.List;

import domain.DataRepository;
import domain.Sale;
import domain.exceptions.InvalidSaleException;
import main.Bootstrapper;
import ui.Service;

public class SaleService implements Service {
	private Sale sale;
	private DataRepository repository;
	
	public SaleService() {
		repository = Bootstrapper.getPersistence(); 
	}

	@Override
	public void newSale(int numItems) {
		sale = new Sale(numItems);
	}

	@Override
	public void newItemOnSale(double amount, double unitPrice) {
		if (sale == null)
			throw new InvalidSaleException("Firstly, open the sale to add items");
		sale.newItem(amount, unitPrice);
	}

	@Override
	public Sale getSale() {
		if (sale == null)
			throw new InvalidSaleException("Sale not created. There are no items to be listed");
		return sale;
	}

	@Override
	public void saveSale() {
		if (sale != null)
			repository.addSale(sale);
	}

	@Override
	public List<Sale> getAllSales() {
		return repository.getAll();
	}
}
