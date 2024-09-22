package ru.neoflex.vacation.calculator.services;

import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {

    public double calculate(double averageSalary, int daysOff) {
        return averageSalary / 29.3 * daysOff;
    }

}
