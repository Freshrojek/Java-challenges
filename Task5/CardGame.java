import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CardGame implements GameInterface {
    // The Card Game class where all the information about the Card Game is and where it runs.
    // This implements the methods from GameInterface to remove duplication of code between game classes
    //It also eradicates bad code smells

    // The random number generator used throughout
    public static RandomInterface r =new LinearCongruentialGenerator();

    // Variable(s) used in the card game methods
    public static ArrayList<String> cardList;
    public static HashSet<String> cardsChosen=new HashSet<String>();
    @Override
    public void play() {
        // Play card game:

        // Initialise the game
        Initialise();
        //This game needs initialising, therefore it is a local method rather than implemented
        // Play the main game phase
        main();

        // Now see if (s)he has won!
        declareWinner();

    }
    private void Initialise() {
        // The initialisation phase:

        // Create a list of cards ... and shuffle them
        String cards[]={"AHrts", "2Hrts", "3Hrts", "4Hrts", "5Hrts", "6Hrts",
                "7Hrts", "8Hrts", "9Hrts", "10Hrts", "JHrts",
                "QHrts", "KHrts",
                "ADmnds", "2Dmnds", "3Dmnds", "4Dmnds", "5Dmnds",
                "6Dmnds", "7Dmnds", "8Dmnds", "9Dmnds", "10Dmnds",
                "JDmnds", "QDmnds", "KDmnds",
                "ASpds", "2Spds", "3Spds", "4Spds", "5Spds", "6Spds",
                "7Spds", "8Spds", "9Spds", "10Spds", "JSpds",
                "QSpds", "KSpds",
                "AClbs", "2Clbs", "3Clbs", "4Clbs", "5Clbs", "6Clbs",
                "7Clbs", "8Clbs", "9Clbs", "10Clbs", "JClbs",
                "QClbs", "KClbs"};
        cardList=new ArrayList<String>(Arrays.asList(cards));
        // Taking advantage of "generics" to tell the compiler all the elements will be Strings

        // Shuffle them
        for (int i=0; i<100; i++) {
            // choose two random cards at random and swap them, 100 times
            int firstIndex=((int) (r.next() * 52));
            int secondIndex=((int) (r.next() * 52));
            String temp=(String) cardList.get(firstIndex);
            cardList.set(firstIndex, cardList.get(secondIndex));
            cardList.set(secondIndex, temp);
        }

        // Print out the result
        System.out.println(cardList);
    }

    @Override
    public void main()  {
        // The main game:
        // The BufferedReader used throughout
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // Let user select two cards from the pack
        for (int i=0; i<2; i++) {
            System.out.println("Hit <RETURN> to choose a card");
            // Catch the line with an Exception if the input is not as expected
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int cardChoice=(int) (r.next() * cardList.size());
            System.out.println("You chose " + cardList.get(cardChoice));
            cardsChosen.add(cardList.remove(cardChoice));
        }

        // Display the cards chosen and remaining cards
        System.out.println("Cards chosen: " + cardsChosen);
        System.out.println("Remaining cards: " + cardList);
    }

    @Override
    public void declareWinner() {
        // Declare the winner:

        // User wins if one of them is an Ace
        System.out.println("Cards chosen: " + cardsChosen);
        if (cardsChosen.contains("AHrts") || cardsChosen.contains("ADmnds") ||
                cardsChosen.contains("ASpds") || cardsChosen.contains("AClbs")) {
            System.out.println("You won!");
        }
        else System.out.println("You lost!");
    }


}
