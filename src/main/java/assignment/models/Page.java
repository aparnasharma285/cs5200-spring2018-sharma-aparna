package assignment.models;

import java.util.Date;
import java.util.Collection;

public class Page {
	
	private int id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int views;
	private Collection<Widget> widgets;
	
	/**
	 * 
	 */
	public Page() {
		super();
	}

	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param created
	 * @param updated
	 * @param views
	 * @param widgets
	 */
	public Page(int id, String title, String description, Date created, Date updated, int views,
			Collection<Widget> widgets) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.widgets = widgets;
	}

	/**
	 * @param title
	 * @param description
	 * @param created
	 * @param updated
	 * @param views
	 * @param widgets
	 */
	public Page(String title, String description, Date created, Date updated, int views,
			Collection<Widget> widgets) {
		super();
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.widgets = widgets;
	}
	
	

	/**
	 * @param title
	 * @param description
	 * @param views
	 */
	public Page(String title, String description, int views) {
		super();
		this.title = title;
		this.description = description;
		this.views = views;
	}

	
	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param created
	 * @param updated
	 * @param views
	 */
	public Page(int id, String title, String description, Date created, Date updated, int views) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the views
	 */
	public int getViews() {
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void setViews(int views) {
		this.views = views;
	}

	/**
	 * @return the widgets
	 */
	public Collection<Widget> getWidgets() {
		return widgets;
	}

	/**
	 * @param widgets the widgets to set
	 */
	public void setWidgets(Collection<Widget> widgets) {
		this.widgets = widgets;
	}

	
	
}
