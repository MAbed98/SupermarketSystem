package com.example.demo.model;




import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars" , uniqueConstraints={@UniqueConstraint(columnNames={"emailUser"})})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id ;

    @NotNull(message = "Model must be NOT EMPTY !")
    @Column(nullable = false, unique = true)
    private String model ;

    @Column(name = "emailUser",unique = true )
    @Email(message = "Email not valid")
//    @UniqueElements(message = "already exist email ")
    private String emailUser ;

    public Car(Integer id, @NotNull(message = "Model must be NOT EMPTY !") String model,
               @Email(message = "Email not valid") String emailUser) {
        this.id = id;
        this.model = model;
        this.emailUser = emailUser;
    }

    public Car(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", emailUser='" + emailUser + '\'' +
                '}';
    }
}
