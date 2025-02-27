/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import java.io.CharConversionException;
import java.sql.*;
import java.util.*;
import java.util.Date;

//Defines class named "Customer" with private fields customerId, firstName, lastName, email, userName, and password
public class Customer {         
    private int customerId; 
    private String firstName; 
    private String lastName;
    private String email;
    private String userName; 
    private String password; 
    
    public Customer(String userName) throws SQLException{
        this.userName = userName;
    }

    // Constructor method sets values for each of the fileds when creating instance of the class
    public Customer(int customerId, String firstName, String lastName, String email, String userName, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    
    public Customer(int customerId, String firstName, String lastName, String email, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and setters methods for each of the private fields
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    //Static method that verfies the users email based on thier input making sure it has the correct format (should have an "@", ",", "ca, com, etc" )
    public static boolean verifyEmail(String email){
        String possibleEmail = "^[a-zA-Z0-9&+_*-]+(?:\\." + "[a-zA-Z0-9&+_*-]+)*@" + "(:?[a-zA-Z0-9-]+\\.)[a-z" + "A-Z]{2,7}$";
        if (email.matches(possibleEmail)){
            return true;
        }
        else{
            return false;
        }
    }

    // Static method that verifes the users password based on their input making sure it has the correct format (should have 1 upper case charcter, 1 lower case character, and 1 of the speical charcters)
    public static boolean verifyPassword(String password){
        
        boolean hasUpperCase = !password.equals(password.toLowerCase());

        boolean hasLowerCase = !password.equals(password.toUpperCase());

        String specialCharacters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        boolean hasSpecialCharcter = false;

        for (int i = 0; i <password.length(); i++){
            if (specialCharacters.contains(Character.toString(password.charAt(i)))){
                hasSpecialCharcter = true;
                break;
            }
        }

        if(hasUpperCase && hasLowerCase && hasSpecialCharcter){
            return true;
        }
        else{
            return false;
        }
    }

    // Inserts the customers data into our database
    public void StoreInDataBase () {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "INSERT INTO customers (CustomerId, first_name, last_name, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(s);
            statement.setInt(1, this.customerId);
            statement.setString(2, this.firstName);
            statement.setString(3, this.lastName);
            statement.setString(4, this.email);
            statement.setString(5, this.userName);
            statement.setString(6, this.password);

            statement.executeUpdate();
        } catch (SQLException error){
            error.printStackTrace();
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
    }
    
    //Retrives the customers information by the database using thier ID
    public static int getCustomerId(String username){
        int user_id;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "SELECT * FROM users WHERE username='" + username + "';";
            statement = con.prepareStatement(s);
            result = statement.executeQuery();
            
            user_id = result.getInt("user_id");
            return user_id;
        }catch (SQLException error){
            System.err.println(error.getMessage());
        }
        finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
        return 0;
    }
}