package com.example.controller;

import com.example.service.ApartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    public String createTwoRoomApartment(){
        return apartmentService.createTwoRoomApartment().getApartmentId();
    }
    public String createThreeRoomApartment(){
        return apartmentService.createThreeRoomApartment().getApartmentId();
    }
    public void addGuests(String apartmentId,int numberOfGuests){
        apartmentService.addGuest(apartmentId, numberOfGuests);
    }
    public int getNumberofGuests(String apartmentId){
        return apartmentService.getApartment(apartmentId).getNumberOfGuests();
    }
    public int getNumberOfResidents(String apartmentId){
        return apartmentService.getApartment(apartmentId).getNumberOfResidents();
    }
}
