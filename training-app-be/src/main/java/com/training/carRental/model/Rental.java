package com.training.carRental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@Entity(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public java.sql.Timestamp startData;

    public java.sql.Timestamp releaseData;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Client client;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Car car;



    public Rental() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Timestamp getStart_data() {
        return startData;
    }

    public void setStart_data(Timestamp start_data) {
        this.startData = startData;
    }

    public Timestamp getRelease_data() {
        return releaseData;
    }

    public void setRelease_data(Timestamp release_data) {
        this.releaseData = releaseData;
    }
};



