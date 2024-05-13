package ClassroomLogin.BussnessLogic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public Optional<Course> findByCourseName(String courseName);
}
