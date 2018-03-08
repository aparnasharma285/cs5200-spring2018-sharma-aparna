package assignment.models;

public class ImageWidget extends Widget {

	private String src;

	/**
	 * 
	 */
	public ImageWidget() {
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
	 * @param src
	 */
	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String type, String src) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type);
		this.src = src;
	}

	/**
	 * @param name
	 * @param text
	 * @param order
	 * @param type
	 */
	public ImageWidget(String name, String text, int order, String type) {
		super(name, text, order, type);
	}

	
	
	/**
	 * @param name
	 * @param width
	 * @param height
	 * @param text
	 * @param order
	 * @param type
	 * @param src
	 */
	public ImageWidget(String name, int width, int height, String text, int order, String type, String src) {
		super(name, width, height, text, order, type);
		this.src = src;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	
}
