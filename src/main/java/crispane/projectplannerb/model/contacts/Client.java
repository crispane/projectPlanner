package crispane.projectplannerb.model.contacts;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(unique = true)
    @Size(min=3, message="Name must be at least 3 characters long.")
    private String name;

//    @Size(min=1, message="You must enter at least 1 contact.")
    @OneToMany(mappedBy = "client",
    orphanRemoval = true,
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
