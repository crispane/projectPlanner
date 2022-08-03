package crispane.projectplannerb.data;

import crispane.projectplannerb.model.contacts.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Contact findByName(String name);
}
