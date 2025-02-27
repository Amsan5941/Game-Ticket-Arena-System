/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author helentran
 */

class SortByDate implements Comparator<Game>  {
    public int compare(Game game1, Game game2) {
        int dateCompare = Integer.compare(game1.getDate(), game2.getDate());
        if (dateCompare != 0){
            return dateCompare;
        }
        return Integer.compare(game1.getTime(), game2.getTime());
    }
}

class Schedule {
    // Stores the list of games in the schedule
    ArrayList<Game> games = new ArrayList<Game>();

    // Connect to the Schedule database and obtain all games
    public void loadGames() {
        Connection connection = null;
        Statement statement = null;
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30); // Wait only 30 seconds to connect

            // Send an SQL query to the Schedule database
            games.clear();
            ResultSet gameDataQuery = statement.executeQuery("SELECT * FROM schedule");
            while(gameDataQuery.next()) {
                int id = gameDataQuery.getInt("game_id");
                String name = gameDataQuery.getString("game_name");
                int date = gameDataQuery.getInt("date");
                int time = gameDataQuery.getInt("time");

                // Create a game object and add it to the games list
                Game game = new Game();
                game.init(id, name, date, time);
                game.loadSeats();
                games.add(game);
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }

    public List<Object> scheduleInfo() {
        List<Object> scheduleInfo = new ArrayList<Object>();
        
        for (int i = 0; i < games.size(); i++) {
            scheduleInfo.add(games.get(i).gameInfo());
        }

        return scheduleInfo;
    }

    public ArrayList<Game> getGames() {
        return this.games;
    }

    public List<Object> sortedSchedule() {
        Collections.sort(this.getGames(), new SortByDate());

        return this.scheduleInfo();
    }

    public void addGame(String name, int date, int time, 
                        int seatsA, int seatsB, int seatsC, int seatsD,
                        double priceA, double priceB, double priceC, double priceD) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:../test-arena.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30); // Wait only 30 seconds to connect

            // Add a new Game row in the Schedule database
            games.clear();
            statement.executeUpdate("INSERT INTO schedule (game_name, date, time) VALUES ('" + name + "','" + date + "','" + time + "')");

            // Create a new Game table
            ResultSet newGame = statement.executeQuery("SELECT * FROM schedule ORDER BY game_id DESC LIMIT 1;");
            while (newGame.next()) {
                int id = newGame.getInt("game_id");
                
                // Create a new game table with the Game ID
                String newTable = ("CREATE TABLE 'game_" + id + "' ('seat_id' INTEGER NOT NULL UNIQUE, 'section' TEXT, 'price' REAL, 'status' TEXT, PRIMARY KEY('seat_id' AUTOINCREMENT));");
                statement.executeUpdate(newTable);

                for (int i = 0; i < seatsA; i++) {
                    statement.executeUpdate("INSERT INTO game_" + id + " (section, price, status) VALUES ('A','" + priceA + "','available')");
                }
                for (int i = 0; i < seatsB; i++) {
                    statement.executeUpdate("INSERT INTO game_" + id + " (section, price, status) VALUES ('B','" + priceB + "','available')");
                }
                for (int i = 0; i < seatsC; i++) {
                    statement.executeUpdate("INSERT INTO game_" + id + " (section, price, status) VALUES ('C','" + priceC + "','available')");
                }
                for (int i = 0; i < seatsD; i++) {
                    statement.executeUpdate("INSERT INTO game_" + id + " (section, price, status) VALUES ('D','" + priceD + "','available')");
                }
            }
            this.loadGames();  
            
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            try {statement.close();} catch (SQLException e){}
            try {connection.close();} catch (SQLException e){}
        }
    }
}
