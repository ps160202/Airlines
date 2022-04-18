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
                    System.out.println("Enter Name: ");
                    System.out.println("Enter Age: ");
                    System.out.println("Enter Phone Number: ");
                    System.out.println("Enter Email ID: ");

                    System.out.println("Enter city of Departure");
                    System.out.println("Enter Destination: ");
                    System.out.println("Enter Date(yyyy-mm-dd): ");

                    System.out.println("Showing available flight details: ");
                    //Printing Available Flight Details.

                    System.out.println("Enter Flight ID: ");//User enters flight ID of flight he/she wants to book.
                    System.out.println("Number of Tickets: ");
                    System.out.println("Type of Tickets: ");

                    System.out.println("Buy Tickets(1/0)? ");

                    //print Receipt.

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
