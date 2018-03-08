package assignment.models;

import java.util.Date;

public class User extends Person {

	private boolean userAgreement;
	private String userKey;

	// constructor with no arguments

	public User() {
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
	 * @param userAgreement
	 * @param userKey
	 */
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			boolean userAgreement, String userKey) {
		super(id, firstName, lastName, username, password, email, dob);
		this.userAgreement = userAgreement;
		this.userKey = userKey;
	}

	
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param userAgreement
	 * @param userKey
	 */
	public User(String firstName, String lastName, String username, String password, String email,
			boolean userAgreement, String userKey) {
		super(firstName, lastName, username, password, email);
		this.userAgreement = userAgreement;
		this.userKey = userKey;
	}


	/**
	 * @return the userAgreement
	 */

	public boolean isUserAgreement() {
		return userAgreement;
	}

	/**
	 * @param userAgreement
	 *            the userAgreement to set
	 */
	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}


	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}


	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
	

}
