package assignment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import assignment.models.User;

public class UserDao extends ConnectionDao {

	public static UserDao instance = null;

	public static UserDao getInstance() {

		if (instance == null) {
			instance = new UserDao();
		}

		return instance;
	}
	
	private final String CREATE_PERSON = "INSERT INTO Person (firstName, lastName, username, password, email)"
			+ "VALUES (?,?,?,?,?)";
	private final String CREATE_USER = "INSERT INTO User (id, userAgreement,userKey) VALUES(?,?,?)";
	
	private final String FIND_USER_BY_ID = "SELECT * FROM User u, Person p where u.id = p.id and u.id = ?";
	
	private final String FIND_ALL_USERS = "SELECT * FROM User u, Person p where u.id = p.id";
	
	// createUser(User user)

		public int createUser(User user) {

			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			int result = 0;
			int userId;

			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				stmt = con.prepareStatement(CREATE_PERSON, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, user.getFirstName());
				stmt.setString(2, user.getLastName());
				stmt.setString(3, user.getUsername());
				stmt.setString(4, user.getPassword());
				stmt.setString(5, user.getEmail());

				result = stmt.executeUpdate();
				ResultSet key = stmt.getGeneratedKeys();

				if (key.next()) {

					userId = key.getInt(1);
				} else {

					throw new SQLException();
				}
				stmt1 = con.prepareStatement(CREATE_USER);

				stmt1.setInt(1, userId);
				stmt1.setBoolean(2, user.isUserAgreement());
				stmt1.setString(3, user.getUserKey());
				result = stmt1.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}  finally {

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
		
		
		// User findUserById(int userId)

		public User findUserById(int userId) {

			PreparedStatement stmt = null;
			User user = new User();

			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				stmt = con.prepareStatement(FIND_USER_BY_ID);
				stmt.setInt(1, userId);
				ResultSet result = stmt.executeQuery();

				if (result.next()) {

					user.setId(result.getInt("id"));
					user.setFirstName(result.getString("firstName"));
					user.setLastName(result.getString("lastName"));
					user.setUsername(result.getString("username"));
					user.setPassword(result.getString("password"));
					user.setEmail(result.getString("email"));
					user.setDob(result.getDate("dob"));
					user.setUserKey(result.getString("userKey"));
					user.setUserAgreement(result.getBoolean("userAgreement"));
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

			return user;
		}
		
		// Collection<User> findAllUsers()
		
		public Collection<User> findAllUsers(){
			
			Collection<User> users = new ArrayList<User>();

			PreparedStatement stmt = null;

			try {
				Class.forName(DRIVER);
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				stmt = con.prepareStatement(FIND_ALL_USERS);
				ResultSet result = stmt.executeQuery();

				while (result.next()) {
					
					User user = new User();
					int userId = result.getInt("id");
					
					user.setId(userId);
					user.setFirstName(result.getString("firstName"));
					user.setLastName(result.getString("lastName"));
					user.setUsername(result.getString("username"));
					user.setPassword(result.getString("password"));
					user.setEmail(result.getString("email"));
					user.setDob(result.getDate("dob"));
					user.setUserKey(result.getString("userKey"));
					user.setUserAgreement(result.getBoolean("userAgreement"));
					users.add(user);
				}

			} catch (ClassNotFoundException | SQLException e){

				e.printStackTrace();
			} finally {

				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

			printAllUsers(users);
			return users;
		}
		
		

		public void printAllUsers(Collection<User> users) {

			for (User u : users) {
				
				printUser(u);
				
			}

		}
		
		public void printUser(User u) {
			
			System.out.print(u.getId() + " ");
			System.out.print(u.getFirstName() + " ");
			System.out.print(u.getLastName() + " ");
			System.out.print(u.getUsername() + " ");
			System.out.print(u.getPassword() + " ");
			System.out.print(u.getEmail() + " ");
			System.out.print(u.getDob() + " ");
			System.out.print(u.isUserAgreement() + " ");
			System.out.print(u.getUserKey() + "\n");
		
			
		}
}
