package ui;

import domain.Sale;

public interface Service {
	void newSale(int numItems);
	void newItemOnSale(double amount, double unitPrice);
	Sale getSale();
}
