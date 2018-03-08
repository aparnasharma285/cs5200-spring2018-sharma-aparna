package assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import assignment.models.HeadingWidget;
import assignment.models.HtmlWidget;
import assignment.models.ImageWidget;
import assignment.models.Widget;
import assignment.models.YouTubeWidget;

public class WidgetDao extends ConnectionDao {

	public static WidgetDao instance = null;

	public static WidgetDao getInstance() {

		if (instance == null) {
			instance = new WidgetDao();
		}

		return instance;
	}

	private final String CREATE_WIDGET_HEADING = "INSERT INTO Widget (name, width, height, cssClass, cssStyle, text, `order`, type, size, html, src, url, shareble, expandable, page) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, null, null, null, null,null, ?)";

	private final String CREATE_WIDGET_HTML = "INSERT INTO Widget (name, width, height, cssClass, cssStyle, text, `order`, type, size, html, src, url, shareble, expandable, page) VALUES (?, ?, ?, ?, ?, ?, ?, ?, null, ?, null, null, null,null, ?)";

	private final String CREATE_WIDGET_IMAGE = "INSERT INTO Widget (name, width, height, cssClass, cssStyle, text, `order`, type, size, html, src, url, shareble, expandable, page) VALUES (?, ?, ?, ?, ?, ?, ?, ?, null, null, ?, null, null,null, ?)";

	private final String CREATE_WIDGET_YOUTUBE = "INSERT INTO Widget (name, width, height, cssClass, cssStyle, text, `order`, type, size, html, src, url, shareble, expandable, page) VALUES (?, ?, ?, ?, ?, ?, ?, ?, null, null, null, ?, ?,?, ?)";

	private final String FIND_ALL_WIDGETS = "SELECT * FROM Widget";

	private final String FIND_WIDGET_BY_ID = "SELECT * FROM Widget where id = ? ";

	private final String FIND_WIDGET_FOR_PAGE = "SELECT * FROM Widget where page = ? ";

	private final String UPDATE_WIDGET_HEADING = "UPDATE Widget SET name = ?, width = ?, height = ?, cssClass = ?, cssStyle = ?, text = ?, order = ?, type = ?, size = ? where id = ?";

	private final String UPDATE_WIDGET_HTML = "UPDATE Widget SET name = ?, width = ?, height = ?, cssClass = ?, cssStyle = ?, text = ?, order = ?, type = ?, html = ? where id = ?";

	private final String UPDATE_WIDGET_IMAGE = "UPDATE Widget SET name = ?, width = ?, height = ?, cssClass = ?, cssStyle = ?, text = ?, order = ?, type = ?, src = ? where id = ?";

	private final String UPDATE_WIDGET_YOUTUBE = "UPDATE Widget SET name = ?, width = ?, height = ?, cssClass = ?, cssStyle = ?, text = ?, order = ?, type = ?, url = ?, shareble = ?, expandable = ? where id = ?";

	private final String DELETE_WIDGET = "DELETE FROM Widget WHERE id = ?";
	
	private final String LAST_WIDGET = "SELECT w.id FROM Page p, Widget w WHERE w.page = p.id AND p.title = ? "
			 +" AND w.order = (SELECT t.highestOrder FROM (SELECT MAX(w.order) AS highestOrder FROM Widget w) AS t)";


	// 1. int createWidgetForPage(int pageId, Widget widget)

	public int createWidgetForPage(int pageId, Widget widget) {

		int result = 0;

		if (widget instanceof HeadingWidget) {

			result = createHeadingTypeWidget(pageId, (HeadingWidget) widget);
		}

		else if (widget instanceof HtmlWidget) {

			result = createHtmlTypeWidget(pageId, (HtmlWidget) widget);
		}

		else if (widget instanceof ImageWidget) {

			result = createImageTypeWidget(pageId, (ImageWidget) widget);
		}

		else if (widget instanceof YouTubeWidget) {

			result = createYouTubeTypeWidget(pageId, (YouTubeWidget) widget);

		}

		return result;
	}

	public int createHeadingTypeWidget(int pageId, HeadingWidget widget) {

		int result = 0;
		int defaultSize = 2;

		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_WIDGET_HEADING);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());

			if (widget.getSize() < defaultSize) {

				stmt.setInt(9, defaultSize);
			} else
				stmt.setInt(9, widget.getSize());
			stmt.setInt(10, pageId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	public int createHtmlTypeWidget(int pageId, HtmlWidget widget) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_WIDGET_HTML);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setString(9, widget.getHtml());
			stmt.setInt(10, pageId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	public int createImageTypeWidget(int pageId, ImageWidget widget) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_WIDGET_IMAGE);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setString(9, widget.getSrc());
			stmt.setInt(10, pageId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	public int createYouTubeTypeWidget(int pageId, YouTubeWidget widget) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_WIDGET_YOUTUBE);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setString(9, widget.getUrl());
			stmt.setBoolean(10, widget.isShareble());
			stmt.setBoolean(11, widget.isExpandable());
			stmt.setInt(12, pageId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	// 2. Collection<Widget> findAllWidgets()

	public Collection<Widget> findAllWidgets() {

		PreparedStatement stmt = null;
		Collection<Widget> widgets = new ArrayList<Widget>();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_ALL_WIDGETS);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				int id = result.getInt("id");
				String name = result.getString("name");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String cssClass = result.getString("cssClass");
				String cssStyle = result.getString("cssStyle");
				String text = result.getString("text");
				int order = result.getInt("order");
				String type = result.getString("type");
				int size = result.getInt("size");
				String html = result.getString("html");
				String src = result.getString("src");
				String url = result.getString("url");
				boolean shareble = result.getBoolean("shareble");
				boolean expandable = result.getBoolean("expandable");

				if (type.equals("heading")) {

					Widget widget = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							size);
					widgets.add(widget);
				}

				if (type.equals("html")) {

					Widget widget = new HtmlWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							html);
					widgets.add(widget);
				}

				if (type.equals("image")) {

					Widget widget = new ImageWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							src);
					widgets.add(widget);
				}

				if (type.equals("youtube")) {

					Widget widget = new YouTubeWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							url, shareble, expandable);
					widgets.add(widget);

				}
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		
		return widgets;

	}

	// 3. Widget findWidgetById(int widgetId)

	public Widget findWidgetById(int widgetId) {

		PreparedStatement stmt = null;
		Widget widget = new Widget();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_WIDGET_BY_ID);

			stmt.setInt(1, widgetId);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {

				int id = result.getInt("id");
				String name = result.getString("name");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String cssClass = result.getString("cssClass");
				String cssStyle = result.getString("cssStyle");
				String text = result.getString("text");
				int order = result.getInt("order");
				String type = result.getString("type");
				int size = result.getInt("size");
				String html = result.getString("html");
				String src = result.getString("src");
				String url = result.getString("url");
				boolean shareble = result.getBoolean("shareble");
				boolean expandable = result.getBoolean("expandable");

				if (type.equals("heading")) {

					widget = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, type, size);
				}

				if (type.equals("html")) {

					widget = new HtmlWidget(id, name, width, height, cssClass, cssStyle, text, order, type, html);
				}

				if (type.equals("image")) {

					widget = new ImageWidget(id, name, width, height, cssClass, cssStyle, text, order, type, src);

				}

				if (type.equals("youtube")) {

					widget = new YouTubeWidget(id, name, width, height, cssClass, cssStyle, text, order, type, url,
							shareble, expandable);

				}
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		
		return widget;
	}

	// 4. Collection<Widget> findWidgetsForPage(int pageId)

	public Collection<Widget> findWidgetsForPage(int pageId) {

		PreparedStatement stmt = null;
		Collection<Widget> widgets = new ArrayList<Widget>();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_WIDGET_FOR_PAGE);
			stmt.setInt(1, pageId);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				int id = result.getInt("id");
				String name = result.getString("name");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String cssClass = result.getString("cssClass");
				String cssStyle = result.getString("cssStyle");
				String text = result.getString("text");
				int order = result.getInt("order");
				String type = result.getString("type");
				int size = result.getInt("size");
				String html = result.getString("html");
				String src = result.getString("src");
				String url = result.getString("url");
				boolean shareble = result.getBoolean("shareble");
				boolean expandable = result.getBoolean("expandable");

				if (type.equals("heading")) {

					Widget widget = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							size);
					widgets.add(widget);
				}

				if (type.equals("html")) {

					Widget widget = new HtmlWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							html);
					widgets.add(widget);
				}

				if (type.equals("image")) {

					Widget widget = new ImageWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							src);
					widgets.add(widget);
				}

				if (type.equals("youtube")) {

					Widget widget = new YouTubeWidget(id, name, width, height, cssClass, cssStyle, text, order, type,
							url, shareble, expandable);
					widgets.add(widget);

				}
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		
		return widgets;

	}

	// 5. int updateWidget(int widgetId, Widget widget)

	public int updateWidget(int widgetId, Widget widget) {
		int result = 0;

		String type = widget.getType();

		if (type.equals("html")) {

			result = updateHtmlWidget(widgetId, (HtmlWidget) widget);
		}

		else if (type.equals("heading")) {

			result = updateHeadingWidget(widgetId, (HeadingWidget) widget);

		}

		else if (type.equals("image")) {

			result = updateImageWidget(widgetId, (ImageWidget) widget);
		}

		else if (type.equals("youtube")) {

			result = updateYouTubeWidget(widgetId, (YouTubeWidget) widget);

		}

		return result;
	}

	public int updateHtmlWidget(int widgetId, HtmlWidget widget) {

		PreparedStatement stmt = null;
		int result = 0;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_WIDGET_HTML);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setString(9, widget.getHtml());
			stmt.setInt(10, widgetId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	public int updateHeadingWidget(int widgetId, HeadingWidget widget) {

		PreparedStatement stmt = null;
		int result = 0;
		int defaultSize = 2;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_WIDGET_HEADING);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setInt(10, widgetId);

			if (widget.getSize() < defaultSize) {

				stmt.setInt(9, defaultSize);
			} else
				stmt.setInt(9, widget.getSize());

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	public int updateImageWidget(int widgetId, ImageWidget widget) {

		PreparedStatement stmt = null;
		int result = 0;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_WIDGET_IMAGE);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setString(9, widget.getSrc());
			stmt.setInt(10, widgetId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	public int updateYouTubeWidget(int widgetId, YouTubeWidget widget) {

		PreparedStatement stmt = null;
		int result = 0;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_WIDGET_YOUTUBE);
			stmt.setString(1, widget.getName());
			stmt.setInt(2, widget.getWidth());
			stmt.setInt(3, widget.getHeight());
			stmt.setString(4, widget.getCssClass());
			stmt.setString(5, widget.getCssStyle());
			stmt.setString(6, widget.getText());
			stmt.setInt(7, widget.getOrder());
			stmt.setString(8, widget.getType());
			stmt.setString(9, widget.getUrl());
			stmt.setBoolean(10, widget.isShareble());
			stmt.setBoolean(11, widget.isExpandable());
			stmt.setInt(12, widgetId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	// 6. int deleteWidget(int widgetId)

	public int deleteWidget(int widgetId) {

		int result = 0;
		PreparedStatement stmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_WIDGET);
			stmt.setInt(1, widgetId);

			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;
	}
	
	
public int HighestOrderWidget(String pageTitle) {
		
		int widgetId = -1;
		PreparedStatement stmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(LAST_WIDGET);
			
			stmt.setString(1, pageTitle);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				
				widgetId = result.getInt("id");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {

			try {

				stmt.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		return widgetId;
		
		
	}

	public void printAllWidgets(Collection<Widget> widgets) {

		for (Widget w : widgets) {
			printWidget(w);

		}

	}

	public void printWidget(Widget w) {

		System.out.print(w.getId() + " ");
		System.out.print(w.getName() + " ");
		System.out.print(w.getWidth() + " ");
		System.out.print(w.getHeight() + " ");
		System.out.print(w.getCssClass() + " ");
		System.out.print(w.getCssStyle() + " ");
		System.out.print(w.getText() + " ");
		System.out.print(w.getOrder() + " ");
		System.out.print(w.getType() + " ");

		if (w.getType().equals("heading")) {
			System.out.print(((HeadingWidget) w).getSize() + " ");
		}

		if (w.getType().equals("html")) {

			System.out.print(((HtmlWidget) w).getHtml() + " ");
		}

		if (w.getType().equals("image")) {

			System.out.print(((ImageWidget) w).getSrc() + " ");
		}

		if (w.getType().equals("youtube")) {

			System.out.print(((YouTubeWidget) w).getUrl() + " ");
			System.out.print(((YouTubeWidget) w).isShareble() + " ");
			System.out.print(((YouTubeWidget) w).isExpandable() + "\n ");
		}
	}

}
