package crispane.projectplannerb.controllers;

import crispane.projectplannerb.data.ClientRepository;
import crispane.projectplannerb.model.contacts.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class MainController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewClient (@RequestParam String name) {

        Client client = new Client();
        client.setName(name);
        clientRepository.save(client);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

