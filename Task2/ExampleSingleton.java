public class ExampleSingleton{
    private static int accessCount = 0;
    private static ExampleSingleton singletonInstance = new ExampleSingleton();


    private ExampleSingleton(){
        System.out.println("I, the ExampleSingleton, am being created");
    }

    public static ExampleSingleton getInstance(){
        System.out.println("The sole instance of ExampleSingleton is being retrieved");
        accessCount++;
        return singletonInstance;
        }

    public int accessCount(){
        return accessCount;
        }

}
