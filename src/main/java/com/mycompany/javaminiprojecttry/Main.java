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
                    System.out.println("Enter Username: ");
                    System.out.println("Enter Password: ");

                    //Match them w database, if match found, move ahead else break.
                op:
                    for(;;) {
                        System.out.println("**********The Backend**********");
                        System.out.println("-------MENU--------");
                        System.out.println("1 - View Flights");
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
                            case 1: {
                                System.out.println("Flight Details: ");
                                break;
                            }
                            case 2: {
                                System.out.println("Flight: ");
                                break;
                            }
                            case 3: {
                                Flight newFlight = new Flight();

                                System.out.println("Enter Flight Details: \n");

                                System.out.println("Enter Flight ID: ");
                                System.out.println("Enter Flight Number");
                                System.out.println("Enter Airline: ");
                                System.out.println("Enter City(Departure): ");
                                System.out.println("Enter City(Arrival): ");
                                System.out.println("Enter Date of Departure: ");
                                System.out.println("Enter Time of Departure: ");
                                System.out.println("Enter Date of Arrival: ");
                                System.out.println("Enter Time of Arrival: ");
                                System.out.println("Enter Number of Economy Class Seats: ");
                                System.out.println("Enter price of Economy Class Seats: ");
                                System.out.println("Enter Number of Business Class Seats: ");
                                System.out.println("Enter price of Business Class Seats: ");

                                break;
                            }
                            case 4: {
                                System.out.println("All Flight Details: ");
                                System.out.println("Enter Flight ID of flight to be deleted: ");
                                break;
                            }
                            case 5: {
                                System.out.println("All Flight Details: ");
                                System.out.println("Enter Flight ID of flight to be modified: ");


                                break;
                            }
                            case 6: {
                                System.out.println("Enter Current Password: ");
                                System.out.println("Enter New Password: ");
                                System.out.println("Confirm Password: ");

                                break;
                            }
                            case 7: {
                                System.out.println("Enter ADMIN Password: ");

                                System.out.println("Enter username for new operator: ");
                                System.out.println("Enter New Password for new operator: ");
                                System.out.println("Confirm Password for new operator: ");

                                System.out.println("Operator added!");
                                break;
                            }
                            case 8: {
                                System.out.println("Enter Admin Password: ");

                                System.out.println("Enter username of operator to be removed: ");

                                break;
                            }
                            case 9: {
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
