package com.codegym;

public class TestCircle {

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        Circle circle1 = new Circle(2);
        System.out.println(circle1.getArea());
    }
}
