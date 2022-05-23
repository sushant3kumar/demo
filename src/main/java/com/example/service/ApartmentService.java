package com.example.service;

import java.util.HashMap;
import java.util.UUID;

import com.example.exception.ApartmentNotFoundException;
import com.example.model.Apartment;
import com.example.model.ApartmentType;

import lombok.NonNull;

public class ApartmentService {
    private final HashMap<String,Apartment> apartments;

    public ApartmentService() {
        this.apartments = new HashMap<>();
    }

    public Apartment createThreeRoomApartment(){
       return createApartment(ApartmentType.THREE_ROOM);
    }

    public  Apartment createTwoRoomApartment(){
       return createApartment(ApartmentType.TWO_ROOM);
    }
    public  Apartment getApartment(String apartmentId){
        if(!apartments.containsKey(apartmentId)){
            throw new ApartmentNotFoundException();
        }
        return apartments.get(apartmentId);
    }
    public void addGuest(String apartmentId,int numberOfGuests){
        getApartment(apartmentId).addGuest(numberOfGuests);
    }
    private Apartment createApartment(@NonNull ApartmentType apartmentType){
        String apartmentId = UUID.randomUUID().toString();
        Apartment newApartment = new Apartment(apartmentId, apartmentType);
        apartments.put(apartmentId, newApartment);
        return newApartment;
    }
}
