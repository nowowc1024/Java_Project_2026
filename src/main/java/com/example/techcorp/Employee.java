package com.example.techcorp;

public abstract class Employee implements Workable {
    private String name;
    private int skill;
    private double salary;

    public Employee(String name, int skill, double salary) {
        if (skill < 0 || skill > 10)
        throw new IllegalArgumentException("Skill must be between 0 and 10");
        this.name = name;
        this.skill = skill;
        this.salary = salary;
    }
    public String getName() { return name; }
    public int getSkill() { return skill; }
    public double getSalary() { return salary; }
   
    // work() required by Workable — each subclass provides its own version.
    public void printInfo() {
        System.out.println("Name: " + name
            + " | Skill: " + skill + " | Salary: " + salary);
    }
}