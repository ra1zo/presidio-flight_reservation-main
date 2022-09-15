package com.presidio.presidio;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "flights")

public class flights {
    @Id
    @Column(name = "flight_id")
    private int flight_id;

    @Column(name = "flight_name")
    private String flight_name;

    @Column(name = "seating_capacity")
    private int seating_capacity;


    @Column(name = "cities")
    private String cities;




    public flights() {
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public int getSeating_capacity() {
        return seating_capacity;
    }

    public void setSeating_capacity(int seating_capacity) {
        this.seating_capacity = seating_capacity;
    }


    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

}
