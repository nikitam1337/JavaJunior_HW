package org.example;

/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[]{
                new Dog("Мухтар", 5, "Бульдог"),
                new Dog("Рекс", 3, "Питбуль"),
                new Cat("Барсик", 3, "Черный"),
                new Cat("Пушок", 6, "Белый")
        };

        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName() + ":");
            System.out.println("Кличка: " + animal.name);
            System.out.println("Возраст: " + animal.age);

            try {
                Method method = animal.getClass().getMethod("makeSound");
                method.invoke(animal);
            } catch (Exception e) {
                System.out.println("Метод 'makeSound()' не найден.");
            }

            System.out.println();
        }


    }
}