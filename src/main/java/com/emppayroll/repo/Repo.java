package com.emppayroll.repo;
import com.emppayroll.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<EmployeeEntity, Long> {
}