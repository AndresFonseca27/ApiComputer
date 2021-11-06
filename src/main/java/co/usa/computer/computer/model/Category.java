package co.usa.computer.computer.model;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name= "Category")
public class Category {

    //Campo llave primaria y autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;


    // Realizamos la Relación de Categoria-Computar
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties({"category","message"})
    private List<Computer> computer;

    
    
    public List<Computer> getComputer() {
        return computer;
    }
    public void setComputer(List<Computer> computer) {
        this.computer = computer;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
