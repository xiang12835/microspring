package online.flyingfish.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("online.flyingfish.office.dao")
public class OfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}
}

