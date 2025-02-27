import java.sql.*;
import java.util.*;

public class Login {

    //Declares private variables that will be initialized and used in this class
    private String username;
    private String password;
    private static Statement statement;
    private String privilege;

    //Initializes the username, password and privilege
    public Login(String username, String password, String privilege) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    //Connects to the database
    public static Connection getConnection() throws Exception {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:test-arena.db"); //Connects to the database
        } catch(SQLException e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        return connection;
    }

    //Creates the users table
    public static void createUsersTable() throws Exception {
        try{
            Connection connection = getConnection(); //Gets the connection from the getConnection() method
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            //Creates the table with columns id, username, password and privilege
            statement.executeQuery("CREATE TABLE users (id INT AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255), privilege VARCHAR(255), PRIMARY KEY (id))"); 
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Checks if the username and password a user enters matches a username and password combination in the users table
    public boolean verifyLogin() throws Exception {
        try{
            ResultSet getUsers = statement.executeQuery("SELECT * FROM users"); //Gets all the rows from the table
            while(getUsers.next()) { //Loops through all the rows and gets the username and password from each row
                String username = getUsers.getString(2);
                String password = getUsers.getString(3);
                if(username.equals(this.username) && password.equals(this.password)) //Returns true if there is a username and pasword combination that matches the one the user entered
                    return true;
            }
        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        return false;
    }

    //Adds a user to the users table when they sign up
    public void signUp() throws Exception {
        try{
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('" + this.username + "', '" + this.password + "','" +  this.privilege + "')"); //Adds a user to the table
        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
    }

    //Verify's the password that the user uses when signing up
    public boolean verifyPassword(String pass) {
        return this.password == pass;
    }

    //Gets the number of users that have an account on the systems (i.e. the number of rows in the users table)
    public int usersCount() throws Exception {
        int numberOfUsers = 0;
        try {
            ResultSet usersCountQuery = statement.executeQuery("SELECT COUNT(*) FROM users"); //Gets the number of users
            usersCountQuery.next();
            numberOfUsers = usersCountQuery.getInt(1); //Converts the value into an integer
        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        return numberOfUsers;
    }

    //Checks if the person logging in has user or admin privilege
    public String checkPrivilige() throws Exception{
        ResultSet userPrivilege = null;
        try {
            userPrivilege = statement.executeQuery("SELECT privilege FROM users WHERE username ='" + this.username + "'" + "AND password ='"+ this.password + "'");
            userPrivilege.next();
        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        return userPrivilege.getString(4); //Converts the value it retrieves from the column as a string and returns it
    }

    //Returns the user's password
    public String getPassword() {
        return this.password;
    }

    //Sets the user's password to the argument that was passed to the function
    public void setPassword(String pass) {
        this.password.equals(pass);
    }

    //Returns the user's username
    public String getUsername() {
        return this.username;
    }

    //Sets the user's username to the argument that was passed to the function
    public void setUsername(String usr) {
        this.username = usr;
    }

    //Returns the privilege of the user
    public String getPrivilege() {
        return this.privilege;
    }

    //Sets the user's privilege to the argument that was passed to the function
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
} 