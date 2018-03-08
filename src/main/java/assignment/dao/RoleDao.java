package assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RoleDao extends ConnectionDao {

	public static RoleDao instance = null;

	public static RoleDao getInstance() {

		if (instance == null) {
			instance = new RoleDao();
		}

		return instance;
	}

	private final String ASSIGN_WEBSITE_ROLE = "INSERT INTO WebsiteRole (role, website, developer) VALUES(?, ?, ?)";

	private final String ASSIGN_PAGE_ROLE = "INSERT INTO PageRole (role, page, developer) VALUES(?, ?, ?)";

	private final String DELETE_WEBSITE_ROLE = "DELETE FROM WebsiteRole WHERE developer = ? AND role = ? AND website = ?";

	private final String DELETE_PAGE_ROLE = "DELETE FROM PageRole WHERE developer = ? AND role = ? and page = ?";

	private final String SWAP_DEVELOPERS_PAGE_ROLE = "UPDATE PageRole SET developer = CASE developer WHEN (?) THEN (?) WHEN (?) THEN (?) END"
													  + " WHERE developer IN (?,?) AND page = ?";
	public int assignWebsiteRole(int developerId, int websiteId, int roleId) {

		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(ASSIGN_WEBSITE_ROLE);
			stmt.setInt(1, roleId);
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

	public int assignPageRole(int developerId, int pageId, int roleId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(ASSIGN_PAGE_ROLE);
			stmt.setInt(1, roleId);
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

	public int deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_WEBSITE_ROLE);
			stmt.setInt(1, developerId);
			stmt.setInt(2, roleId);
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

	public int deletePageRole(int developerId, int pageId, int roleId) {
		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_PAGE_ROLE);
			stmt.setInt(1, developerId);
			stmt.setInt(2, roleId);
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
	
	public int swapDevelopersPageRole(int developerId1, int developerId2, int page) {
		
		int result = 0;
		PreparedStatement stmt = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(SWAP_DEVELOPERS_PAGE_ROLE);
			
			stmt.setInt(1, developerId1);
			stmt.setInt(2, developerId2);
			stmt.setInt(3, developerId2);
			stmt.setInt(4, developerId1);
			stmt.setInt(5, developerId1);
			stmt.setInt(6, developerId2);
			stmt.setInt(7, page);
			
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