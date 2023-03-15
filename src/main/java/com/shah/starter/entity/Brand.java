package com.shah.starter.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name= "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String brandName;

    @Column(name = "description")
    private String brandDescription;

    @OneToMany(mappedBy="brand",fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<User> associatedUsers = new ArrayList<>();

    public Brand() {
    }

    public Brand(String brandName, String brandDescription) {
        this.brandName = brandName;
        this.brandDescription = brandDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getAssociatedUsers() {
        return associatedUsers;
    }

    public void setAssociatedUsers(List<User> associatedUsers) {
        this.associatedUsers = associatedUsers;
    }
}
