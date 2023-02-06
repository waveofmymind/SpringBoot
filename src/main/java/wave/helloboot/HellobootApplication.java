package wave.helloboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		applicationContext.registerBean(HelloController.class);
		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					//인증, 보안, 다국어, 공통 기능
					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");

						HelloController helloController = applicationContext.getBean(HelloController.class);
						String ret = helloController.hello(name);

						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
					}
					else if (req.getRequestURI().equals("/user")) {
						//
					}
					else{
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*"); // /이후에 들어오는 모든 요청 다 받아들임
		});
		webServer.start();
	}

}
