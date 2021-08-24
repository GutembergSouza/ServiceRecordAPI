package dio.gu.servicerecordapi.repositoy;

import dio.gu.servicerecordapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
