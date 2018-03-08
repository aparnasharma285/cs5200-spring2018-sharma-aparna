package assignment.models;

public class HtmlWidget extends Widget{

	private String html;

	/**
	 * 
	 */
	public HtmlWidget() {
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
	 * @param html
	 */
	public HtmlWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String type, String html) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type);
		this.html = html;
	}

	/**
	 * @param name
	 * @param text
	 * @param order
	 * @param type
	 */
	public HtmlWidget(String name, String text, int order, String type) {
		super(name, text, order, type);
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	
}

