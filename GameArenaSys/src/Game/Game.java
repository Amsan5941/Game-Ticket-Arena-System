/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.util.*;
import java.sql.*;

public class Game {
    private int id;
    private ArrayList<Seat> seats;
    private String name;
    public int date;
    public int time;
    
    public Game() throws SQLException {
        id = 1;
        seats = new ArrayList<Seat>();
    }

    public Game(int id) throws SQLException {
        this.id = id;
        seats = new ArrayList<Seat>();
    }

    public Game(int id, ArrayList<Seat> seats) throws SQLException {
        this.id = id;
        this.seats = seats;
    }

    public Game(int id, ArrayList<Seat> seats, String name, int date) throws SQLException {
        this.id = id;
        this.seats = seats;
        this.name = name;
        this.date = date;
    }

    public Game(int id, String name, int date) throws SQLException {
        this.id = id;
        this.seats = new ArrayList<Seat>();
        this.name = name;
        this.date = date;
    }
    
    public Game(int id, String name, int date, int time) throws SQLException {
        this.id = id;
        this.seats = new ArrayList<Seat>();
        this.name = name;
        this.date = date;
    }
    
    public void init(int id, String name, int date, int time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }
    
    public void loadSeats() {
        Connection connection = null;
        Statement statement = null;
        // Connect to the Schedule database
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30); // Wait only 30 seconds to connect

            // Send an SQL query to the Game database
            seats.clear();
            ResultSet seatDataQuery = statement.executeQuery("SELECT * FROM game_" + id);
            while(seatDataQuery.next()) {
                // Obtain column values
                int seatID = seatDataQuery.getInt("seat_id");
                String section = seatDataQuery.getString("section");
                double price = seatDataQuery.getDouble("price");
                String status = seatDataQuery.getString("status"); 

                // Initialize a new seat object
                Seat seat = new Seat(this.id, seatID, section, price, status);
                
                // Add the seat object to the seat list
                seats.add(seat);
            }
      

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    } 

    ArrayList<Seat> getSeats() {
        return seats;
    }

    void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getDate() {
        return date;
    }

    void setDate(int date) {
        this.date = date;
    }
    
    public int getTime() {
        return this.time;
    }

    public String toString() {
        return "Game ID: " + id + ", Game name: " + name + ", Date: " + date;
    }
    
    public List<Object> gameInfo() {
        List<Object> gameInfo = new ArrayList<Object>();

        gameInfo.add(this.id);
        gameInfo.add(this.name);
        gameInfo.add(this.date);
        gameInfo.add(this.time);
        gameInfo.add(this.seats);

        return gameInfo;
    }
    
    public ArrayList<Seat> loadSectionSeats(String sectionQuery) {
        Connection connection = null;
        Statement statement = null;
        // Connect to the Schedule database
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30); // Wait only 30 seconds to connect

            // Send an SQL query to the Game database
            ArrayList<Seat> sectionSeats = new ArrayList<Seat>();
            ResultSet seatDataQuery = statement.executeQuery("SELECT * FROM game_" + id + " WHERE section='" + sectionQuery + "';");
            while(seatDataQuery.next()) {
                // Obtain column values
                int seatID = seatDataQuery.getInt("seat_id");
                String section = seatDataQuery.getString("section");
                double price = seatDataQuery.getDouble("price");
                String status = seatDataQuery.getString("status"); 

                // Initialize a new seat object
                Seat seat = new Seat(this.id, seatID, section, price, status);

                // Add the seat object to the seat list
                sectionSeats.add(seat);
            }
            
            return sectionSeats;
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }
}
