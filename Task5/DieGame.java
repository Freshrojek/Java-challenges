import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class DieGame implements GameInterface {
    // The random number generator used throughout
    public static RandomInterface r =new LinearCongruentialGenerator();
    //Variable(s) used in the die game methods
    public static HashSet<Integer> numbersRolled=new HashSet<Integer>();

    @Override
    public void play() {
        // Play card game:

        // Initialise the game
        Initialise();

        // Play the main game phase
        main();

        // Now see if (s)he has won!
        declareWinner();
    }

    @Override
    public void Initialise() {
        // The initialisation phase:

        // Actually there isn't anything to do here
    }

    @Override
    public void main() {
        // The main game:
        // The BufferedReader used throughout
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        // Let the user roll the die twice
        for (int i = 0; i < 2; i++) {
            System.out.println("Hit <RETURN> to roll the die");
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int dieRoll = (int) (r.next() * 6) + 1;

            System.out.println("You rolled " + dieRoll);
            numbersRolled.add(new Integer(dieRoll));
        }
    }

    @Override
    public void declareWinner() {
        // Declare the winner:

        // User wins if at least one of the die rolls is a 1
        if (numbersRolled.contains(new Integer(1))) {
            System.out.println("You won!");
        } else System.out.println("You lost!");
    }
}
