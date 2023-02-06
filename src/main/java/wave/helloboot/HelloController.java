package wave.helloboot;


import java.util.Objects;

public class HelloController {

    public String hello(String name) {
        SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name)); //name이 null인 경우 예외 발생
    }

}
