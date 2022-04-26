package com.mycompany.javaminiprojecttry;

import java.sql.SQLException;

public class Ticket extends Passenger{
    private String flightNumber;
    private String userName;
    private String dateOfPurchase;
    private String registrationId;
    private int numberOfSeats;
    private double maxLuggageWeight;
    private String typeOfSeat;
    private double totalCost;

    static int ticketID;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getMaxLuggageWeight() {
        return maxLuggageWeight;
    }

    public void setMaxLuggageWeight(double maxLuggageWeight) {
        this.maxLuggageWeight = maxLuggageWeight;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTypeOfSeat(String typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void bookTicket(Flight flight) {
        createConnection();

        try {
            rs = stmt.executeQuery("select *from data");
            rs.next();
            ticketID = rs.getInt(3  );

            stmt.execute("insert into tickets values(" + ticketID +
                    ", '" + flight.getFlightNumber() +
                    "', '" + name +
                    "', " + numberOfSeats +
                    ", " + maxLuggageWeight +
                    ", '" + typeOfSeat +
                    "', " + totalCost + ");");

            ticketID++;
            stmt.execute("update data set noOfTickets=" + ticketID + ";");
            System.out.println("\nTICKET BOOKING SUCCESSFUL!\n");
        } catch (SQLException e){
            System.out.println(e);
            return;
        } finally {
            closeConnection();
        }
    }

    public void calculateFinalCost(Flight flight) {
        if (((this.getTypeOfSeat()).toLowerCase()).equals("business")) {
            this.totalCost = flight.getBusinessCost() * this.numberOfSeats;
            this.maxLuggageWeight = 25 * this.numberOfSeats;
        }
        else if (((this.getTypeOfSeat()).toLowerCase()).equals("economy")) {
            this.totalCost = flight.getEconomyCost() * this.numberOfSeats;
            this.maxLuggageWeight = 20 * this.numberOfSeats;
        }
    }


    public void printReceipt(Flight flight) {
        System.out.println("**************************RECEIPT**************************");
        System.out.println("Name of Passenger       : " + name);
        System.out.println("From                    : " + flight.getDeparture());
        System.out.println("To                      : " + flight.getDestination());
        System.out.println("Date                    : " + flight.getDepartureDate());
        System.out.println("Time                    : " + flight.getDepartureTime());
        System.out.println("Flight Number           : " + flight.getFlightNumber());
        System.out.println("Number of Tickets       : " + numberOfSeats);
        System.out.println("Class                   : " + typeOfSeat);
        System.out.println("Maximum Luggage (kgs)   : " + maxLuggageWeight);
        System.out.println("Total Amount            : " + totalCost);
        System.out.println("***********************************************************");
    }
}
