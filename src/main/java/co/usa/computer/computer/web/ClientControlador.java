package co.usa.computer.computer.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.computer.computer.model.Client;
import co.usa.computer.computer.service.ClientServicio;



@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ClientControlador {
    @Autowired

    private ClientServicio clientServicio;

    @GetMapping("/all")
    public List<Client>getClient(){
        return clientServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client>getClient(@PathVariable("id") int id){
        return clientServicio.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client cliente){
        return clientServicio.save(cliente);
    }
    
}
