package section01.solid.dev04_interface_segregation.service;


import section01.solid.dev04_interface_segregation.entity.Entity;

//common interface to be implemented by all persistence services.
public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
}
