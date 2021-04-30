public class GameFactory {
    public GameInterface getGame(String chosenGame){

        if (chosenGame.equals("c")) {
            return new CardGame();
        }

        else if (chosenGame.equals("d")) {
            return new DieGame();
        }

        else {
            System.out.println("Input not understood");
            return null;
        }
    }
}
