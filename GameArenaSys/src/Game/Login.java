/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Login {
    //Declares private variables that will be initialized and used in this class
    private String username;
    private String password;
    private String privilege;

    //Initializes the username, password and privilege
    public Login(String username, String password, String privilege) throws SQLException {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    //Creates the users table
    public static void createUsersTable() throws Exception {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            //Creates the table with columns id, username, password and privilege
            statement.executeQuery("CREATE TABLE users (id INT AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255), privilege VARCHAR(255), PRIMARY KEY (id))"); 
            
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }
    
    //Adds all the admins to the table
    public static void initializeTable() throws Exception {
        Connection connection = null;
        Statement statement = null;
        try{
            //Inserts to the table all the admins and gives a username and password for each admin
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('danish', 'danish123', 'admin')");
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('jasvin', 'jasvin123', 'admin')");
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('jasmine', 'jasmine123', 'admin')");
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('sana', 'sana123', 'admin')");
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('helen', 'helen123', 'admin')");
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('amsan', 'amsan123', 'admin')");  
        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
    }

    //Checks if the username and password a user enters matches a username and password combination in the users table
    public boolean verifyLogin() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet getUsers = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            getUsers = statement.executeQuery("SELECT * FROM users"); //Gets all the rows from the table
            while(getUsers.next()) { //Loops through all the rows and gets the username and password from each row
                String username = getUsers.getString(2);
                String password = getUsers.getString(3);
                if(username.equals(this.username) && password.equals(this.password)) //Returns true if there is a username and pasword combination that matches the one the user entered
                    return true;
            }

        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        finally{
            try {getUsers.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
        return false;
    }

    public boolean signUp() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet getUsers = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            getUsers = statement.executeQuery("SELECT * FROM users"); //Gets all the rows from the table
            while(getUsers.next()) { //Loops through all the rows and gets the username and password from each row
                String username = getUsers.getString(2);
                String password = getUsers.getString(3);
                if(username.equals(this.username) && password.equals(this.password)){ //Returns false if there is a username and pasword combination that matches the one the user entered
                    return false;
                }
            }
            statement.executeQuery("INSERT INTO users (username, password, privilege) values ('" + this.username + "', '" + this.password + "', 'customer')"); //Adds a user to the table
            
        }
        catch(Exception e){
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        finally{
            try {getUsers.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
        return true;
    }

    //Verify's the password that the user uses when signing up
    public boolean verifyPassword(String pass) {
        return this.password == pass;
    }

    //Gets the number of users that have an account on the systems (i.e. the number of rows in the users table)
    public int usersCount() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet usersCountQuery = null;
        int numberOfUsers = 0;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            usersCountQuery = statement.executeQuery("SELECT COUNT(*) FROM users"); //Gets the number of users
            usersCountQuery.next();
            numberOfUsers = usersCountQuery.getInt(1); //Converts the value into an integer
            
        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        finally{
            try {usersCountQuery.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
        return numberOfUsers;
    }

    //Checks if the person logging in has user or admin privilege
    public String checkPrivilige() throws Exception{
        Connection connection = null;
        Statement statement = null;
        ResultSet userPrivilege = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            userPrivilege = statement.executeQuery("SELECT privilege FROM users WHERE username ='" + this.username + "'" + "AND password ='"+ this.password + "'");
            userPrivilege.next();

        } catch(Exception e) {
            System.err.println(e.getMessage()); //Prints an error message if an exception occurs
        }
        finally{
            try {userPrivilege.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}

        }
        return userPrivilege.getString(4); //Converts the value it retrieves from the column as a string and returns it
    }

    //Returns the user's password
    public String getPassword() {
        return this.password;
    }

    //Sets the user's password to the argument that was passed to the function
    public void setPassword(String pass) throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE users SET password='" + pass + "'" + "WHERE username='" + this.username + "'");
            this.password.equals(pass);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
        //Try this later
//        this.password.equals(pass);
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
