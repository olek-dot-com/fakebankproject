package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Owner")
public class Owner {
    public  Owner() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;


}
