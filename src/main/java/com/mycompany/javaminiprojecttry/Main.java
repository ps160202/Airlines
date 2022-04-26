package com.mycompany.javaminiprojecttry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        for(;;) {

            System.out.println("**********Welcome to our Airline Booking Project!**********");
            System.out.println("-------MENU--------");
            System.out.println("1 - Book Flight");
            System.out.println("2 - Sign In");
            System.out.println("3 - Exit");
            System.out.println("-------------------\n");

            System.out.println("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:{

                    Flight flight = new Flight();
                    Ticket newTicket = new Ticket();

                    System.out.println("USER DETAILS: ");

                    System.out.print("Enter Email ID: ");
                    newTicket.setEmail(sc.next());

                    if(!newTicket.checkPassenger()) {
                        System.out.print("\nEnter Name: ");
                        newTicket.setName(sc.nextLine());
                        newTicket.setName(sc.nextLine());
                        System.out.print("Enter Age: ");
                        newTicket.setAge(sc.nextInt());
                        System.out.print("Enter Phone Number: ");
                        newTicket.setPhoneNumber(sc.next());

                        newTicket.addPassenger();
                    }
                    else {
                        newTicket.getPassenger();
                    }

                    System.out.print("\nEnter city of Departure");
                    String dep = sc.next();
                    System.out.print("Enter Destination: ");
                    String dest = sc.next();
                    System.out.print("Enter Date(yyyy-mm-dd): ");
                    String date = sc.next();

                    flight.showFlightDetailsD(dep, dest, date);

                    int book;
                    System.out.println("Book Flights?(1/0): ");
                    book = sc.nextInt();
                    if(book == 0) {
                        break;
                    }

                    System.out.print("\nEnter FligthID of flight you want to book: ");
                    String fID = sc.next();

                    flight = flight.getFlightDetails(fID);
                    System.out.println("You have Selected this flight: ");
                    flight.displayFlightDetails();

                    System.out.println("Confirm?(1/0): ");
                    book = sc.nextInt();
                    if(book == 0) {
                        break;
                    }

                    System.out.println("Baggage allowed per ticket for Business Class = 25 kgs.");
                    System.out.println("Baggage allowed per ticket for Economy Class = 20 kgs.");
                    System.out.println("Enter Type of Tickets (Business/Economy): ");
                    newTicket.setTypeOfSeat(sc.next());
                    System.out.println("Enter Number of Tickets: ");
                    newTicket.setNumberOfSeats(sc.nextInt());

                    try {
                        if (((newTicket.getTypeOfSeat()).toLowerCase()).equals("business")) {
                            if (flight.getBusinessSeats() < newTicket.getNumberOfSeats()) {
                                throw new noOfSeatsException("Entered number of seats not available..!");
                            }
                        }
                        else if (((newTicket.getTypeOfSeat()).toLowerCase()).equals("economy")) {
                            if (flight.getEconomySeats() < newTicket.getNumberOfSeats()) {
                                throw new noOfSeatsException("Entered number of seats not available..!");
                            }
                        }
                    } catch (noOfSeatsException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    newTicket.calculateFinalCost(flight);
                    System.out.println("Total Cost = " + newTicket.getTotalCost());
                    System.out.println("Max Luggage Weight = " + newTicket.getMaxLuggageWeight());

                    System.out.println("Confirm Booking?(1/0)? ");
                    book = sc.nextInt();
                    if(book == 0) {
                        break;
                    }

                    flight.updateNoOfTickets(newTicket.getTypeOfSeat(), newTicket.getNumberOfSeats());
                    newTicket.bookTicket(flight);
                    newTicket.printReceipt(flight);

                    break;
                }
                case 2:{
                    Operator operator = new Operator();

                    System.out.println("Enter Username: ");
                    operator.setOperatorName(sc.next());
                    System.out.println("Enter Password: ");
                    operator.setPassword(sc.next());

                    if(!operator.authenticate()) {
                        System.out.println("\nIncorrect Username or Password..!");
                        break;
                    }
                    System.out.println("\nAuthentication Successful..!");

                op:
                    for(;;) {
                        System.out.println("**********The Backend**********");
                        System.out.println("-------MENU--------");
                        System.out.println("1 - View All Flight");
                        System.out.println("2 - View Specific Flight");
                        System.out.println("3 - Add Flight");
                        System.out.println("4 - Delete Flight");
                        System.out.println("5 - Modify Flight");
                        System.out.println("6 - Change Password");
                        System.out.println("7 - Add Operator");
                        System.out.println("8 - Remove Operator");
                        System.out.println("9 - Sign Out");
                        System.out.println("-------------------\n");

                        System.out.println("Enter Choice: ");
                        choice = sc.nextInt();

                        switch (choice) {
                            case 1: {//View All Flights
                                Flight flight = new Flight();
                                flight.displayAllFlights();

                                break;
                            }
                            case 2: {//View Specific Flights
                                System.out.println("Enter SQL Query: ");
                                String query = sc.nextLine();
                                query = sc.nextLine();

                                Flight flight = new Flight();
                                flight.displayQueryResult(query);
                                break;
                            }
                            case 3: {//Add Flight
                                Flight newFlight = new Flight();

                                System.out.println("Enter Flight Details: \n");

                                System.out.print("Enter Flight ID: ");
                                newFlight.setFlightId(sc.next());

                                System.out.print("Enter Flight Number: ");
                                newFlight.setFlightNumber(sc.next());

                                System.out.print("Enter Airline: ");
                                newFlight.setAirline(sc.nextLine());

                                System.out.print("Enter City(Departure): ");
                                newFlight.setDeparture(sc.next());

                                System.out.print("Enter City(Arrival): ");
                                newFlight.setDestination(sc.next());

                                System.out.print("Enter Date of Departure: ");
                                newFlight.setDepartureDate(sc.next());

                                System.out.print("Enter Time of Departure: ");
                                newFlight.setDepartureTime(sc.next());

                                System.out.print("Enter Date of Arrival: ");
                                newFlight.setArrivalDate(sc.next());

                                System.out.print("Enter Time of Arrival: ");
                                newFlight.setArrivalTime(sc.next());

                                System.out.print("Enter Number of Economy Class Seats: ");
                                newFlight.setEconomySeats(sc.nextInt());

                                System.out.print("Enter price of Economy Class Cost: ");
                                newFlight.setEconomyCost(sc.nextInt());

                                System.out.print("Enter Number of Business Class Seats: ");
                                newFlight.setBusinessSeats(sc.nextInt());

                                System.out.print("Enter price of Business Class Cost: ");
                                newFlight.setBusinessCost(sc.nextInt());

                                newFlight.addFlight();

                                break;
                            }
                            case 4: {//Delete Flight
                                Flight flight = new Flight();
                                flight.displayAllFlights();

                                System.out.println("Enter Flight ID of flight to be deleted: ");
                                flight.setFlightId(sc.next());

                                flight.deleteFlight();
                                break;
                            }
                            case 5: {//Modify Flight
                                Flight flight = new Flight();
                                flight.displayAllFlights();

                                System.out.println("Enter Flight ID of flight to be modified: ");

                                flight = flight.getFlightDetails(sc.next());
                                flight.displayFlightDetails();

                                flight.modifyFlight();

                                break;
                            }
                            case 6: {//Change Password
                                operator.changePassword();

                                break;
                            }
                            case 7: {//Add Operator
                                operator.addOperator();

                                break;
                            }
                            case 8: {//Remove Operator
                                operator.removeOperator();

                                break;
                            }
                            default: {//Exit
                                operator.closeConnection();

                                break op;
                            }//End of CASE
                        }//End of SWITCH
                    }//End of FOR

                    break;
                }

                case 3: {
                    return;
                }
            }
        }
    }
}
