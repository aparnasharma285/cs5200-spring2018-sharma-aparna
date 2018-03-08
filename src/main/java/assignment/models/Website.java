package assignment.models;

import java.util.Collection;
import java.util.Date;


public class Website {
	
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private Collection<Page> pages;
	
	/**
	 * 
	 */
	public Website() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param created
	 * @param updated
	 * @param visits
	 * @param pages
	 */
	public Website(int id, String name, String description, Date created, Date updated, int visits, 
			Collection<Page> pages) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.pages = pages;
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param created
	 * @param updated
	 * @param visits
	 */
	public Website(int id, String name, String description, Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}

	/**
	 * @param name
	 * @param description
	 * @param created
	 * @param updated
	 * @param visits
	 */
	public Website(String name, String description, Date created, Date updated, int visits) {
		super();
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;

	}
	
	

	/**
	 * @param name
	 * @param description
	 * @param visits
	 */
	public Website(String name, String description, int visits) {
		super();
		this.name = name;
		this.description = description;
		this.visits = visits;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * @return the visits
	 */
	public int getVisits() {
		return visits;
	}

	/**
	 * @param visits the visits to set
	 */
	public void setVisits(int visits) {
		this.visits = visits;
	}

	/**
	 * @return the pages
	 */
	public Collection<Page> getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}

	

}
