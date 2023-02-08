package scheper.mateus.springgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scheper.mateus.springgpt.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

