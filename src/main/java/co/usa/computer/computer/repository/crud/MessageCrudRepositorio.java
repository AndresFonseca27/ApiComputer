package co.usa.computer.computer.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.computer.computer.model.Message;

public interface MessageCrudRepositorio extends CrudRepository<Message, Integer> {
    
}
