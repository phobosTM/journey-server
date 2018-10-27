package kz.phobos.tm.core.model;


import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "role")
    private String name;

    @Column(name = "username")
    private String username;


}
