# Java Interface

클래스와 마찬가지로 인터페이스는 메서드와 변수를 가질 수 있지만 인터페이스에서 선언 된 메서드는 기본적으로 추상 메서드이다.

#### Syntax

```java
interface <interface_name> {
    // declare constant fields
    // declare methods that abstract 
    // by default.
}
```

인터페이스를 정의하려면 interface 키워드를 사용해야 한다.  
기본적으로 모든 메서드는 public abstract 으로 선언되며, 모든 필드는 public static final 이다.  

## 인터페이스 구현

인터페이스를 구현하는 클래스는 인터페이스에 선언된 모든 메서드를 구현해야 한다.  
인터페이스를 구현하려면 implement 키워드를 사용하며 여러개의 인터페이스를 구현할 수 있다.

```java
public interface Vehicle {
    int seatCount = 2;
    void speedUp(int increment);
}
```
```java
public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
```

#### 익명 클래스

인터페이스로 익명 클래스를 인스턴스화할 수도 있다.

```java
new <interface_name> {...}
```

익명 클래스를 인스턴스화하면 해당 인스턴스를 참조할 수 있도록 변수에 인스턴스를 할당할 수 있다.

```java
public class Main {
    public static void main(String[] args) {
        Vehicle bicycle = new Vehicle() {
            private int speed;

            @Override
            public void speedUp(int increment) {
                speed += increment;
                System.out.println("Bicycle speed: " + speed);
            }
        };

        bicycle.speedUp(10);
        System.out.println(Vehicle.seatCount);
    }
}
```

## 인터페이스 상속

인터페이스는 다른 인터페이스를 상속할 수 있다.

```java
public interface MovingBody {
    void move();
}
```
```java
public interface Vehicle extends MovingBody {
    void speedUp(int increment);
}
```
```java
public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void move() {
        System.out.println("Bicycle move");
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
```

인터페이스는 여러개의 인터페이스를 상속받을 수 있다.

## 인터페이스의 default 메서드와 static 메서드

Java 8 부터 인터페이스에 default 메서드와 static 메서드가 추가되었다.

#### default 메서드

Java 8 이전에는 인터페이스는 메서드를 선언만 가능하고 직접 정의할 수는 없었다.
default 메서드는 특별한 용도로 구현되며 이미 해당 인터페이스를 구현한 클래스들에게 영향을 주지 않는다.  

이미 존재하는 인터페이스에 새 기능을 추가해야 한다고 가정해보자.  
해당 인터페이스를 구현하고 있는 클래스들을 이런 새로운 기능을 구현하지 않았기 때문에 문제를 일으킨다.  
그래서 default 메서드로 새 기능을 추가함으로써 이미 존재하는 클래스들이 문제 없이 잘 동작하도록 할 수 있다.

```java
public interface Vehicle {
    default void display() {
        System.out.println("Hello Vehicle");
    }

    void speedUp(int increment);
}
```
```java
public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.speedUp(10);
        bicycle.display();
    }
}
```

#### static 메서드

Java 8 부터 인터페이스에 구현체 없이 독립적으로 호출할 수 있는 static 메서드를 정의할 수 있다.  
이러한 메서드는 상속되지 않는다.  

```java
public interface Vehicle {
    static void display() {
        System.out.println("Hello Vehicle");
    }

    void speedUp(int increment);
}
```
```java
public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.speedUp(10);
        Vehicle.display();
    }
}
```

## 인터페이스의 private 메서드

Java 9 부터 인터페이스에 private 메서드가 추가되었다.  
private 메서드는 인터페이스 내에서 코드 재사용성을 높이고 의도한 메서드 구현만 사용자에게 노출할 수 있는 장점을 제공한다.  

private 메서드는 해당 인터페이스 내에서만 접근할 수 있으며 다른 인터페이스 또는 클래스로 접근하거나 상속할 수 없다.  

```java
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
```
```java
public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.speedUp(10);
        bicycle.defaultDisplay();
        Vehicle.staticDisplay();
    }
}
```

<hr>

#### References

> 웹 문서
> - [geeksforgeeks | Interfaces in Java](https://www.geeksforgeeks.org/interfaces-in-java/)
> - [geeksforgeeks | Interfaces and Inheritance in Java](https://www.geeksforgeeks.org/interfaces-and-inheritance-in-java/)
> - [geeksforgeeks | Private Methods in Java 9 Interfaces](https://www.geeksforgeeks.org/private-methods-java-9-interfaces/)
> - [baeldung | Anonymous Classes in Java](https://www.baeldung.com/java-anonymous-classes#2-implement-an-interface)
