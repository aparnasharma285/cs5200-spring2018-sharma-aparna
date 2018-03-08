package assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumerationDao extends ConnectionDao {

	public static EnumerationDao instance = null;

	public static EnumerationDao getInstance() {

		if (instance == null) {
			instance = new EnumerationDao();
		}

		return instance;
	}

	private final String CREATE_ROLE_ENUM = "INSERT INTO Role (role)  VALUES (?)";
	private final String CREATE_PRIVILEDGE_ENUM = "INSERT INTO Priviledge (priviledge) VALUES (?)";
	private final String FIND_ROLE_ID = "SELECT id FROM Role WHERE role = ?";
	private final String FIND_PRIVILEDGE_ID = "SELECT id FROM Priviledge WHERE priviledge = ?";

	// For Adding new roles

	public int addRole(String role) {

		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_ROLE_ENUM);
			stmt.setString(1, role);

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
	
	public int addPriviledge(String priviledge) {

		PreparedStatement stmt = null;
		int result = 0;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_PRIVILEDGE_ENUM);
			stmt.setString(1, priviledge);

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
	
	public int findRoleId(String role) {
		
		PreparedStatement stmt = null;
		int roleId = -1;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_ROLE_ID);
			stmt.setString(1, role);

			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				roleId = result.getInt("id");
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
		
		return roleId;
		
	}
	
public int findPriviledgeId(String priviledge) {
		
		PreparedStatement stmt = null;
		int roleId = -1;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_PRIVILEDGE_ID);
			stmt.setString(1, priviledge);

			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				roleId = result.getInt("id");
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
		
		return roleId;
		
	}
}
