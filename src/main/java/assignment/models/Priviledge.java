package assignment.models;

public class Priviledge {

	
	private int id;
	private String priviledge;
	/**
	 * 
	 */
	public Priviledge() {
		super();
	}
	/**
	 * @param id
	 * @param priviledge
	 */
	public Priviledge(int id, String priviledge) {
		super();
		this.id = id;
		this.priviledge = priviledge;
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
	 * @return the priviledge
	 */
	public String getPriviledge() {
		return priviledge;
	}
	/**
	 * @param priviledge the priviledge to set
	 */
	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}
	
	
	
}
