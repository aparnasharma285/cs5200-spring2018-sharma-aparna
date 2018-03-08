package assignment.models;

import java.util.Collection;
import java.util.Date;


public class Developer extends Person {

	private String devKey;
	private Collection<Website> websites;
	
	// constructor with no arguments

	public Developer() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param dob
	 * @param devKey
	 * @param websites
	 */
	public Developer(int id, String firstName, String lastName, String username, String password, String email,
			Date dob, String devKey, Collection<Website> websites) {
		super(id, firstName, lastName, username, password, email, dob);
		this.devKey = devKey;
		this.websites = websites;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param devKey
	 * @param websites
	 */
	public Developer(String firstName, String lastName, String username, String password, String email, String devKey,
			Collection<Website> websites) {
		super(firstName, lastName, username, password, email);
		this.devKey = devKey;
		this.websites = websites;
	}
	
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param devKey
	 */
	public Developer(String firstName, String lastName, String username, String password, String email, String devKey) {
		super(firstName, lastName, username, password, email);
		this.devKey = devKey;
	}

	/**
	 * @return the devKey
	 */
	public String getDevKey() {
		return devKey;
	}

	/**
	 * @param devKey the devKey to set
	 */
	public void setDevKey(String devKey) {
		this.devKey = devKey;
	}

	/**
	 * @return the websites
	 */
	public Collection<Website> getWebsites() {
		return websites;
	}

	/**
	 * @param websites the websites to set
	 */
	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}

	
	

	
}
