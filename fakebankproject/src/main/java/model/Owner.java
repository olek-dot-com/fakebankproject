package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    public  Owner() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccount(Account account) {
        if (accounts != null) {
            accounts.add(account);
            account.setOwner(this);
        }
    }
}
