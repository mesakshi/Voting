package election;

import java.util.Scanner;

public class VoterLogin {
      void login( ) {
        Scanner scan = new Scanner(System.in);
          System.out.println("Authorized person's Name");
        String name=scan.nextLine();
        System.out.println("Enter Authorize Id  ");
        String Id = scan.next();
        if ((Id.equals("Dhungana"))&&(name.equals("Sakshi"))) {
            System.out.println("Authorized login successfully ");
        } else {
            System.out.println("You are not Authorize ");
            System.exit(1);
        }

    }
   public void stopVotingProgramme(){
     Scanner scan = new Scanner(System.in);
     System.out.println("Voting Time-Up. Enter Authorizes password for Stop voting Program");
     String Id = scan.next();
     if ((Id.equals("Dhungana"))) {
         System.out.println("Voting programme is stopped. NOW Start vote count and public final result ");
     } else {
         System.out.println("Incorrect Authorizes Id Please try again ");
     }
 }
 }