package domain;

public class Item {
	private double unitPrice;
	private double amount;
	
	public Item(double amount, double unitPrice){
		setAmount(amount);
		setUnitPrice(unitPrice);
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

	public double getSubTotal() {
		return getAmount() * getUnitPrice();
	}
}
