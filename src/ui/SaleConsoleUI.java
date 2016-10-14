package ui;

import java.util.Scanner;

import domain.Item;
import domain.exceptions.InvalidSaleException;
import main.UI;
import services.SaleService;

public class SaleConsoleUI implements UI {
	private static final int OPTION_NEW_SALE = 1;
	private static final int OPTION_ADD_ITEM = 2;
	private static final int OPTION_SHOW_ITEMS = 3;
	private static final int OPTION_QUIT = 4;
	private Scanner in;
	private Service service;

	public SaleConsoleUI() {
		service = new SaleService();
	}

	@Override
	public void menu() {
		do { 
			showOptions();
		} while (checkOptions() != 4);
	}
	
	private void showOptions() {
		printLine("\n\n");
		printLine("\nMENU\n");
		printLine("\n[1] New Sale");
		printLine("\n[2] Add item on sale");
		printLine("\n[3] Show items");
		printLine("\n[4] Quit\n");
		printLine("\nChoose your option: ");
	}

	private byte checkOptions() {
		byte option = getOption();

		try {
			switch (option) {
			case OPTION_NEW_SALE: newSale();
			    break;
			case OPTION_ADD_ITEM: addItemOnSale();
			    break;
			case OPTION_SHOW_ITEMS: showItems();
			    break;
			case OPTION_QUIT: saveAndQuit();
			    break;
			}
		} catch (InvalidSaleException e) {
			printLine(e.getMessage());
		}

		return option;
	}

	private byte getOption() {
		in = new Scanner(System.in);
		return in.nextByte();
	}

	private void newSale() throws InvalidSaleException {
		int numItems = getIntValue("Type the total of items on sale: ");
		service.newSale(numItems);
	}

	private void addItemOnSale() throws InvalidSaleException {
		double amount = getDoubleValue("Amount: ");
		double unitPrice = getDoubleValue("Price: ");	                	
		service.newItemOnSale(amount, unitPrice);
	}

	private void showItems() throws InvalidSaleException {
		Item[] items;

		items = service.getSale().getItems();
		printLine("\nAmount \tUnit Price  \tSubtotal");
		for(int i = 0; i < items.length; i++)                		
			printLine("\n" + items[i].getAmount() + "\t" + items[i].getUnitPrice() 
						+ "\t\t" + items[i].getSubTotal());
	}

	private void saveAndQuit() {
		service.saveSale();
		printLine("\n\nQuit Sale App!!\nThank you for using our app.");
	}

	private int getIntValue(String message) {
		printLine(message);
		return in.nextInt();
	}

	private double getDoubleValue(String message) {
		printLine(message);
		return in.nextDouble();
	}

	private void printLine(String message) {
		System.out.print(message);
	}
}