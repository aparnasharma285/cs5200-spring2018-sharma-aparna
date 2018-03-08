package assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

import assignment.models.Developer;

public class DeveloperDao extends ConnectionDao {

	public static DeveloperDao instance = null;

	public static DeveloperDao getInstance() {

		if (instance == null) {
			instance = new DeveloperDao();
		}

		return instance;
	}

	private final String CREATE_PERSON = "INSERT INTO Person (firstName, lastName, username, password, email)"
			+ "VALUES (?,?,?,?,?)";
	private final String CREATE_DEVELOPER = "INSERT INTO Developer (id, devKey) VALUES(?,?)";

	private final String FIND_ALL_DEVELOPERS = "SELECT * FROM Developer d, Person p where d.id = p.id";

	private final String FIND_DEVELOPER_BY_ID = "SELECT * FROM Developer d, Person p where d.id = p.id and d.id = ?";

	private final String FIND_DEVELOPER_BY_USERNAME = "SELECT * FROM Developer d, Person p where d.id = p.id and p.username = ?";

	private final String FIND_DEVELOPER_BY_CREDENTIALS = "SELECT * FROM Developer d, Person p where d.id = p.id and p.username = ? and p.password = ?";

	private final String UPDATE_DEVELOPER = "UPDATE Developer d, Person p set p.firstName = ? p.lastName =?, p.username =?, p.password =?, p.email = ?, p.dob =?, d.devKey =? where p.id = d.id and d.id =?";

	private final String DELETE_DEVELOPER = "DELETE FROM Person where id = ? ";

	private final String DELETE_PRIMARY_ADDRESS = "DELETE FROM Address WHERE person = ? AND `primary` = 1";
	
	private final String UPDATE_PRIMARY_PHONE = "UPDATE Phone SET `primary` = CASE WHEN (`number` = ?) THEN TRUE ELSE FALSE END WHERE person = ?";
	
	// 1. int createDeveloper(Developer developer)

	public int createDeveloper(Developer developer) {

		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int result = 0;
		int developerId;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(CREATE_PERSON, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, developer.getFirstName());
			stmt.setString(2, developer.getLastName());
			stmt.setString(3, developer.getUsername());
			stmt.setString(4, developer.getPassword());
			stmt.setString(5, developer.getEmail());
			

			result = stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();

			if (key.next()) {

				developerId = key.getInt(1);
			} else {

				throw new SQLException();
			}
			stmt1 = con.prepareStatement(CREATE_DEVELOPER);

			stmt1.setInt(1, developerId);
			stmt1.setString(2, developer.getDevKey());
			result = stmt1.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				stmt1.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;

	}

	// 2.Collection<Developer> findAllDevelopers()

	public Collection<Developer> findAllDevelopers() {

		Collection<Developer> developers = new ArrayList<Developer>();

		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_ALL_DEVELOPERS);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				Developer developer = new Developer();
				int developerId = result.getInt("id");

				developer.setId(developerId);
				developer.setFirstName(result.getString("firstName"));
				developer.setLastName(result.getString("lastName"));
				developer.setUsername(result.getString("username"));
				developer.setPassword(result.getString("password"));
				developer.setEmail(result.getString("email"));
				developer.setDob(result.getDate("dob"));
				developer.setDevKey(result.getString("devKey"));
				developer.setWebsites(WebsiteDao.getInstance().findWebsitesForDeveloper(developerId));
				developers.add(developer);
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
		printAllDevelopers(developers);
		return developers;
	}

	// 3. Developer findDeveloperById(int developerId)

	public Developer findDeveloperById(int developerId) {

		PreparedStatement stmt = null;
		Developer developer = new Developer();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_DEVELOPER_BY_ID);
			stmt.setInt(1, developerId);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {

				developer.setId(result.getInt("id"));
				developer.setFirstName(result.getString("firstName"));
				developer.setLastName(result.getString("lastName"));
				developer.setUsername(result.getString("username"));
				developer.setPassword(result.getString("password"));
				developer.setEmail(result.getString("email"));
				developer.setDob(result.getDate("dob"));
				developer.setDevKey(result.getString("devKey"));
				developer.setWebsites(WebsiteDao.getInstance().findWebsitesForDeveloper(developerId));

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

		
		return developer;
	}

	// 4. Developer findDeveloperByUsername(String username)

	public Developer findDeveloperByUsername(String username) {

		PreparedStatement stmt = null;
		Developer developer = new Developer();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
			stmt.setString(1, username);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {

				int id = result.getInt("id");
				developer.setId(id);
				developer.setFirstName(result.getString("firstName"));
				developer.setLastName(result.getString("lastName"));
				developer.setUsername(result.getString("username"));
				developer.setPassword(result.getString("password"));
				developer.setEmail(result.getString("email"));
				developer.setDob(result.getDate("dob"));
				developer.setDevKey(result.getString("devKey"));
				developer.setWebsites(WebsiteDao.getInstance().findWebsitesForDeveloper(id));

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

		return developer;
	}

	// 5. Developer findDeveloperByCredentials(String username, String password)

	public Developer findDeveloperByCredentials(String username, String password) {

		PreparedStatement stmt = null;
		Developer developer = new Developer();

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(FIND_DEVELOPER_BY_CREDENTIALS);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {

				int id = result.getInt("id");
				developer.setId(id);
				developer.setFirstName(result.getString("firstName"));
				developer.setLastName(result.getString("lastName"));
				developer.setUsername(result.getString("username"));
				developer.setPassword(result.getString("password"));
				developer.setEmail(result.getString("email"));
				developer.setDob(result.getDate("dob"));
				developer.setDevKey(result.getString("devKey"));
				developer.setWebsites(WebsiteDao.getInstance().findWebsitesForDeveloper(id));

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
	
		return developer;
	}

	// 6. int updateDeveloper(int developerId, Developer developer)

	public int updateDeveloper(int developerId, Developer developer) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_DEVELOPER);

			stmt.setString(1, developer.getFirstName());
			stmt.setString(2, developer.getLastName());
			stmt.setString(3, developer.getUsername());
			stmt.setString(4, developer.getPassword());
			stmt.setString(5, developer.getEmail());
			stmt.setDate(6, (Date) developer.getDob());
			stmt.setString(7, developer.getDevKey());
			stmt.setInt(8, developerId);

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

	// 7. int deleteDeveloper(int developerId)

	public int deleteDeveloper(int developerId) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_DEVELOPER);

			stmt.setInt(1, developerId);

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
	
	public int deletePrimaryAddress(int devId) {

		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(DELETE_PRIMARY_ADDRESS);

			stmt.setInt(1, devId);

			result = stmt.executeUpdate();
			
			if(result == 0) {
				
				System.out.println("No Primary Address found for the given User");
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
		return result;

	}
	
	// Update primary phone number
	public int updatePrimaryPhone(String number, int devId) {
		int result = 0;
		PreparedStatement stmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.prepareStatement(UPDATE_PRIMARY_PHONE);

			stmt.setString(1, number);
			stmt.setInt(2, devId);

			result = stmt.executeUpdate();
			
			if(result == 0) {
				
				System.out.println("No Phone found");
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
		return result;
	}

	public void printAllDevelopers(Collection<Developer> developers) {

		for (Developer d : developers) {
			
			printDeveloper(d);
			
		}

	}
	
	public void printDeveloper(Developer d) {
		
		System.out.print(d.getId() + " ");
		System.out.print(d.getFirstName() + " ");
		System.out.print(d.getLastName() + " ");
		System.out.print(d.getUsername() + " ");
		System.out.print(d.getPassword() + " ");
		System.out.print(d.getEmail() + " ");
		System.out.print(d.getDob() + " ");
		System.out.print(d.getDevKey() + "\n");
		
	}
}
