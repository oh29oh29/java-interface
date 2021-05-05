package oh29oh29.study02;

/**
 * study02 패키지는 인터페이스로 익명 클래스를 구현하는 방법에 대해서 확인하기 위해 작성되었다.
 */
public class Main {
    public static void main(String[] args) {
        Vehicle bicycle = new Vehicle() {
            int speed;

            @Override
            public void speedUp(int increment) {
                speed += increment;
                System.out.println("Bicycle speed up: " + increment);
            }
        };

        bicycle.speedUp(10);
        System.out.println(Vehicle.seatCount);
    }
}
