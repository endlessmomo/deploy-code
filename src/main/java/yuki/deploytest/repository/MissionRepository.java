package yuki.deploytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuki.deploytest.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface MissionRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByStudentNumber(String studentNumber);

    List<Student> findAll();
}
