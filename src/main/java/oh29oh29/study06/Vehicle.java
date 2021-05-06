package oh29oh29.study06;

public interface Vehicle {
    static void staticDisplay() {
        System.out.println("Hello " + privateStaticDisplayName());
    }

    private static String privateStaticDisplayName() {
        return "Private Static";
    }

    default void defaultDisplay() {
        System.out.println("Hello " + privateDefaultDisplayName());
    }

    private String privateDefaultDisplayName() {
        return "Private Default";
    }

    void speedUp(int increment);
}
