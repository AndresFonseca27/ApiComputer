package co.usa.computer.computer.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "Computer")
public class Computer {

    //Campo llave primaria y autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    //Realizamos la Relación de Computer-Categoria
    @ManyToOne    
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("computer")
    private Category category;

    // Realizamos la Relación de Computar-Message
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "computer")
    @JsonIgnoreProperties({"computer","client"})
    private List<Message> message;

     // Realizamos la Relación de Computer-Reservation
     @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "computer")
     @JsonIgnoreProperties({"computer","message"})
     private List<Reservation> reservation;
    
    
    public List<Reservation> getReservation() {
        return reservation;
    }
    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
    public List<Message> getMessage() {
        return message;
    }
    public void setMessage(List<Message> message) {
        this.message = message;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
  
    
    
    
    
}
