package vlad110kg.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlad110kg.core.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
