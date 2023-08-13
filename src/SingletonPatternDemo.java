class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent external instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, I am the Singleton instance!");
    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance();
        Singleton secondInstance = Singleton.getInstance();

        // Both instances will refer to the same object
        System.out.println(firstInstance == secondInstance); // Output: true

        firstInstance.showMessage(); // Output: Hello, I am the Singleton instance!
    }
}
