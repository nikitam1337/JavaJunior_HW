package org.example.app;

import org.example.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

/*
Создайте базу данных (например, SchoolDB).
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
Настройте Hibernate для работы с вашей базой данных.
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

public class App {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            // Создание сессии
            Session session = sessionFactory.getCurrentSession();

            // Начало транзакции для создания и добавления объекта в таблицу
            session.beginTransaction();

            // Создание объекта
            Course course = new Course("Java developer", 12);
            session.save(course);
            System.out.println("Object course save successfully");

            // Создание объекта
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
