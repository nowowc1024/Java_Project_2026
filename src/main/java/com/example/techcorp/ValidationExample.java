package com.example.techcorp;
public class ValidationExample {
public static double calculateAverage(int sum, int count) {
if (count <= 0) {
throw new IllegalArgumentException(
"Count must be greater than zero.");
}
return (double) sum / count;
}
public static void main(String[] args) {
try {
int totalSkill = 21;
int employeeCount = 3;
double average = calculateAverage(totalSkill, employeeCount);
System.out.println("Average skill: " + average);
// This will trigger the exception
double invalid = calculateAverage(totalSkill, 0);
System.out.println("This line will not be printed: " + invalid);
} catch (IllegalArgumentException e) {
System.out.println("Validation failed: " + e.getMessage());
}
}
}
