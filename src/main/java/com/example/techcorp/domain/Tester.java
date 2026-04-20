package com.example.techcorp.domain;

public class Tester extends Employee {

    public Tester(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    @Override
    public int work() {
        return getSkill();
    }

    @Override
    public String getRole() { return "Tester"; }
}
