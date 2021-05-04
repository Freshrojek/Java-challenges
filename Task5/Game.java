import java.io.*;
import java.util.*;

public class Game {
        public static void main(String[] args) throws Exception {
            // The BufferedReader used to ask which game the user would like to play
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            //Initialise the Game Factory
            GameFactory GameFactory = new GameFactory();

            //Ask the user which game to run and store their answer
            System.out.print("Card (c) or Die (d) game? ");
            String ans=br.readLine();

            //Get an object of whichever game the user chooses
            GameInterface chosenGame = GameFactory.getGame(ans);

            // Call the play() method of the chosen game to run the game.
            chosenGame.play();

        }
}