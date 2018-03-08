package assignment.models;

public class HeadingWidget extends Widget {

	private int size;

	/**
	 * 
	 */
	public HeadingWidget() {
		super();
	}

	/**
	 * @param name
	 * @param text
	 * @param order
	 * @param type
	 */
	public HeadingWidget(String name, String text, int order, String type) {
		super(name, text, order, type);
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
	 * @param size
	 */
	public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String type, int size) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type);
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	
}
