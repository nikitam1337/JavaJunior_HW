package org.example.app;

import org.example.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;

public class App_V2 {

    public static void main(String[] args) {

        String[] options = {"1- Просмотреть весь список курсов",
                "2- Добавить курс",
                "3- Изменить курс",
                "4- Удалить курс",
                "0- Выйти",
        };

        Scanner scanner = new Scanner(System.in);
        int option = 1;

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            while (option!=0){
                printMenu(options);
                try {
                    option = scanner.nextInt();
                    switch (option){
                        case 1: viewTheCourses(sessionFactory.getCurrentSession()); break;
                        case 2: addCourse(sessionFactory.getCurrentSession()); break;
                        case 3: option3(); break;
                        case 4: option4(); break;
                        case 0: exit(0);
                    }
                }
                catch (Exception ex){
                    System.out.println("Пожалуйста, введите число от 1 до 4");
                    scanner.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Выберите пункт меню : ");
    }

    //region Options

    /**
     * Просмотр всего списка курсов из базы данных
     * @param session текущая сессия
     */
    private static void viewTheCourses(Session session) {
        // Начало транзакции для чтения данных из БД
        session.beginTransaction();

        String sql = "FROM Course ";

        List<Course> courses = session.createQuery(sql).list();

        for (Iterator<Course> it = courses.iterator(); it.hasNext();) {
            Course course = (Course) it.next();
            System.out.println(course);
        }
        // Закрытие сессии с сохранением
        session.getTransaction().commit();
    }
    private static void addCourse(Session session) {
        // Начало транзакции для создания и добавления объекта в таблицу
        session.beginTransaction();

        // Создание объекта
        Course course = new Course("Java developer2", 24);
        session.save(course);
        System.out.println("Курс успешно добавлен в таблицу");

        // Закрытие сессии с сохранением
        session.getTransaction().commit();
    }
    private static void option3() {
        System.out.println("Thanks for choosing option 3");
    }
    private static void option4() {
        System.out.println("Thanks for choosing option 4");
    }
    //endregion

}
