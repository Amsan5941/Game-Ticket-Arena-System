/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import java.sql.*;
import java.util.*;

public class Admin {
    private static ArrayList<Game> games;
    private int game_id;

    public Admin() throws SQLException {
    } 
    
    public Admin(int game_id) throws SQLException{
        this.game_id = game_id;
    }
    // Create a new table for a game
    // Assumes the table doesn't already exist
    void createGameTable(Game game) throws SQLException{    
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "CREATE TABLE game_" + game.getId() + " (seat_id int, section varchar(255), price int, status varchar(255));";
            statement.executeUpdate(query);
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
        
    }

    // Add a game to the schedule and create a table for that game
    void addGame(Game game) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            //createGameTable(game);
            String query = "INSERT INTO schedule (game_id) VALUES ('" + game.getId() + "');";
            statement.executeUpdate(query);  
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    void addGame(int id) throws SQLException {
        Game game = new Game(id);
        addGame(game);
    }

    void addGame(int id, ArrayList<Seat> seats) throws SQLException {
        Game game = new Game(id, seats);
        addGame(game);
    }

    // Given a game id, construct a game object from the database
    Game getGame(int id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT game_id, game_name, date FROM schedule WHERE game_id = " + id + ";";
            ResultSet gameDataQuery = statement.executeQuery(query);
            id = gameDataQuery.getInt("game_id");
            String name = gameDataQuery.getString("game_name");
            int date = gameDataQuery.getInt("date");
            return new Game(id, name, date);
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
        
    }

    // Update the data for a game in the schedule 
    void updateGame(Game game) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // Update the schedule
            String query = "UPDATE schedule SET game_name = '" + game.getName() + "', date = " + game.getDate() + " WHERE game_id = "+ game.getId() +";";
            statement.executeUpdate(query);
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    void updateGame(int id, String name, int date) throws SQLException {
        Game game = new Game(id, name, date);
        updateGame(game);
    }

    // Remove a game from the schedule and delete it's table
    void cancelGame(int id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query1 = "DELETE FROM schedule WHERE game_id = " + id + ";";
            statement.executeUpdate(query1);
            String query2 = "DROP TABLE game_" + id + ";";
            statement.executeUpdate(query2);  
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    void cancelGame(Game game) throws SQLException {
        cancelGame(game.getId());
    }

    // Create a seat object from the database
    Seat viewSeat(int gameID, int seatID) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT section, price, status FROM game_" + gameID +" WHERE seat_id = " + seatID + ";";
            ResultSet seatQuery = statement.executeQuery(query);
            String section = seatQuery.getString("section");
            int price = seatQuery.getInt("price");
            String status = seatQuery.getString("status");
            return new Seat(gameID, seatID, section, price, status);
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    // Update the seat data in its game table
    void updateSeat(int gameID, Seat seat) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "UPDATE game_" + gameID + " SET section = '" + seat.getSection() + "', price = " + seat.getPrice() + ", status = '"+ seat.getStatus() +"' WHERE seat_id = "+ seat.getId() +";";
            statement.executeUpdate(query);
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    void updateSeat(int gameID, int id, String section, int price, String status) throws SQLException {
        Seat seat = new Seat(gameID, id, section, price, status);
        updateSeat(gameID, seat);
    }

    // Return an ArrayList of all unavailable seats for a game
    ArrayList<Seat> getSetSeats(int gameID) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT seat_id, section, price, status FROM game_" + gameID + " WHERE status = 'unavailable'";
            ResultSet seatDataQuery = statement.executeQuery(query);
            ArrayList<Seat> seats = new ArrayList<>();
            while (seatDataQuery.next()) {
                int seatID = seatDataQuery.getInt("seat_id");
                String section = seatDataQuery.getString("section");
                int price = seatDataQuery.getInt("price");
                String status = seatDataQuery.getString("status");
                Seat seat = new Seat(gameID, seatID, section, price, status);
                seats.add(seat);
        }
        
        return seats;
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    // Print data for the schedule, games, and users
    void getAnalytics() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ArrayList<Game> games =  new ArrayList<>();

            ResultSet scheduleQuery = statement.executeQuery("SELECT * FROM schedule;");
            System.out.println("Schedule:");
            while (scheduleQuery.next()) {
                int id = scheduleQuery.getInt("game_id");
                String name = scheduleQuery.getString("game_name");
                int date = scheduleQuery.getInt("date");
                Game game = new Game(id, name, date);
                games.add(game);

                System.out.println(game);
            }
            System.out.println("");

            for (Game g : games) {
                System.out.println("Game " + g.getId()+ ":");
                String query = "SELECT * FROM game_" + g.getId() +";";
                ResultSet gameQuery = statement.executeQuery(query);
                while (gameQuery.next()) {
                    int seatID = gameQuery.getInt("seat_id");
                    String section = gameQuery.getString("section");
                    int price = gameQuery.getInt("price");
                    String status = gameQuery.getString("status");
                    Seat seat = new Seat(g.getId(), seatID, section, price, status);

                    System.out.println(seat);
                }
                System.out.println("");
            }

            System.out.println("\nUsers:");
            ResultSet usersQuery = statement.executeQuery("SELECT * FROM users;");
            while (usersQuery.next()) {
                int id = usersQuery.getInt("user_id");
                String username = usersQuery.getString("username");
                String password = usersQuery.getString("password");
                String privilege = usersQuery.getString("privilege");

                System.out.println("User id: " + id + " Username: " + username + " Password: "+ password + " Privilege: " + privilege);
            }
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    // Print data about a customer
    void getCustomerReport(Customer customer) {
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Name: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Password: " + customer.getPassword());
    }

    public static void main (String[] args) throws Exception {
        Connection connection = null;
        try {
            Admin admin = new Admin();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
