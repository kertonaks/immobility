package service;

import model.RealEstate;
import model.House;
import model.Apartment;
import model.Garage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RealEstateService {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    // Save or Update RealEstate
    public void saveOrUpdateRealEstate(RealEstate realEstate) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(realEstate);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Retrieve all RealEstates
    public List<RealEstate> getAllRealEstates() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from RealEstate", RealEstate.class).list();
        }
    }

    // Get RealEstate by ID
    public RealEstate getRealEstateById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(RealEstate.class, id);
        }
    }

    // Delete RealEstate
    public void deleteRealEstate(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            RealEstate realEstate = session.get(RealEstate.class, id);
            if (realEstate != null) {
                session.delete(realEstate);
                System.out.println("RealEstate deleted successfully");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
