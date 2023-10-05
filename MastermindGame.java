
import java.util.Random;
import java.util.Scanner;
import java.util.*;

class MastermindGame {
    
  private int pegs;
  private int colors;
  private int[] secretCode;
  private int guesses;

  public MastermindGame(int pegs, int colors) {
    this.pegs = pegs;
    this.colors = colors;
    this.secretCode = generateSecretCode();
    this.guesses = 0;
  }

  public void playGame() {

    while (true) {
      
      int[] guess = getGuess();
      int[] result = evaluateGuess(guess);
      
      System.out.println("You have " + result[0] + " peg(s) correct and " + result[1] + " color(s) correct.");

      if (result[0] == pegs) {
        System.out.println("");
        System.out.println("You have broken the code in " + guesses + " guesses.");
      break;
            
      }  
    }
  }
  
  private int[] generateSecretCode() {
    
    int[] code = new int[pegs];
    Random random = new Random();
    
    for (int i = 0; i < pegs; i++) {
      code[i] = random.nextInt(colors) + 1;
    }
    
    return code;
    
  }
  
  private int[] getGuess() {
    
    Scanner scanner = new Scanner(System.in);
    int[] guess = new int[pegs];

    int accumulator = 0;
    
    while (accumulator < guess.length) {
      guesses++;
      try {
        System.out.println("");
        System.out.println("Guess " + guesses + ":");
        for (int i = 0; i < pegs; i++) {
          System.out.print("Color for peg " + (i + 1) + ": ");
          int input = scanner.nextInt();
          if (input < 1 || input > colors) {
            throw new NumberFormatException();
          } else {
            guess[i] = input;
            accumulator++;
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter " + pegs + " numbers between 1 and " + colors + ".");
      }
    }
    return guess;
  }

  
  private int[] evaluateGuess(int[] guess) {
    
    int correctPegs = 0;
    int correctColors = 0;
    int[] codeCopy = new int[pegs];
    int[] guessCopy = new int[pegs];

    for (int i = 0; i < pegs; i++) {
      codeCopy[i] = secretCode[i];
      guessCopy[i] = guess[i];
      if (codeCopy[i] == guessCopy[i]) {
        correctPegs++;
      }
    }

    ArrayList<Integer> guessed = new ArrayList<Integer>();
    for (int i = 0; i < pegs; i++) {
      for (int j = 0; j < pegs; j++) {
        if (codeCopy[j] == guessCopy[i]) {
          if(!(guessed.contains(guessCopy[i]))) {
            correctColors++;
            guessed.add(guessCopy[i]);
          }
        }
      }
    }

    guessed.clear();
    
    return new int[] {correctPegs, correctColors};
    
  }
}