package assignment.models;

public class YouTubeWidget extends Widget {

	private String url;
	private boolean shareble;
	private boolean expandable;

	/**
	 * 
	 */
	public YouTubeWidget() {
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
	 * @param url
	 * @param shareble
	 * @param expandable
	 */
	public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String type, String url, boolean shareble, boolean expandable) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type);
		this.url = url;
		this.shareble = shareble;
		this.expandable = expandable;
	}

	/**
	 * @param name
	 * @param width
	 * @param height
	 * @param text
	 * @param order
	 * @param type
	 * @param url
	 */
	public YouTubeWidget(String name, int width, int height, String text, int order, String type, String url) {
		super(name, width, height, text, order, type);
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the shareble
	 */
	public boolean isShareble() {
		return shareble;
	}

	/**
	 * @param shareble the shareble to set
	 */
	public void setShareble(boolean shareble) {
		this.shareble = shareble;
	}

	/**
	 * @return the expandable
	 */
	public boolean isExpandable() {
		return expandable;
	}

	/**
	 * @param expandable the expandable to set
	 */
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}

	
}
