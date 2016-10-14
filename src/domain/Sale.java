package domain;

import domain.exceptions.InvalidSaleException;

public class Sale {
	private Item[] items;
	private int itemsNumber;
	
	public Sale(int numItems) throws InvalidSaleException {
		if (numItems <= 0)
			throw new InvalidSaleException("You can't create a sale with number of negative items"); 
		items = new Item[numItems];
		itemsNumber = 0;
		initialize();
	}

	private void initialize() {
		for (int i = 0; i < items.length; i++)
			items[i] = new Item(0.0, 0.0);
	}

	public void newItem(double amount, double unitPrice) throws InvalidSaleException {
		if (itemsNumber >= items.length)
			throw new InvalidSaleException("Sale already with all items added");
		
		items[itemsNumber++] = new Item(amount, unitPrice);
	}
	
	public Item[] getItems() {
		return items;
	}
}