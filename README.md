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
기본적으로 모든 메서드는 빈 본문으로 선언되며 공용이고, 모든 필드는 public static final 이다.  

인터페이스를 구현하는 클래스는 인터페이스에 선언된 모든 메서드를 구현해야 한다.  
인터페이스를 구현하려면 implement 키워드를 사용한다.

```java
public interface House {
    // public static final
    int roomCount = 3;
    // public abstract
    void printHouseName();
}
```
```java
public class Apartment implements House {
    @Override
    public void printHouseName() {
        System.out.println("oh29oh29's house");
    }
}
```

<hr>

#### References

> 웹 문서
> - [geeksforgeeks | Interfaces in Java](https://www.geeksforgeeks.org/interfaces-in-java/)
