package persistence;

import java.util.ArrayList;
import java.util.List;

import domain.DataRepository;
import domain.Sale;

public class InMemoryRepository implements DataRepository {
	private List<Sale> sales = new ArrayList<Sale>();

	@Override
	public void addSale(Sale sale) {
		sales.add(sale);
	}

	@Override
	public List<Sale> getAll() {
		return sales;
	}
}
