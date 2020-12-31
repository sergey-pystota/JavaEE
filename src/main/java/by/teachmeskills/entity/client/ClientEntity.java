package by.teachmeskills.entity.client;

import by.teachmeskills.entity.Entity;
import by.teachmeskills.entity.adress.AddressEntity;
import by.teachmeskills.entity.order.OrderEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ClientEntity extends Entity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id_fk", referencedColumnName = "id")
    private AddressEntity address;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")

    private List<OrderEntity> orderEntity;

    public ClientEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<OrderEntity> getOrderEntity() {
        return new ArrayList<>(orderEntity);
    }


}
