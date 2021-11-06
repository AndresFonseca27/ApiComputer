package co.usa.computer.computer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.computer.computer.model.Message;
import co.usa.computer.computer.repository.MessageRepositorio;

@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepositorio;

    public List<Message>getAll(){
        return messageRepositorio.getAll();
    }

    public Optional<Message>getMessage(int id){
        return messageRepositorio.getMessage(id);
    }

    public Message save(Message mensaje){
        //Verificación si el Computador es Nuevo, si es nuevo se Guarda

        if (mensaje.getIdMessage()==null){
            return messageRepositorio.save(mensaje);
        // Si el objeto vienen con unID Verificamos si existe o no    
        }else{
            Optional<Message> consulta=messageRepositorio.getMessage(mensaje.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepositorio.save(mensaje);

            }else{
                return mensaje;
            }
        }    
    } 
          
}
