# SpringBoot

스프링 부트 실습을 위한 저장소입니다.

# 스프링 컨테이너

GenericApplicationContext로 빈을 등록해서 사용하는 과정
1. applicationContext.**registerBean(HelloController.class)**: HelloController 클래스로 빈을 등록한다.
2. applicationContext.refresh(): 초기화
3. applciationContext.**getBean(HelloController.class)**: HelloController 빈을 꺼내 사용한다.

## 환경

Java 17
Spring Boot 3.0.2

