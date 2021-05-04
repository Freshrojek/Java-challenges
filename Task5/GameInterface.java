
public interface GameInterface {
  // An interface to define all the methods a every Game needs
  void play() throws Exception;
//  void Initialise() throws Exception;
  //Initialise() isn't in this interface as DieGame does not need to be initialised,
  //Using it would be a bad code smell.
  void main() throws Exception;
  void declareWinner() throws Exception;




}
