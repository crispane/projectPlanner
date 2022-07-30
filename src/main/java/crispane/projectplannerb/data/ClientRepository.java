package crispane.projectplannerb.data;

import crispane.projectplannerb.model.contacts.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
