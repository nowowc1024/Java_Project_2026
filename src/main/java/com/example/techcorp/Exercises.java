package com.example.techcorp;
public class Exercises {
// Exercise 3: Validate employees and salary, return monthly cost
public static int calculateMonthlyCost(int employees, int salary) {
if (employees <= 0) {
throw new IllegalArgumentException(
"Employees must be greater than zero.");
}
if (salary < 0) {
throw new IllegalArgumentException(
"Salary must not be negative.");
}
return employees * salary;
}
// Exercise 5: Divide with precondition check
public static double divide(double a, double b) {
if (b == 0) {
throw new IllegalArgumentException(
"Divisor must not be zero.");
}
return a / b;
}
}
