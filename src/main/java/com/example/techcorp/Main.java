package com.example.techcorp;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.Employee;
import com.example.techcorp.domain.Manager;
import com.example.techcorp.domain.Project;
import com.example.techcorp.domain.Tester;
import com.example.techcorp.engine.GameEngine;
import com.example.techcorp.ui.ConsoleUI;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // === LESSON 8 DEMO ===================================
        List<Employee> team = new ArrayList<>();
        team.add(new Developer("Anna",  9, 8_000));
        team.add(new Tester   ("Piotr", 6, 6_500));
        team.add(new Manager  ("Ewa",   7, 9_000));

        System.out.println("=== Lesson 8: Polymorphism Demo ===");
        int totalWork = 0;
        for (Employee e : team) {
            int output = e.work();
            totalWork += output;
            System.out.println(
                e.getClass().getSimpleName()
                + " | Role: " + e.getRole()
                + " | Work: " + output
            );
        }
        System.out.println("Total work output: " + totalWork);
        System.out.println("====================================");
        // =====================================================

        Company company = new Company("TechCorp", 50_000);
        company.hire(new Developer("Anna",  9, 8_000));
        company.hire(new Tester   ("Piotr", 6, 6_500));
        company.hire(new Manager  ("Ewa",   7, 9_000));

        Project mobileApp = new Project("Mobile App", 30);
        Project website   = new Project("Website",    20);

        for (var employee : company.getEmployees()) {
            mobileApp.addEmployee(employee);
        }

        company.startProject(mobileApp);
        company.startProject(website);

        ConsoleUI  ui     = new ConsoleUI();
        GameEngine engine = new GameEngine(company, ui);
        engine.start();
    }
}
