package main;

import domain.DataRepository;
import persistence.InMemoryRepository;
import ui.SaleConsoleUI;

public class Bootstrapper {
	private static DataRepository repository;
	private static UI ui;

	public static void main(String[] args) {
		Bootstrapper.definePersistence(new InMemoryRepository());
		Bootstrapper.defineUI(new SaleConsoleUI());
		ui.menu();
	}

	public static void definePersistence(DataRepository repository) {
		Bootstrapper.repository = repository;
	}
	
	public static DataRepository getPersistence() {
		return repository;
	}

	public static void defineUI(UI ui) {
		Bootstrapper.ui = ui;
	}

	public static UI getUI() {
		return ui;
	}
}

