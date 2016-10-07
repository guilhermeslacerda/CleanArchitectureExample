package services;

import domain.Sale;
import domain.exceptions.InvalidSaleException;
import ui.Service;

public class SaleService implements Service {
	private Sale sale;

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
}
