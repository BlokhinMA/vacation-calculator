package ru.neoflex.vacation.calculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.vacation.calculator.services.VacationCalculatorService;

@RestController
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<?> calculate(@RequestParam("average_salary") double averageSalary, @RequestParam("days_off") int daysOff) {
        if (averageSalary <= 0 || daysOff <=0)
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        return ResponseEntity.ok(vacationCalculatorService.calculate(averageSalary, daysOff));
    }

}
