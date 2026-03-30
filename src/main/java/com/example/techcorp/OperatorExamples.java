package com.example.techcorp;
public class OperatorExamples {
public static void main(String[] args) {
// --- Exercise 1: Operator Classification ---
int a = 10, b = 3;
boolean finished = false;
int progress = 40;
// Arithmetic operator (+)
System.out.println("a + b = " + (a + b));
// Relational operator (>=)
System.out.println("a >= b: " + (a >= b));
// Logical NOT operator (!)
System.out.println("!finished: " + (!finished));
// Compound assignment operator (+=)
progress += 10;
System.out.println("progress after += 10: " + progress);
// Ternary / conditional operator
int x = 5, y = 9;
int max = (x > y) ? x : y;
System.out.println("Max of x and y: " + max);
System.out.println();
// --- Exercise 2: Type-Dependent Meaning of + ---
int num1 = 7, num2 = 5;
int numResult = num1 + num2;
System.out.println("Number addition: " + num1 + " + "
+ num2 + " = " + numResult);
String s1 = "Tech";
String s2 = "Corp";
String strResult = s1 + s2;
System.out.println("String concatenation: " + s1 + " + "
+ s2 + " = " + strResult);
}
}
