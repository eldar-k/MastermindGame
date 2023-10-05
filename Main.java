//***************************************************************************************
//*                           ICS4u - Computer Science
//*                           Lab: Mastermind
//*                           Date: Wednesday, September 19th, 2023
//*                           Name: Eldar K, Ethan Hayes, Ethan Maddix
//***************************************************************************************


import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("");
    System.out.println("Welcome to Mastermind!");
    System.out.println("");

    System.out.print("Enter the number of pegs <3-8>: ");
    int pegs = input.nextInt();
    
    System.out.print("Enter the number of colors <1-8>: ");
    int colors = input.nextInt();

    MastermindGame game = new MastermindGame(pegs, colors);
    
    game.playGame();

    input.close();
    
  }
}