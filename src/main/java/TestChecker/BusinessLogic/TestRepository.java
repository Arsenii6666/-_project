package TestChecker.BusinessLogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import TestChecker.Data.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
