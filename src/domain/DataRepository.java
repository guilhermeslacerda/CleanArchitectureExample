package domain;

import java.util.List;

import domain.Sale;

public interface DataRepository {
	void addSale(Sale sale);
	List<Sale> getAll();
}
