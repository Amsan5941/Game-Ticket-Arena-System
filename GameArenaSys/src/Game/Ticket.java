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
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ticket {

    private int eventID;
    private String seat;
    private Date purchaseDate;
    public int customerId;
    public ArrayList<TicketItem> items = new ArrayList<TicketItem>();

    public Ticket(){
    }

    public Ticket(int eventID, String seat, Date purchasDate){
        this.eventID = eventID;
        this.seat = seat;
        this.purchaseDate = purchasDate;
    }

    public int getEventId() {
        return eventID;
    }

    public String getSeat(){
        return seat;
    }
    public Date getPurchaseDate(){
        return purchaseDate;
    }
    
    // customer can buy the tickets
    public void buyTicket(int game_id, int seat_id, double price, int user_id){
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "INSERT INTO purchased (game_id, seat_id, price, user_id) VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareStatement(s);
            statement.setInt(1, game_id);
            statement.setInt(2, seat_id);
            statement.setDouble(3, price);
            statement.setInt(4, user_id);
            statement.executeUpdate();

        } catch (SQLException error){
            error.printStackTrace();
        }
        finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
    }

    // Returns an array list of all the purchases from the database
    public ArrayList<TicketItem> getPurchaseHistory(){
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "SELECT * from purchased";
            statement = con.prepareStatement(s);
            result = statement.executeQuery();

            while (result.next()){
                int game_id = result.getInt("game_id");
                int seat_id = result.getInt("seat_id");
                double price = result.getDouble("price");
                int user_id = result.getInt("user_id");
                TicketItem ticket = new TicketItem(game_id, seat_id, price, user_id);
                items.add(ticket);
            }
            
        } catch (SQLException error){
            error.printStackTrace();
        }
        finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
        return items;
    }
    
    // Returns an array list of all the purchases from that customer
    public ArrayList<TicketItem> getPurchaseFromUser(int user_id){
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            String s = "SELECT * from purchased WHERE user_id=" + user_id + ";";
            statement = con.prepareStatement(s);
            result = statement.executeQuery();

            while (result.next()){
                int game_id = result.getInt("game_id");
                int seat_id = result.getInt("seat_id");
                int price = result.getInt("price");
                TicketItem ticket = new TicketItem(game_id, seat_id, price, user_id);
                items.add(ticket);
            }

        } catch (SQLException error){
            error.printStackTrace();
        } finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
        return items;
    }
    
    // Gets the total price of the items that was purchased by that customer
    public double getTotalPrice(String username) throws SQLException{
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            double total = 0;
            String s = "SELECT * from purchased WHERE user_id='" + username + "';";
            statement = con.prepareStatement(s);
            result = statement.executeQuery();

            while (result.next()){
                total += result.getDouble("price");
            }
            return total;
        }
        finally{
            try {result.close();} catch (SQLException e){}
            try {statement.close();} catch (SQLException e){}
            try {con.close();} catch (SQLException e){}
        }
    }
            
            
    public static class TicketItem{
        private int game_id;
        private int seat_id;
        private double price;
        private String username;
        private int user_id;

        public TicketItem(int game_id, int seat_id, double price, String username){
            this.game_id = game_id;
            this.seat_id = seat_id;
            this.price = price;
            this.username = username;
        }
        public TicketItem(int game_id, int seat_id, double price, int user_id){
            this.game_id = game_id;
            this.seat_id = seat_id;
            this.price = price;
            this.user_id = user_id;
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
        public String toStringUserId() {
            return "gameID: " + game_id + " seatID: " + seat_id + " Price: " + price + " userid: " + user_id;
        }
    }
}