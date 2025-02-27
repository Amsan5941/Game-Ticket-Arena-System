import java.io.CharConversionException;
import java.sql.*;
import java.util.*;

//Defines class named "Customer" with private fields customerId, firstName, lastName, email, userName, and password
public class Customer {         
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;

    // Constructor method sets values for each of the fileds when creating instance of the class
    public Customer(int customerId, String firstName, String lastName, String email, String userName, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
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
        try {
            Connection con = DriverManager.getConnection(email, userName, password); //THIS LINE HAS TO CHANGED

            String s = "INSERT INTO customers (customer_id, first_name, last_name, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(s);
            statement.setInt(1, this.customerId);
            statement.setInt(2, this.firstName);
            statement.setInt(3, this.lastName);
            statement.setInt(4, this.email);
            statement.setInt(5, this.userName);
            statement.setInt(6, this.password);

            statement.executeUpdate();
            con.close();
        } catch (SQLException error){
            error.printStackTrace();
        }
    }
    
    //Retrives the customers information by the database using thier ID
    public static Customer getCustomerById(int customerId){
        try {
            Connection conn = DriverManager.getConnection("HOSTT, userName, password");//THIS LINE HAS TO CHANGED

            String s = "SELECT * FROM customers WHERE customerId = ?";
            PreparedStatement statement = con.prepareStatement(s);
            statement.setInt(1, customerId);

            ResultSet result = statement.executeQuery();
            if (result.next()){
                Stirng firstName = result.getString("firstName");
                Stirng lastName = result.getString("lastName");
                Stirng email = result.getString("email");
                Stirng password = result.getString("password");
                Customer customer = new Customer(customerId, firstName, lastName, email, password);
                return customer;
            }
            con.close();
        }catch (SQLException error){
            error.printStackTrace();
        }
    }
}


       

