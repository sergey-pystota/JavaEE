package by.teachmeskills.entity.adress;

import by.teachmeskills.entity.Entity;

import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "addresses")
public class AddressEntity extends Entity {
    private String city;
    private String street;
    private int building;
    private int apartment;

    public AddressEntity() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
