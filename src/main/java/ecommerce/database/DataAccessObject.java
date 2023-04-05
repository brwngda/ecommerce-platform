package ecommerce.database;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataAccessObject<T> {

    // CREATE
    public void insert(T objectToAdd) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(objectToAdd);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }

    // READ
    public List<T> findAll(Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<T> zapytanie = session.createQuery("FROM " + tClass.getName(), tClass);

            list.addAll(zapytanie.getResultList());
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
        return list;
    }

}
