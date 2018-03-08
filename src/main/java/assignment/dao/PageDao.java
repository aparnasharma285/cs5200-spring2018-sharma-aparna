package assignment.dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import assignment.models.Page;

public class PageDao extends ConnectionDao {

	public static PageDao instance = null;

	public static PageDao getInstance() {

		if (instance == null) {
			instance = new PageDao();
		}

		return instance;
	}

	private final String CREATE_PAGE = "INSERT INTO Page (title, description, created, updated, views, website) VALUES (?, ?, curdate(),curdate(), ?, ?)";

	private final String FIND_ALL_PAGES = "SELECT * FROM Page";

	private final String FIND_PAGE_BY_ID = "SELECT * FROM Page p WHERE p.id = ?";

	private final String FIND_PAGE_FOR_WEBSITE = "SELECT * FROM Page WHERE website = ?";

	private final String UPDATE_PAGE = "UPDATE Page SET title = ? , description = ?, created = ? , updated = ? , views = ? WHERE id = ?";

	private final String DELETE_PAGE = "DELETE FROM Page WHERE id = ?";

	private final String FIND_PAGE_ID = "SELECT id FROM Page p WHERE p.title = ? and p.website = ?";
	
	private final String LAST_UPDATED_PAGE = "SELECT p.id FROM Page p, Website w WHERE p.website = w.id AND w.name = ? "
											 +" AND p.updated = (SELECT t.lastDate FROM (SELECT MAX(p.updated) AS lastDate FROM Page p) t)";
	
	// 1. int createPageForWebsite(int websiteId, Page page)

	public int createPageForWebsite(int websiteId, Page page) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_PAGE);

			stmt.setString(1, page.getTitle());
			stmt.setString(2, page.getDescription());
			stmt.setInt(3, page.getViews());
			stmt.setInt(4, websiteId);

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

	// 2. Collection<Page> findAllPages()

	public Collection<Page> findAllPages() {

		PreparedStatement stmt = null;
		Collection<Page> pages = new ArrayList<Page>();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_ALL_PAGES);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				Page page = new Page();

				int id = result.getInt("id");
				page.setId(id);
				page.setTitle(result.getString("title"));
				page.setDescription(result.getString("description"));
				page.setCreated(result.getDate("created"));
				page.setUpdated(result.getDate("updated"));
				page.setViews(result.getInt("views"));
				page.setWidgets(WidgetDao.getInstance().findWidgetsForPage(id));

				pages.add(page);
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

		return pages;

	}

	// 3. Collection<Page> findPageById(int pageId)

	public Page findPageById(int pageId) {

		PreparedStatement stmt = null;
		Page page = new Page();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_PAGE_BY_ID);

			stmt.setInt(1, pageId);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");

				page.setId(id);
				page.setTitle(result.getString("title"));
				page.setDescription(result.getString("description"));
				page.setCreated(result.getDate("created"));
				page.setUpdated(result.getDate("updated"));
				page.setViews(result.getInt("views"));
				page.setWidgets(WidgetDao.getInstance().findWidgetsForPage(id));
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

		return page;
	}

	// 4. Collection<Page> findPagesForWebsite(int websiteId)

	public Collection<Page> findPagesForWebsite(int websiteId) {

		PreparedStatement stmt = null;
		Collection<Page> pages = new ArrayList<Page>();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_PAGE_FOR_WEBSITE);
			stmt.setInt(1, websiteId);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				Page page = new Page();

				int id = result.getInt("id");
				page.setId(id);
				page.setTitle(result.getString("title"));
				page.setDescription(result.getString("description"));
				page.setCreated(result.getDate("created"));
				page.setUpdated(result.getDate("updated"));
				page.setViews(result.getInt("views"));
				page.setWidgets(WidgetDao.getInstance().findWidgetsForPage(id));

				pages.add(page);
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

	
		return pages;

	}

	// 5. int updatePage(int pageId, Page page)

	public int updatePage(int pageId, Page page) {

		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_PAGE);

			stmt.setString(1, page.getTitle());
			stmt.setString(2, page.getDescription());
			stmt.setDate(3, (Date) page.getCreated());
			stmt.setDate(4, (Date) page.getUpdated());
			stmt.setInt(5, page.getViews());
			stmt.setInt(6, pageId);

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

	// 6. int deletePage(int pageId)

	public int deletePage(int pageId) {

		int result = 0;
		PreparedStatement stmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_PAGE);
			stmt.setInt(1, pageId);

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

	
	public int findPageId(String title, int websiteId) {
		
		PreparedStatement stmt = null;
		int pageId = -1;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_PAGE_ID);
			stmt.setString(1, title);
			stmt.setInt(2, websiteId);

			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				
				pageId = result.getInt("id");
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

		return pageId;
	}
	
	public int lastUpdated(String websiteName) {
		
		int pageId = -1;
		PreparedStatement stmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(LAST_UPDATED_PAGE);
			
			stmt.setString(1, websiteName);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				
				pageId = result.getInt("id");
				
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
		
		return pageId;
		
		
	}
	
	
	public void printAllPages(Collection<Page> pages) {

		for (Page p : pages) {

			printPage(p);

		}
	}

	public void printPage(Page p) {

		System.out.print(p.getId() + " ");
		System.out.print(p.getTitle() + " ");
		System.out.print(p.getDescription() + " ");
		System.out.print(p.getCreated() + " ");
		System.out.print(p.getUpdated() + " ");
		System.out.print(p.getViews() + "\n");
		
		
	}
	
	
}
