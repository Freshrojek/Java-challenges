import java.io.*;
import java.util.*;

public class Game {
        public static void main(String[] args) throws Exception {
            // The BufferedReader used throughout
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            GameFactory GameFactory = new GameFactory();

            System.out.print("Card (c) or Die (d) game? ");
            String ans=br.readLine();

            GameInterface chosenGame = GameFactory.getGame(ans);

            chosenGame.play();

        }
}