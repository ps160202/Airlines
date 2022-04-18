package com.mycompany.javaminiprojecttry;

import java.sql.*;
import java.util.Scanner;


public class Flight {
    private String flightId;
    private String flightNumber;
    private String airline;
    private String departure;
    private String destination;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private int economySeats;
    private int businessSeats;
    private double economyCost;
    private double businessCost;

    Scanner sc = new Scanner(System.in);

    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public double getEconomyCost() {
        return economyCost;
    }

    public void setEconomyCost(double economyCost) {
        this.economyCost = economyCost;
    }

    public double getBusinessCost() {
        return businessCost;
    }

    public void setBusinessCost(double businessCost) {
        this.businessCost = businessCost;
    }

    //----------------------------------------------
    public void createConnection() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/airline";
            con = DriverManager.getConnection(db, "root", "123456");
            stmt = con.createStatement();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Error "+e.toString());
            System.exit(0);
        }
    }

    public void closeConnection() {
        try {
            if(rs != null)
                rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void displayFlightDetails() {
        System.out.println("Flight ID                      : " + this.flightId);
        System.out.println("Flight Number                  : " + this.flightNumber);
        System.out.println("Airline                        : " + this.airline);
        System.out.println("Departure                      : " + this.departure);
        System.out.println("Destination                    : " + this.destination);
        System.out.println("Departure Date                 : " + this.departureDate);
        System.out.println("Departure Time                 : " + this.departureTime);
        System.out.println("Arrival Date                   : " + this.arrivalDate);
        System.out.println("Arrival Time                   : " + this.arrivalTime);
        System.out.println("Number of Economy Class Seats  : " + this.economySeats);
        System.out.println("Number of Business Class Seats : " + this.businessSeats);
        System.out.println("Cost of Economy Seats          : " + this.economyCost);
        System.out.println("Cost of Business Seats         : " + this.businessCost);
        System.out.println("_____________________________________________________________");
    }

    public void displayAllFlights() {
        createConnection();
        System.out.println("*************************ALL FLIGHTS*************************\n");

        try {
            rs = stmt.executeQuery("select *from flights;");

            while(rs.next()) {
                this.flightId = rs.getString(1);
                this.flightNumber = rs.getString(2);
                this.airline = rs.getString(3);
                this.departure = rs.getString(4);
                this.destination = rs.getString(5);
                this.departureDate = rs.getString(6);
                this.departureTime = rs.getString(7);
                this.arrivalDate = rs.getString(8);
                this.arrivalTime = rs.getString(9);
                this.economySeats = rs.getInt(10);
                this.businessSeats = rs.getInt(11);
                this.economyCost = rs.getInt(12);
                this.businessCost = rs.getInt(13);

                this.displayFlightDetails();
            }
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }

        System.out.println("\n*************************************************************\n");
        closeConnection();
    }

    public void displayQueryResult(String query) {
        createConnection();
        System.out.println("****************************FLIGHTS****************************\n");

        try {
            rs = stmt.executeQuery(query);

            while(rs.next()) {
                this.flightId = rs.getString(1);
                this.flightNumber = rs.getString(2);
                this.airline = rs.getString(3);
                this.departure = rs.getString(4);
                this.destination = rs.getString(5);
                this.departureDate = rs.getString(6);
                this.departureTime = rs.getString(7);
                this.arrivalDate = rs.getString(8);
                this.arrivalTime = rs.getString(9);
                this.economySeats = rs.getInt(10);
                this.businessSeats = rs.getInt(11);
                this.economyCost = rs.getInt(12);
                this.businessCost = rs.getInt(13);

                this.displayFlightDetails();
            }
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }

        System.out.println("\n*************************************************************\n");
        closeConnection();
    }

    public void addFlight(){
        createConnection();

        try {
            stmt.execute("insert into flights values('" + this.flightId +
                    "', '" + this.flightNumber +
                    "', '" + this.airline +
                    "', '" + this.departure +
                    "', '" + this.destination +
                    "', '" + this.departureDate +
                    "', '" + this.departureTime +
                    "', '" + this.arrivalDate +
                    "', '" + this.arrivalTime +
                    "', " + this.economySeats +
                    ", " + this.businessSeats +
                    ", " + this.economyCost +
                    ", " + this.businessCost + ");");

            System.out.println("\nFlight Added Successfully!\n");
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }

        closeConnection();
    }

    public void deleteFlight() {
        createConnection();

        try {
            stmt.execute("delete from flights where flightID = '" + this.flightId + "';");
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }

        System.out.println("\nFlight Deleted Successfully!\n");
        closeConnection();
    }

    public void modifyFlight(){
        createConnection();

    op:
        while(true) {

            System.out.println("\n*******Modify*******");
            System.out.println("1  - flightNumber");
            System.out.println("2  - Airline");
            System.out.println("3  - Departure");
            System.out.println("4  - Destination");
            System.out.println("5  - Departure Date");
            System.out.println("6  - Departure Time");
            System.out.println("7  - Arrival Date");
            System.out.println("8  - Arrival Time");
            System.out.println("9  - Economy Seats");
            System.out.println("10 - Business Seats");
            System.out.println("11 - Economy Cost");
            System.out.println("12 - Business Cost");
            System.out.println("********************");

            System.out.println("\nEnter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Current Flight Number = " + this.flightNumber);
                    System.out.print("Enter New Flight Number: ");
                    this.flightNumber = sc.next();
                    try {
                        stmt.execute("update flights set flightNumber = '" + this.flightNumber + "';");
                        System.out.println("Flight " + this.flightId + " - Flight Number Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 2: {
                    System.out.println("Current Airline = " + this.airline);
                    System.out.print("Enter New Airline: ");
                    this.airline = sc.next();
                    try {
                        stmt.execute("update flights set Airline = '" + this.airline + "';");
                        System.out.println("Flight " + this.flightId + " - Airline Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 3: {
                    System.out.println("Current Departure = " + this.departure);
                    System.out.print("Enter New Departure: ");
                    this.departure = sc.next();
                    try {
                        stmt.execute("update flights set departure = '" + this.departure + "';");
                        System.out.println("Flight " + this.flightId + " - Departure Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 4: {
                    System.out.println("Current Destination = " + this.destination);
                    System.out.print("Enter New Destination: ");
                    this.destination = sc.next();
                    try {
                        stmt.execute("update flights set destination = '" + this.destination + "';");
                        System.out.println("Flight " + this.flightId + " - Destination Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 5: {
                    System.out.println("Current Departure Date = " + this.departureDate);
                    System.out.print("Enter New Departure Date: ");
                    this.departureDate = sc.next();
                    try {
                        stmt.execute("update flights set departureDate = '" + this.departureDate + "';");
                        System.out.println("Flight " + this.flightId + " - Departure Date Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 6: {
                    System.out.println("Current Departure Time = " + this.departureTime);
                    System.out.print("Enter New Departure Time: ");
                    this.departureTime = sc.next();
                    try {
                        stmt.execute("update flights set departureTime = '" + this.departureTime + "';");
                        System.out.println("Flight " + this.flightId + " - Departure Time Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 7: {
                    System.out.println("Current Arrival Date = " + this.arrivalDate);
                    System.out.print("Enter New Arrival Date: ");
                    this.arrivalDate = sc.next();
                    try {
                        stmt.execute("update flights set departureDate = '" + this.arrivalDate + "';");
                        System.out.println("Flight " + this.flightId + " - Arrival Date Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 8: {
                    System.out.println("Current Arrival Time = " + this.arrivalTime);
                    System.out.print("Enter New Arrival Time: ");
                    this.arrivalTime = sc.next();
                    try {
                        stmt.execute("update flights set departureTime = '" + this.arrivalTime + "';");
                        System.out.println("Flight " + this.flightId + " - Arrival Time Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 9: {
                    System.out.println("Current Economy Seats = " + this.economySeats);
                    System.out.print("Enter New Economy Seats: ");
                    this.economySeats = sc.nextInt();
                    try {
                        stmt.execute("update flights set economySeats = '" + this.economySeats + "';");
                        System.out.println("Flight " + this.flightId + " - Economy Seats Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 10: {
                    System.out.println("Current Business Seats = " + this.businessSeats);
                    System.out.print("Enter New Business Seats: ");
                    this.businessSeats = sc.nextInt();
                    try {
                        stmt.execute("update flights set businessSeats = '" + this.businessSeats + "';");
                        System.out.println("Flight " + this.flightId + " - Business Seats Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 11: {
                    System.out.println("Current Economy Seats = " + this.economySeats);
                    System.out.print("Enter New Economy Cost: ");
                    this.economySeats = sc.nextInt();
                    try {
                        stmt.execute("update flights set economyCost = '" + this.economyCost + "';");
                        System.out.println("Flight " + this.flightId + " - Economy Cost Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 12: {
                    System.out.println("Current Business Cost = " + this.businessCost);
                    System.out.print("Enter New Business Cost: ");
                    this.businessCost = sc.nextInt();
                    try {
                        stmt.execute("update flights set businessCost = '" + this.businessCost + "';");
                        System.out.println("Flight " + this.flightId + " - Business Cost Updated.");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                    break;
                }
                default: {
                    break op;
                }
            }

        }

        closeConnection();
    }

    public Flight getFlightDetails(String fid) {
        createConnection();

        try {
            rs = stmt.executeQuery("select *from flights where flightID='" + this.flightId + "';");

            rs.next();

            this.flightNumber = rs.getString(2);
            this.airline = rs.getString(3);
            this.departure = rs.getString(4);
            this.destination = rs.getString(5);
            this.departureDate = rs.getString(6);
            this.departureTime = rs.getString(7);
            this.arrivalDate = rs.getString(8);
            this.arrivalTime = rs.getString(9);
            this.economySeats = rs.getInt(10);
            this.businessSeats = rs.getInt(11);
            this.economyCost = rs.getInt(12);
            this.businessCost = rs.getInt(13);

            closeConnection();
            return this;

        } catch (SQLException e) {
            System.out.println(e);
            closeConnection();
            return null;
        }
    }
}

