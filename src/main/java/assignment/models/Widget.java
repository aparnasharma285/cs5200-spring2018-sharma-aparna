package assignment.models;

public class Widget {
	
	private int id;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private String type;

	
	/**
	 * 
	 */
	public Widget() {
		super();
	}


	/**
	 * @param id
	 * @param name
	 * @param width
	 * @param height
	 * @param cssClass
	 * @param cssStyle
	 * @param text
	 * @param order
	 * @param type
	 */
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String type) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.type = type;
	}


	/**
	 * @param name
	 * @param width
	 * @param height
	 * @param text
	 * @param order
	 * @param type
	 */
	public Widget(String name, int width, int height, String text, int order, String type) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.text = text;
		this.order = order;
		this.type = type;
	}


	/**
	 * @param name
	 * @param text
	 * @param order
	 * @param type
	 */
	public Widget(String name, String text, int order, String type) {
		super();
		this.name = name;
		this.text = text;
		this.order = order;
		this.type = type;
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}


	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}


	/**
	 * @return the cssStyle
	 */
	public String getCssStyle() {
		return cssStyle;
	}


	/**
	 * @param cssStyle the cssStyle to set
	 */
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}


	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}


	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
