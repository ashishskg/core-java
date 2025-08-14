package section01.solid.dev04_interface_segregation.entity;

//Base class for all entities
public abstract class Entity {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
