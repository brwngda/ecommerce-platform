package ecommerce.database;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // READ - LIST
    public List<T> findAll(Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<T> zapytanie = session.createQuery("FROM " + tClass.getName(), tClass);

            list.addAll(zapytanie.getResultList());
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return list;
    }

    // READ - FIND BY ID
    public Optional<T> find(Class<T> tClass, Long id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            T entity = session.get(tClass, id);

            return Optional.ofNullable(entity);
        } catch (Exception ioe) {
            System.err.println("Error: " + ioe);
        }
        return Optional.empty();
    }


    // UPDATE
    public void update(Class<T> tClass, Long id, T updatedEntity) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            T entity = session.get(tClass, id);
            if (entity == null) {
                System.err.println("Record not found");
                return;
            }

            session.merge(updatedEntity);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    // potrzebny do update, ale opisać jako READ?
    public boolean exists(Class<T> tClass, Long id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            T entity = session.get(tClass, id);
            if (entity != null) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return false;
    }

    // DELETE
    public boolean delete(Class<T> tClass, Long id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            T entity = session.get(tClass, id);
            if (entity == null) {
                return false;
            }

            session.remove(entity);
            transaction.commit();
            return true;
        } catch (Exception ioe) {
            System.err.println("Błąd bazy: " + ioe);
        }

        return false;
    }
}
