package am.hitech.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "role")
@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role;
}
