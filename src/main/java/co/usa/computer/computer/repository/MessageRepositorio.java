package co.usa.computer.computer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.computer.computer.model.Message;
import co.usa.computer.computer.repository.crud.MessageCrudRepositorio;

@Repository
public class MessageRepositorio {
    @Autowired
    private MessageCrudRepositorio messageCrudRepositorio;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepositorio.findAll();
    }

    public Optional<Message>getMessage(int id){
        return messageCrudRepositorio.findById(id);
    }

    public Message save(Message mensaje){
        return messageCrudRepositorio.save(mensaje);
    }
    
}
