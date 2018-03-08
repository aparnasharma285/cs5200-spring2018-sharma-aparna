package assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrivilegeDao extends ConnectionDao {
	
	public static PrivilegeDao instance = null;

	public static PrivilegeDao getInstance() {
		
		if (instance == null) {
			instance = new PrivilegeDao();
		}
		
		return instance;
	}

	
	private final String ASSIGN_WEBSITE_PRIVILEGE = "INSERT INTO WebsitePriviledge (priviledge, website, developer) VALUES(?, ?, ?)";

	private final String ASSIGN_PAGE_PRIVILEGE = "INSERT INTO PagePriviledge (priviledge, page, developer) VALUES(?, ?, ?)";

	private final String DELETE_WEBSITE_PRIVILEGE = "DELETE FROM WebsitePriviledge where developer = ? and priviledge = ? and website = ?";

	private final String DELETE_PAGE_PRIVILEGE = "DELETE FROM PagePriviledge where developer = ? and priviledge = ? and page = ?";

	
	public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(ASSIGN_WEBSITE_PRIVILEGE);
			stmt.setInt(1, priviledgeId);
			stmt.setInt(2, websiteId);
			stmt.setInt(3, developerId);

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
	
	public int assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(ASSIGN_PAGE_PRIVILEGE);
			stmt.setInt(1, priviledgeId);
			stmt.setInt(2, pageId);
			stmt.setInt(3, developerId);

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
	
	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_WEBSITE_PRIVILEGE);
			stmt.setInt(1, developerId);
			stmt.setInt(2, priviledgeId);
			stmt.setInt(3, websiteId);

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

	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_PAGE_PRIVILEGE);
			stmt.setInt(1, developerId);
			stmt.setInt(2, priviledgeId);
			stmt.setInt(3, pageId);

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
	
}