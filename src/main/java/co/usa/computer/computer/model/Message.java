package co.usa.computer.computer.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name= "Message")
public class Message {

    //Campo llave primaria y autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    //Realizamos la relacion de cardinalidad Message-Computer
    @ManyToOne    
    @JoinColumn(name="computerId")
    @JsonIgnoreProperties({"message","reservation"})
    private Computer computer;

    //Realizamos la Relación de Message-Client
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"message","reservation"})
    private Client client;
  
    
    public Integer getIdMessage() {
        return idMessage;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    
   
}