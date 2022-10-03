package com.emppayroll.repo;
import com.emppayroll.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<EmployeeEntity, Long> {
    //UC13
    @Query(value = "select * from employee_entity where first_name=:firstName",nativeQuery = true)
    List<EmployeeEntity>findEmployeeByName(String firstName);
    @Query(value="SELECT * FROM employee_entity WHERE department = :department", nativeQuery=true)
    List<EmployeeEntity> findByDepartment(String department);
}