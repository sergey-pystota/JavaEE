package by.teachmeskills.dao.orm.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SessionFactoryProvider {
    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;
    private static final Lock LOCK = new ReentrantLock();

    private SessionFactoryProvider() {
    }

    private static class SessionFactoryHolder {
        private static final SessionFactoryProvider INSTANCE = new SessionFactoryProvider();
    }

    public static SessionFactoryProvider getInstance() {
        return SessionFactoryHolder.INSTANCE;
    }

    public void init() {
        if (this.sessionFactory == null) {
            System.out.println("init");
            try {
                LOCK.lock();
                registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                Metadata sources = new MetadataSources(registry).getMetadataBuilder().build();
                sessionFactory = sources.getSessionFactoryBuilder().build();
                System.out.println("are building");
            } finally {
                LOCK.unlock();
            }
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
