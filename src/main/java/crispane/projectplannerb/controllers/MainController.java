package crispane.projectplannerb.controllers;

import crispane.projectplannerb.data.ClientRepository;
import crispane.projectplannerb.model.contacts.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class MainController {

    private final ClientRepository clientRepository;

    @ModelAttribute(name = "client")
    public Client client(){
        return new Client();
    }

    public MainController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/add")
    public @ResponseBody String addNewClient(@RequestParam String name) {

        Client client = new Client();
        client.setName(name);
        clientRepository.save(client);
        return "Saved";
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
}