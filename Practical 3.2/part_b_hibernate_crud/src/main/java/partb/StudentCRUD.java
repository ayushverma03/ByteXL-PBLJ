package partb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentCRUD {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {
            // CREATE
            session = factory.openSession();
            session.beginTransaction();
            Student s1 = new Student("Ayush", 21);
            session.save(s1);
            session.getTransaction().commit();
            System.out.println("Created student id: " + s1.getId());

            // READ single
            session = factory.openSession();
            Student found = session.get(Student.class, s1.getId());
            System.out.println("Read student: " + found.getName());

            // READ all
            session = factory.openSession();
            List<Student> list = session.createQuery("from Student", Student.class).list();
            System.out.println("All students:");
            list.forEach(s -> System.out.println(s.getId() + " " + s.getName() + " " + s.getAge()));

            // UPDATE
            session = factory.openSession();
            session.beginTransaction();
            Student toUpdate = session.get(Student.class, s1.getId());
            toUpdate.setAge(22);
            session.update(toUpdate);
            session.getTransaction().commit();
            System.out.println("Updated student age to 22");

            // DELETE
            session = factory.openSession();
            session.beginTransaction();
            Student toDelete = session.get(Student.class, s1.getId());
            session.delete(toDelete);
            session.getTransaction().commit();
            System.out.println("Deleted student id: " + s1.getId());

        } finally {
            if (session != null) session.close();
            factory.close();
        }
    }
}
