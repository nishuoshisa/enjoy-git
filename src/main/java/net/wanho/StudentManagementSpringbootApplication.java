package net.wanho;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("net.wanho.mapper")
public class StudentManagementSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSpringbootApplication.class, args);
	}
}
