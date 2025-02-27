import java.sql.*;
import java.util.*;

class Seat {
    // Attributes for a Seat object
    private int gameID;
    private int id;
    private String section;
    private double price;
    private String status;

    // Set all attributes at once
    public Seat(int gameID, int seatID, String section, double price, String status) {
        this.gameID = gameID;
        this.id = seatID;
        this.section = section;
        this.price = price;
        this.status = status;
    }
    
    // Getter and setter methods
    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getSection() {
        return section;
    }

    void setSection(String section) {
        this.section = section;
    }

    double getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status){
        this.status = status;
    }

    public String toString() {
        return "SeatID: " + id + " Section: " + section + " Price: " + price + " Status: " + status;
    }

    int getGame() {
        return gameID;
    }

    // Return a list of a seat's attributes
    public List<Object> seatInfo() {
        List<Object> seatInfo = new ArrayList<Object>();

        seatInfo.add(this.id);
        seatInfo.add(this.section);
        seatInfo.add(this.price);
        seatInfo.add(this.status);
        return seatInfo;
    } 
}

class Game {
    // Attributes for a Game object
    int id;
    String name;
    int date;
    int time;
    ArrayList<Seat> seats = new ArrayList<Seat>();

    // Set all attributes at once
    public void init(int id, String name, int date, int time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    // Connects to the respective Game database and obtains all seats
    public void loadSeats() {
        Connection connection = null;
        // Connect to the Schedule database
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:test-arena.db");
            Statement statement = connection.createStatement();
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
        }
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

    public int getDate() {
        return this.date;
    }

    public int getTime() {
        return this.time;
    }    

    public Seat getSeat(int id) {
        return seats.get(id - 1);
    }
}


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

    // Stores the database connection
    Connection connection = null;
    
    // Connect to the Schedule database and obtain all games
    public void loadGames() {
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:test-arena.db");
            Statement statement = connection.createStatement();
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
        try {
            // Connects to the database in the current directory
            connection = DriverManager.getConnection("jdbc:sqlite:test-arena.db");
            Statement statement = connection.createStatement();
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
    }
}