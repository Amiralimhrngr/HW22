package util;

import jakarta.persistence.*;

import java.util.function.Function;

public final class HibernateUtil {
    private static HibernateUtil hibernateUtil;
    private static final String PERSISTENCE_UNIT = "postgres-pu";
    private static EntityManagerFactory emf;

    private HibernateUtil() {
    }

    public static EntityManagerFactory emf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static EntityManager em() {
        return emf().createEntityManager();
    }

    public static <T> T inTxReturn(Function<EntityManager, T> operation) {
        EntityManager em = em();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T result = operation.apply(em);
            tx.commit();
            return result;
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            em.close();
        }
    }

    public static <T> T read(Function<EntityManager, T> operation) {
        try (EntityManager em = em()) {
            return operation.apply(em);
        }
    }

    public static PersistenceUnitUtil getPersistenceUnitUtil() {
        return emf().getPersistenceUnitUtil();
    }

    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }
}
