package oh29oh29.study01;

public class Apartment implements House {
    @Override
    public void printHouseName() {
        System.out.println("oh29oh29's house");
    }

    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        apartment.printHouseName();
        System.out.println(Apartment.roomCount);
    }
}
