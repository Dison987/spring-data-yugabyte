package com.yugabyte.demo;


import org.springframework.stereotype.Repository;

import com.yugabyte.data.jdbc.repository.YsqlRepository;


@Repository
public interface EmployeeRepository extends YsqlRepository<Employee, Integer> {

Employee findByEmail(final String email);

void save(Employee customer);





}
