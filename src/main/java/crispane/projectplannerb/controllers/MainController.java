package crispane.projectplannerb.controllers;

import crispane.projectplannerb.data.ClientRepository;
import crispane.projectplannerb.data.ContactRepository;
import crispane.projectplannerb.model.contacts.Client;
import crispane.projectplannerb.model.contacts.Contact;
import net.bytebuddy.description.method.ParameterList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class MainController {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    @ModelAttribute(name = "client")
    public Client client(){
        return new Client();
    }

    @ModelAttribute(name = "contact")
    public Contact contact(){
        return new Contact();
    }

    @ModelAttribute(name = "clients")
    public void addClientsToModel(Model model) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        model.addAttribute("clients", clients);
    }
    public MainController(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    @PostMapping("/add")
    public @ResponseBody String addNewClient(@Valid @RequestParam String name) {

//        if (clientRepository.findByName(name) != null) {
//            return "Not Saved";
//        }else {
            Client client = new Client();
            client.setName(name);
            clientRepository.save(client);
            return "Saved";
//        }
    }

    @GetMapping
    public String showClientForm() {
        return "client";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public String processClient(@Valid Client client) {
        clientRepository.save(client);
        return "client";
    }

    @GetMapping("/contacts")
    public String showContactsForm() {
        return "contacts";
    }

    @PostMapping("/contacts")
    public String processContact(@Valid Contact contact) {
        contactRepository.save(contact);
        return "contacts";
    }
}