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

import co.usa.computer.computer.model.Message;
import co.usa.computer.computer.service.MessageServicio;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class MessageControlador {
    @Autowired
    private MessageServicio messageServicio;

    @GetMapping("/all")
    public List<Message>getMessage(){
        return messageServicio.getAll();
    }

    @GetMapping("/{idMessage}")
    public Optional<Message>getMessage(@PathVariable("idMessage") int id){
        return messageServicio.getMessage(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message mensaje){
        return messageServicio.save(mensaje);
    }
}
