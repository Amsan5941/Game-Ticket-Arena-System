/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;

public class ShoppingCart {
    private int customerId;
    private String username; 
    private String password;
    public double price;
        
    public ShoppingCart(String username) throws SQLException{
        this.username = username;
    }
    
    // Adds the item into the cart database
    public void addItemToCart(int gameId, int seatId, double price, String username) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "INSERT INTO cart (game_id, seat_id, price, user_id) VALUES (?, ?, ?, ?)";
            statement = con.prepareStatement(s);
            statement.setInt(1, gameId);
            statement.setInt(2, seatId);
            statement.setDouble(3, price);
            statement.setString(4, username);
            statement.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
    }
    
    // Removes all the items from the cart that belongs to that customer
    public void removeFromCart(String username) throws SQLException{
        Connection con = null;
        PreparedStatement statement = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "DELETE FROM cart WHERE user_id ='" + username + "';";
            statement = con.prepareStatement(s);
            statement.executeUpdate();
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
    }
    
    // Inserts the tickets bought into the purchased table in the database
    public void buyItems(String username) throws SQLException{
        Customer customerInfo = new Customer(username);
        // Get the userid from username
        int user_id = customerInfo.getCustomerId(username);
        Connection con = null;
        PreparedStatement statement = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "INSERT INTO purchased (game_id, seat_id, price, user_id) SELECT game_id, seat_id, price, ?" +
                       "FROM cart WHERE user_id ='" + username + "';";
            statement = con.prepareStatement(s);
            statement.setInt(1, user_id);
            statement.executeUpdate();
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
    }
  
    // Collects all the information from the cart into an arraylist and returns it
    public ArrayList<CartItem> getCartItems(String username){
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "SELECT * FROM cart WHERE user_id='" + username + "';";
            statement = con.prepareStatement(s);
            result = statement.executeQuery();
            
            while(result.next()){
                int game_id = result.getInt("game_id");
                int seat_id = result.getInt("seat_id");
                double price = result.getDouble("price");
                String user_id = result.getString("user_id");
                CartItem cartItem = new CartItem(game_id, seat_id, price, username);
                cartItems.add(cartItem);
            }
            return cartItems;

        }catch (SQLException error){
            error.printStackTrace();
        }
        finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
        return cartItems;
    }
    
    // Get the total price for each customer from the cart database 
    public double getTotalCart(String username) throws SQLException{
        double total = 0.0;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "SELECT * FROM cart WHERE user_id='" + username + "';";
            statement = con.prepareStatement(s);
            result = statement.executeQuery();
            
            while(result.next()){
                if (result.getString("user_id").equals(username)){
                    total += result.getDouble("price");
                }
            }
            
        }
        finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
        return total;
    }
    
    public static class CartItem{
        private int game_id;
        private int seat_id;
        private double price;
        private String username;

        public CartItem(int game_id, int seat_id, double price, String username){
            this.game_id = game_id;
            this.seat_id = seat_id;
            this.price = price;
            this.username = username;
        }
        public int getGameId() {
            return game_id;
        }

        public int getSeatId() {
            return seat_id;
        }
        
        public double getPrice(){
            return price;
        }
        public String getUsername(){
            return username;
        }
        public String toString() {
        return "gameID: " + game_id + " seatID: " + seat_id + " Price: " + price + " username: " + username;
        }
    }
}
