package com.example.service;

import java.util.HashMap;

import com.example.exception.ApartmentNotFoundException;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class CalculatorService {

    private final HashMap<String,Integer> billAmountbyApartment;
    private final String apartmentId;
    private final int numberOfResidents;
    private final int numberOfGuests;
    private final int corporationRatio;
    private final int borewellRatio;
    private final double borewellRate = 1.5;
    private final double corporationRate = 1.0;
    private final int numberOfLitersPerMember = 10;

    public CalculatorService(int numberOfResidents, int numberOfGuests, int corporationRatio, int borewellRatio, 
    String apartmentId) {
        this.apartmentId = apartmentId;
        this.billAmountbyApartment = new HashMap<>();
        this.numberOfResidents = numberOfResidents;
        this.numberOfGuests = numberOfGuests;
        this.corporationRatio = corporationRatio;
        this.borewellRatio = borewellRatio;
    }
    private int calculateTotalLiterByResidents(){
        return numberOfResidents * numberOfLitersPerMember * 30 ;
    }
    private int calculateTotalLiterByGuests(){
        return numberOfGuests * numberOfLitersPerMember * 30 ;
    }
    public int calculateMonthlyBill(){
        int billAmountByResidents = calculateResidentMonthlyBill(calculateTotalLiterByResidents());
        int billAmountByGuests = calculateGuestMonthlyBill(calculateTotalLiterByGuests());
        int finalAmount =  billAmountByGuests+billAmountByResidents;
        billAmountbyApartment.put(apartmentId, finalAmount);
        return finalAmount;
    }
    public int getFinalAmount(String apartmentId){
        if(!billAmountbyApartment.containsKey(apartmentId)){
            throw new ApartmentNotFoundException();
        }
        return billAmountbyApartment.get(apartmentId);
    }
    private int calculateResidentMonthlyBill(int totalLiterByResidents) {
        return (int)((((corporationRatio * 1.0)/((corporationRatio + borewellRatio) *1.0)) * corporationRate * totalLiterByResidents) +(((borewellRatio * 1.0)/((corporationRatio + borewellRatio) *1.0)) * borewellRate * totalLiterByResidents));
    }
    private int calculateGuestMonthlyBill(int totalLiterByGuests) {
        int guestMonthlyBill = 0;
        if(totalLiterByGuests>3000){
            guestMonthlyBill += (totalLiterByGuests-3000) * 8;
            totalLiterByGuests = 3000;
        }
        if(totalLiterByGuests > 1500 && totalLiterByGuests <= 3000)
        {
            guestMonthlyBill += (totalLiterByGuests-1500) * 5;
            totalLiterByGuests = 1500;
        }
        if(totalLiterByGuests > 500 && totalLiterByGuests <= 1500)
        {
            guestMonthlyBill += (totalLiterByGuests-500) * 3;
            totalLiterByGuests = 500;
        }
        if(totalLiterByGuests > 0 && totalLiterByGuests <= 500)
        {
            guestMonthlyBill += (totalLiterByGuests) * 2;
            totalLiterByGuests = 0;
        }
        return guestMonthlyBill;
    }


}
