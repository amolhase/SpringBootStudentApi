package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Marks;
import com.bean.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value="select * from student s where s.email = ?1",nativeQuery = true)

	Optional<Student> findEmailIid(String email);


}
