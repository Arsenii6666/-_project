package ClassroomLogin.BusinessLogic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Integer> {
    public Optional<ClientProfile> findByLogin(String login);
}
