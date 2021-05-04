public class GameFactory {
    // This is a Game Factory that generates an object of a concrete class
    //It does this depending on what game the user selects in Game.java

    public GameInterface getGame(String chosenGame){

        //Generate a new Card Game if the user types 'c'
        if (chosenGame.equals("c")) {
            return new CardGame();
        }

        //Generate a new Die Game if the user types 'd'
        else if (chosenGame.equals("d")) {
            return new DieGame();
        }

        else {
            System.out.println("Input not understood");
            return null;
        }
    }
}
