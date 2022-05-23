package com.example;

import com.example.controller.ApartmentController;
import com.example.controller.CalculationController;
import com.example.model.Apartment;
import com.example.service.ApartmentService;
import com.example.service.CalculatorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApartmentService apartmentService = new ApartmentService();
        ApartmentController apartmentController = new ApartmentController(apartmentService);
        String a1 = apartmentController.createTwoRoomApartment();
        apartmentController.addGuests(a1, 2);
        apartmentController.addGuests(a1, 3);
        CalculatorService calculatorService = new CalculatorService(apartmentController.getNumberOfResidents(a1), apartmentController.getNumberofGuests(a1), 3, 7, a1);
        CalculationController calculationController = new CalculationController(calculatorService);
        System.out.println(calculationController.calculateFinalBill());

        String a2 = apartmentController.createThreeRoomApartment();
        apartmentController.addGuests(a2, 4);
        apartmentController.addGuests(a2, 1);
        CalculatorService calculatorService2 = new CalculatorService(apartmentController.getNumberOfResidents(a2), apartmentController.getNumberofGuests(a2), 2, 1, a2);
        CalculationController cal2 = new CalculationController(calculatorService2);
        System.out.println(cal2.calculateFinalBill());


    }
}
