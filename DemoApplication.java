// package com.yugabyte.demo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class DemoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 	}

// }
package com.yugabyte.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

@Autowired
JdbcTemplate jdbcTemplate;

@Autowired
EmployeeRepository customerRepository;

public static void main(String[] args) {
  SpringApplication.run(DemoApplication.class, args);
}

@Override
public void run(String... args) throws Exception {

  System.out.println("Connected to the YugabyteDB server successfully.");
  jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
  jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee" +
              "  (id text primary key, name varchar, email varchar)");
  System.out.println("Created table employee");


  Employee customer = new Employee("sl1",
                "User One",
                "user@one.com");

  customerRepository.save(customer);

  Employee customerFromDB = null;
  customerFromDB = customerRepository.findByEmail("user@one.com");

  System.out.println(String.format("Query returned: name = %s, email = %s",
    customerFromDB.getName(), customerFromDB.getEmail()));

  }
}
