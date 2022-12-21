package election;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ElectionMain {


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
     
    	//Initialize service and utilities
        Scanner scan = new Scanner(System.in);
        VoterLogin login = new VoterLogin();
        VoterServices voterServices = new VoterServices();
        Voter voter = null;


        int choice = 0;
        System.out.println("\n\n \t\t\t\t Welcome to Voting Service \t\t\n\n");
        login.login();


        while (true) {

            //Admin functionalities
        	
            System.out.println("1. Voter Registration");
            System.out.println("2. View All Voter List ");
            System.out.println("3. View List of Candidate ");
            System.out.println("4. Voting process ");
            System.out.println("5. Voting Result");
            System.out.println("6. Logout");
            System.out.println("Enter your choice::");

            choice = scan.nextInt();
            if (choice == 1) {
                
            	//Voter Registration

                System.out.println("Enter first name::");
                String firstName = scan.next();

                System.out.println("Enter last name::");
                String lastName = scan.next();
                Gender g = null;
                while (true) {
                    System.out.println("1.Male\t 2.Female\t 3.Others");
                    System.out.println("Choose the gender.");
                    int genderChoice = scan.nextInt();
                    if (genderChoice == 1) {
                        g = Gender.MALE;
                    } else if (genderChoice == 2) {
                        g = Gender.FEMALE;
                    } else if (genderChoice == 3) {
                        g = Gender.OTHERS;
                    } else {
                        System.out.println("Invalid option.");
                        continue;
                    }
                    break;
                }
                System.out.println("Enter your Date of Birth");

                LocalDate dateofbirth = null;
                System.out.println("Enter Your Date Of Birth (yyyy-mm-dd):");
                String dateofbirth1 = scan.next();
                dateofbirth = LocalDate.parse(dateofbirth1, DateTimeFormatter.ISO_LOCAL_DATE);
                String username = null;
                while (true) {
                    System.out.println("Enter username::");
                    username = scan.next();
                    if (voterServices.checkIfUserNameExists(username)) {
                        System.out.println("This username has been taken.");
                        continue;
                    }
                    break;
                }

                System.out.println("Enter password::");
                String password = scan.next();

                Voter voter1 = new Voter(firstName, lastName, g, dateofbirth, username, password);
                try {
                    try {
                        voterServices.voterRegistration(voter1);

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } catch (IOException e) {
                    System.out.println("Can't register voter. Please try again later.");
                    e.printStackTrace();
                }
            } else if (choice == 2) {
               
            	
            	//View all voter list
                try {
                    voterServices.viewAll();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (choice == 3) {
               
            	//view candidates

                voterServices.candidatesList();

               
            } else if (choice == 4) {
             
            	//Voting process
                System.out.println("\n\n\t\t\t\t\t\t\t Welcome to Voting Service \n" +
                        "\n\t\t Please Enter your user name and password to vote \n\n\t\t");
                System.out.println("Enter your username::");
                String username = scan.next();
                System.out.println("Enter your password");
                String password = scan.next();
                voter = voterServices.votingProcess(username, password);

                if (voter != null) {
                    System.out.println("Choose your Party to Vote ");
                } else {
                    System.out.println("You are not registered in Voter list .Please check your username and password.");

                    continue;
                }
                voterServices.candidatesList();
                System.out.println("Enter your voter Id");
                int voterId = scan.nextInt();
                System.out.println("Choose your Party::1 for Party A and 2 for Party B ");
                int symbol = scan.nextInt();
                voterServices.doVoteNow(voterId, symbol);
            }
           else if (choice == 5) {
            
         	// for login service
             login.stopVotingProgramme();
             System.out.println("Final Vote count of Election is Finished ");
               
               //method is in voter service data is in voterrecorddb class
                voterServices.finalResult();
            }
            else if (choice == 6) {
              
            	//Logout
                System.out.println("Thank You!!!!");
                break;
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }
}
