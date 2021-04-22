public class Hamster extends Pet implements Vegetarian {
	protected String name;


	@Override
	public String food() {
		return("beans");
	}
}
