package com.kiratech.javaknow.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane", "Doe");

    @Test
    void standardAssertions() {
        Assertions.assertEquals(2, calculator.add(1, 1));
        Assertions.assertEquals(4, calculator.multiply(2, 2), "msg");
        Assertions.assertTrue('a' < 'b', () -> "is a < b ?");
    }

    @Test
    void groupedAssertions() {
        Assertions.assertAll("person",
                () -> Assertions.assertEquals("Jane", person.getFirstName()),
                () -> Assertions.assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        Assertions.assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    Assertions.assertNotNull(firstName);
                    Assertions.assertAll("firstName",
                            () -> Assertions.assertTrue(firstName.startsWith("J")),
                            () -> Assertions.assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    String lastName = person.getLastName();
                    Assertions.assertNotNull(lastName);
                    Assertions.assertAll("lastName",
                            () -> Assertions.assertTrue(lastName.startsWith("D")),
                            () -> Assertions.assertTrue(lastName.endsWith("e"))
                    );

                }
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.divide(1, 0));
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        Assertions.assertTimeout(Duration.ofMinutes(2), () -> {
        });
    }
    @Test
    void timeoutNotExceededWithResult() {
        String acctualResult = Assertions.assertTimeout(Duration.ofMinutes(2), () -> "a result.");
        Assertions.assertEquals("a result.", acctualResult);

    }
    @Test
    void timeoutNotExceededWithMethod() {
        String acctualResult = Assertions.assertTimeout(Duration.ofMinutes(2), AssertionsDemo::greeting);
        Assertions.assertEquals("hello.", acctualResult);
    }

    @Test
    void timeoutExceeded() {
        Assertions.assertTimeout(Duration.ofMillis(10),()->{
            Thread.sleep(100);});
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(10),()->{
            Thread.sleep(100);});
    }
    public static String greeting() {
        return "hello.";
    }
}
