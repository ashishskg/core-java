package section01.solid.dev04_interface_segregation.service;

import section01.solid.dev04_interface_segregation.entity.Order;

import java.util.HashMap;
import java.util.Map;


public class OrderPersistenceService implements PersistenceService<Order>{
	
	private static final Map<Long, Order> ORDERS = new HashMap<>();
	
	@Override
	public void save(Order entity) {
		synchronized (ORDERS) {
			ORDERS.put(entity.getId(), entity);
		}
	}

	@Override
	public void delete(Order entity) {
		synchronized (ORDERS) {
			ORDERS.remove(entity.getId());
		}
	}

	@Override
	public Order findById(Long id) {
		synchronized (ORDERS) {
			return ORDERS.get(id);
		}
	}
}
