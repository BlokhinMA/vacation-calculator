package ru.neoflex.vacation.calculator.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VacationCalculatorServiceTest {

    private VacationCalculatorService vacationCalculatorService;

    @BeforeEach
    public void setUp() {
        vacationCalculatorService = new VacationCalculatorService();
    }

    @Test
    public void testCalculateCorrectValues() {
        double averageSalary = 1000.0;
        int daysOff = 10;
        double expectedAmount = averageSalary / 29.3 * daysOff;

        double actualAmount = vacationCalculatorService.calculate(averageSalary, daysOff);

        Assertions.assertEquals(expectedAmount, actualAmount, 0.001);
    }

    @Test
    public void testCalculateZeroDaysOff() {
        double averageSalary = 1000.0;
        int daysOff = 0;

        double actualAmount = vacationCalculatorService.calculate(averageSalary, daysOff);

        Assertions.assertEquals(0.0, actualAmount, 0.001);
    }

    @Test
    public void testCalculateNegativeAverageSalary() {
        double averageSalary = -1000.0;
        int daysOff = 10;

        double actualAmount = vacationCalculatorService.calculate(averageSalary, daysOff);

        double expectedAmount = averageSalary / 29.3 * daysOff;
        Assertions.assertEquals(expectedAmount, actualAmount, 0.001);
    }

    @Test
    public void testCalculateNegativeDaysOff() {
        double averageSalary = 1000.0;
        int daysOff = -5;

        double actualAmount = vacationCalculatorService.calculate(averageSalary, daysOff);

        double expectedAmount = averageSalary / 29.3 * daysOff;
        Assertions.assertEquals(expectedAmount, actualAmount, 0.001);
    }

}