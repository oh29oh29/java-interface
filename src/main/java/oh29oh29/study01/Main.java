package oh29oh29.study01;

/**
 * study01 패키지는 인터페이스 기본 구현에 대해서 확인하기 위해 작성되었다.
 */
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.speedUp(10);
        System.out.println(Bicycle.seatCount);
    }
}
