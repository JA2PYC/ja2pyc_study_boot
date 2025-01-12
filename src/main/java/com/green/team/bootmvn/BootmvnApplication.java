package com.green.team.bootmvn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootmvnApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootmvnApplication.class, args);

		PythonApplication pythonApplication = context.getBean(PythonApplication.class);
		pythonApplication.runPython();
	}


}
