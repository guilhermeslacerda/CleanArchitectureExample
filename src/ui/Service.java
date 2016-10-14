package ui;

import java.util.List;

import domain.Sale;

public interface Service {
	void newSale(int numItems);
	void newItemOnSale(double amount, double unitPrice);
	Sale getSale();
	void saveSale();
	List<Sale> getAllSales();
}
