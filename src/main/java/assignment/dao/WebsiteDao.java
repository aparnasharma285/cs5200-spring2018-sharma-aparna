package assignment.dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import assignment.models.Website;

public class WebsiteDao extends ConnectionDao {

	public static WebsiteDao instance = null;

	public static WebsiteDao getInstance() {

		if (instance == null) {
			instance = new WebsiteDao();
		}

		return instance;
	}

	private final String CREATE_WEBSITE = "INSERT INTO Website (name, description, created, updated, visits, developer) VALUES (?,?,curdate(),curdate(),?,?)";

	private final String FIND_ALL_WEBSITES = "SELECT * FROM Website";

	private final String FIND_WEBSITE_FOR_DEVELOPER = "SELECT * FROM Website WHERE developer = ?";

	private final String FIND_WEBSITE_BY_ID = "SELECT * FROM Website WHERE id = ?";

	private final String UPDATE_WEBSITE = "UPDATE Website SET name = ? , description = ?, created = ? , updated = ? , visits = ? WHERE id = ?";

	private final String DELETE_WEBSITE = "DELETE FROM Website WHERE id = ?";

	private final String FIND_WEBSITE_ID = "SELECT id FROM Website where name = ?";
	
	// 1. int createWebsiteForDeveloper(int developerId, Website website)

	public int createWebsiteForDeveloper(int developerId, Website website) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_WEBSITE);

			stmt.setString(1, website.getName());
			stmt.setString(2, website.getDescription());
			stmt.setInt(3, website.getVisits());
			stmt.setInt(4, developerId);

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

	// 2. Collection<Website> findAllWebsites()

	public Collection<Website> findAllWebsites() {

		PreparedStatement stmt = null;
		Collection<Website> websites = new ArrayList<Website>();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_ALL_WEBSITES);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				Website website = new Website();

				int id = result.getInt("id");
				website.setId(id);
				website.setName(result.getString("name"));
				website.setDescription(result.getString("description"));
				website.setCreated(result.getDate("created"));
				website.setUpdated(result.getDate("updated"));
				website.setVisits(result.getInt("visits"));
				website.setPages(PageDao.getInstance().findPagesForWebsite(id));

				websites.add(website);
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

		
		return websites;

	}

	// 3. Collection<Website> findWebsitesForDeveloper(int developerId)

	public Collection<Website> findWebsitesForDeveloper(int developerId) {

		PreparedStatement stmt = null;
		Collection<Website> websites = new ArrayList<Website>();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_WEBSITE_FOR_DEVELOPER);
			stmt.setInt(1, developerId);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				Website website = new Website();

				int id = result.getInt("id");
				website.setId(id);
				website.setName(result.getString("name"));
				website.setDescription(result.getString("description"));
				website.setCreated(result.getDate("created"));
				website.setUpdated(result.getDate("updated"));
				website.setVisits(result.getInt("visits"));
				website.setPages(PageDao.getInstance().findPagesForWebsite(id));

				websites.add(website);
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

	
		return websites;

	}

	// 4. Website findWebsiteById(int websiteId)

	public Website findWebsiteById(int websiteId) {

		PreparedStatement stmt = null;
		Website website = new Website();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_WEBSITE_BY_ID);

			stmt.setInt(1, websiteId);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");

				website.setId(id);
				website.setName(result.getString("name"));
				website.setDescription(result.getString("description"));
				website.setCreated(result.getDate("created"));
				website.setUpdated(result.getDate("updated"));
				website.setVisits(result.getInt("visits"));
				website.setPages(PageDao.getInstance().findPagesForWebsite(id));
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

		
		return website;

	}

	// 5. int updateWebsite(int websiteId, Website website)

	int updateWebsite(int websiteId, Website website) {

		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_WEBSITE);

			stmt.setString(1, website.getName());
			stmt.setString(2, website.getDescription());
			stmt.setDate(3, (Date) website.getCreated());
			stmt.setDate(4, (Date) website.getUpdated());
			stmt.setInt(5, website.getVisits());
			stmt.setInt(6, websiteId);

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

	// 6. int deleteWebsite(int websiteId)

	public int deleteWebsite(int websiteId) {

		int result = 0;
		PreparedStatement stmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_WEBSITE);
			stmt.setInt(1, websiteId);

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

	public int findWebsiteId(String websiteName) {
		
		PreparedStatement stmt = null;
		int websiteId = -1;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_WEBSITE_ID);
			stmt.setString(1, websiteName);

			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				
				websiteId = result.getInt("id");
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

		return websiteId;
		
	}
	public void printAllWebsites(Collection<Website> websites) {

		for (Website w : websites) {

			printWebsite(w);

		}

	}

	public void printWebsite(Website w) {

		System.out.print(w.getId() + " ");
		System.out.print(w.getName() + " ");
		System.out.print(w.getDescription() + " ");
		System.out.print(w.getCreated() + " ");
		System.out.print(w.getUpdated() + " ");
		System.out.print(w.getVisits() + "\n");
	}
}