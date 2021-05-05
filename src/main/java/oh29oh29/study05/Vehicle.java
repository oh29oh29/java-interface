package oh29oh29.study05;

public interface Vehicle {
    static void display() {
        System.out.println("Hello Vehicle");
    }

    void speedUp(int increment);
}
