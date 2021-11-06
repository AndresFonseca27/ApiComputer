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

import co.usa.computer.computer.model.Computer;
import co.usa.computer.computer.service.ComputerServicio;

@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ComputerControlador {
    @Autowired
    private ComputerServicio computerServicio;

    @GetMapping("/all")
    public List<Computer>getComputer(){
        return computerServicio.getAll();
    }

    @GetMapping("/{numId}")
    public Optional<Computer>getComputer(@PathVariable("numId") int id){
        return computerServicio.getComputer(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer comp){
        return computerServicio.save(comp);
    }
}
