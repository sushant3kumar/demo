package com.example.model;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Apartment  {

    private final String apartmentId;
    private final int numberOfRooms;
    private final ApartmentType apartmentType;
    private int numberOfResidents;
    private int numberOfGuests;

    
    public Apartment(@NonNull String apartmentId,@NonNull ApartmentType apartmentType) {
        this.apartmentId = apartmentId;
        if(apartmentType == ApartmentType.THREE_ROOM){
            this.apartmentType = apartmentType;
            this.numberOfRooms = 3;
            this.numberOfResidents = 5;
            this.numberOfGuests=0;
        }else{
            this.apartmentType = apartmentType;
            this.numberOfRooms = 2;
            this.numberOfResidents = 3;
            this.numberOfGuests=0;
        }
    }

    public void addGuest(int numberOfGuests) {
        this.numberOfGuests += numberOfGuests;
    }
    
}
