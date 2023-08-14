import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        
        int randomNumber = (int) (Math.random() * 100) + 1;
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            
            System.out.println("Guess a number between 1 and 100: ");
            
            int guess = scanner.nextInt();
            
            if (guess == randomNumber) {
                
                System.out.println("You guessed correctly!");
                break;
            } else if (guess < randomNumber) {
                
                System.out.println("Your guess is too low.");
            } else {
                
                System.out.println("Your guess is too high.");
            }
        }
    }
}