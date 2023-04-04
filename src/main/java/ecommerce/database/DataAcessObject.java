package ecommerce.database;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataAcessObject<T> {
    public void insert(T objectToAdd) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(objectToAdd);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }

    public List<T> findAll(Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<T> request = session.createQuery("FROM " + tClass.getName(), tClass);

            list.addAll(request.getResultList());
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
        return list;
    }
}
