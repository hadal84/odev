import java.util.Scanner;

public class Hangman_CinarEmir {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String word = "PhoeniX";
        int chars = word.length();
        int lives = 6;

        String blanks = "";
        for (int i=0; i<chars; i++) {
            blanks = blanks + "_";
        }
        StringBuilder sb = new StringBuilder(blanks);

        while (lives!=0) {
            System.out.print("Word: ");
            System.out.print(sb);
            
            System.out.print("           Lives: ");
            System.out.println(lives);
            
            System.out.print("Guess a letter: ");
            String guess = scan.nextLine();
            char guess_c = guess.charAt(0);

            boolean checker = false;

            if (word.contains(guess.toUpperCase())) {
                sb.replace(word.indexOf(Character.toUpperCase(guess_c)), word.indexOf(Character.toUpperCase(guess_c))+1, guess.toUpperCase());
                checker = true;
            }
            if (word.contains(guess)) {
                sb.replace(word.indexOf(guess_c), word.indexOf(guess_c)+1, guess);
                checker = true;
            }
            if (checker==false) {
                // int index = word.charAt(guess);
                lives--;
                System.out.println("Wrong! ");
            }
            checker = false;

            if (word.contains(sb)) {
                System.out.print("You win! The word was: ");
                System.out.println(word);
                System.exit(0);
            }
            
        }
        if (lives==0) {
            System.out.print("The man has been hanged, the word was: ");
            System.out.println(word);
        }
    }
}
