# SpringBoot

스프링 부트 실습을 위한 저장소입니다.

# 스프링 컨테이너

GenericApplicationContext로 빈을 등록해서 사용하는 과정
1. applicationContext.**registerBean(HelloController.class)**: HelloController 클래스로 빈을 등록한다.
2. applicationContext.refresh(): 초기화
3. applciationContext.**getBean(HelloController.class)**: HelloController 빈을 꺼내 사용한다.

## 의존관계 주입
Controller와 Service 사이의 코드레벨의 의존관계를 제거하고, Service 인터페이스에 대해서만 의존하도록 만든다.

이렇게 되면 Service 구현체를 원하는대로 바꿔서 사용할 수 있게 된다.

이때, 주입을 담당하는건 제 3의 객체, 어셈블러가 담당한다.

## 환경

Java 17
Spring Boot 3.0.2

