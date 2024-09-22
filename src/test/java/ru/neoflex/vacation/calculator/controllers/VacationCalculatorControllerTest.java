package ru.neoflex.vacation.calculator.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import ru.neoflex.vacation.calculator.services.VacationCalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VacationCalculatorControllerTest {

    @InjectMocks
    private VacationCalculatorController vacationCalculatorController;

    @Mock
    private VacationCalculatorService vacationCalculatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateWhenParametersAreValid() {
        double averageSalary = 50000;
        int daysOff = 10;
        Double expectedResponse = 1000.0;

        when(vacationCalculatorService.calculate(averageSalary, daysOff)).thenReturn(expectedResponse);

        ResponseEntity<?> response = vacationCalculatorController.calculate(averageSalary, daysOff);

        assertEquals(ResponseEntity.ok(expectedResponse), response);
    }

    @Test
    void testCalculateWhenAverageSalaryIsZero() {
        double averageSalary = 0;
        int daysOff = 10;

        ResponseEntity<?> response = vacationCalculatorController.calculate(averageSalary, daysOff);

        assertEquals(ResponseEntity.badRequest().build(), response);
    }

    @Test
    void testCalculateWhenDaysOffIsZero() {
        double averageSalary = 50000;
        int daysOff = 0;

        ResponseEntity<?> response = vacationCalculatorController.calculate(averageSalary, daysOff);

        assertEquals(ResponseEntity.badRequest().build(), response);
    }

    @Test
    void testCalculateWhenParametersAreNegative() {
        double averageSalary = -1000;
        int daysOff = -5;

        ResponseEntity<?> response = vacationCalculatorController.calculate(averageSalary, daysOff);

        assertEquals(ResponseEntity.badRequest().build(), response);
    }

}
