package com.jixl.e_ticket.flight;

import java.sql.Time;
import java.sql.Date;

public class Flight {

    public String iata;
    public int number;
    public String airline;
    public String departureCity;
    public String departureDate;
    public String departureTime;
    public String arrivalCity;
    public String arrivalDate;
    public String arrivalTime;
    public String transport;

    public Flight() {
    }

    public Flight(String iata, int number, String airline, String departureCity, String departureDate, String departureTime, String arrivalCity, String arrivalDate, String arrivalTime, String transport) {
        this.iata = iata;
        this.number = number;
        this.airline = airline;
        this.departureCity = departureCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalCity = arrivalCity;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.transport = transport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
