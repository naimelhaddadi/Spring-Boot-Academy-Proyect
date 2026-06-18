package com.naim.academiaprogramacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
