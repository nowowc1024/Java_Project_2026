package com.example.techcorp;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TechCorp Simulator Starting ===");
        System.out.println();

        // Employees and company
        Company techCorp = new Company("TechCorp");
        Employee anna = new Developer("Anna", 9, 8000);
        Employee piotr = new Tester("Piotr", 6, 6500);
        Employee kate = new Manager("Kate", 7, 9000);

        techCorp.hire(anna);
        techCorp.hire(piotr);
        techCorp.hire(kate);

        System.out.println("=== Hired Employees ===");
        anna.printInfo();
        piotr.printInfo();
        kate.printInfo();
        System.out.println();

        // Lesson 4A: Basic lifecycle
        System.out.println("=== Lesson 4A: Status Lifecycle ===");
        Project project1 = new Project("TechCorp App v1", 50);
        techCorp.startProject(project1);

        project1.addEmployee(anna);
        project1.addEmployee(piotr);
        project1.addEmployee(kate);

        System.out.println("Attempting to work before start():");
        project1.workOneTurn();
        System.out.println();

        project1.start();
        project1.printStatus();

        while (!project1.isFinished()) {
            project1.workOneTurn();
        }

        project1.printStatus();
        System.out.println("Project 1 done in " + project1.getTurns() + " turn(s)!");
        System.out.println();

        // 4A Exercises 1 & 2: ON_HOLD / resume
        System.out.println("=== 4A Exercises 1 & 2: ON_HOLD and Resume ===");
        Project project2 = new Project("TechCorp App v2", 100);
        techCorp.startProject(project2);

        project2.addEmployee(anna);
        project2.addEmployee(piotr);
        project2.addEmployee(kate);

        project2.start();
        project2.workOneTurn();
        project2.putOnHold();

        System.out.println("Attempting to work while ON_HOLD:");
        project2.workOneTurn();
        System.out.println();

        project2.resume();

        while (!project2.isFinished()) {
            project2.workOneTurn();
        }

        project2.printStatus();
        System.out.println("Project 2 done in " + project2.getTurns() + " turn(s)!");
        System.out.println();

        // 4A: Cancel demo
        System.out.println("=== 4A: Cancel Demo ===");
        Project cancelled = new Project("Cancelled Feature", 200);
        cancelled.start();
        cancelled.workOneTurn();
        cancelled.cancel();
        cancelled.printStatus();
        System.out.println();

        // 4B: Mixed Workable team
        System.out.println("=== Lesson 4B: Mixed Workable Team ===");
        AutomatedTool ciPipeline = new AutomatedTool("CI Pipeline", 5);
        FreelancerBot contractBot = new FreelancerBot("ContractBot-X", 4);

        ciPipeline.printInfo();
        contractBot.printInfo();
        System.out.println();

        Project mobileApp = new Project("Mobile App", 60);
        techCorp.startProject(mobileApp);

        mobileApp.addWorker(anna);
        mobileApp.addWorker(piotr);
        mobileApp.addWorker(kate);
        mobileApp.addWorker(ciPipeline);
        mobileApp.addWorker(contractBot);

        mobileApp.start();

        while (!mobileApp.isFinished()) {
            mobileApp.workOneTurn();
        }

        mobileApp.printStatus();
        System.out.println("Mobile App done in " + mobileApp.getTurns() + " turn(s)!");
        System.out.println();

        // Full company status
        techCorp.printStatus();
        System.out.println();

        // Polymorphism demo
        System.out.println("=== Polymorphism Demo ===");
        Employee[] all = { anna, piotr, kate };

        for (Employee e : all) {
            System.out.println(e.getName() + " produced: " + e.work());
        }

        System.out.println();

        // Skill validation
        System.out.println("=== Skill Validation Demo ===");
        try {
            Employee invalid = new Developer("BadHire", 15, 5000);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Simulation Complete ===");
    }
}