package org.example;

public class Dog extends Animal{
    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println("Гав-гав!");
    }

    public void sit(){  // команда "Сидеть!"
        System.out.println("Собака села");
    }

}
