package assignment.models;

public class Role {
	
	private int id;
	private String role;
	
	
	public Role() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param role
	 */
	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
