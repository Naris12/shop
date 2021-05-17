package com.Shop.test.Model;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.mapping.Set;

import javax.persistence.*;

@Data
@Entity
public class UserModel {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserModel() {
    }

    public UserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }



}
