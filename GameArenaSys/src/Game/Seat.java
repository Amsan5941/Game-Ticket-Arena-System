/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.util.ArrayList;
import java.util.List;

public class Seat {
    private int gameID;
    private int id;
    private String section;
    private double price;
    private String status;

    public Seat() {
        id = 0;
        section = "";
        price = 0;
        status = "unavailable";
    }

    public Seat(int gameID, int seatID, String section, double price, String status) {
        this.gameID = gameID;
        this.id = seatID;
        this.section = section;
        this.price = price;
        this.status = status;
    }

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

    void setGame(int gameID) {
        this.gameID = gameID;
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
