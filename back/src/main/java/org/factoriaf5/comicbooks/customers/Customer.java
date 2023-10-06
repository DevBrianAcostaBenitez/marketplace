package org.factoriaf5.comicbooks.customers;

import java.util.HashSet;
import java.util.Set;
import org.factoriaf5.comicbooks.roles.Role;

import org.factoriaf5.comicbooks.orders.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dni")
    private String dni;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "surname2")
    private String surname2;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "gate")
    private String gate;

    @Column(name = "stair")
    private String stairs;

    @Column(name = "floor")
    private String floor;

    @Column(name = "letter")
    private String letter;

    @Column(name = "postalcode")
    private int postalcode;

    @Column(name = "town")
    private String town;

    @Column(name = "province")
    private String province;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    public Set<Order> orders = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "role_id") 
    private Role role;

    public Customer(String email, String dni, String name, String surname, String surname2, String street, int number,
            String gate, String stairs, String floor, String letter, int postalcode, String town, String province,
            String password) {
        this.email = email;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.street = street;
        this.number = number;
        this.gate = gate;
        this.stairs = stairs;
        this.floor = floor;
        this.letter = letter;
        this.postalcode = postalcode;
        this.town = town;
        this.province = province;
        this.password = password;
    }

    public Customer(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getStairs() {
        return stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    

}
