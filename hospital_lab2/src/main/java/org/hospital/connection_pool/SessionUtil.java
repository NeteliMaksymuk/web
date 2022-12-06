package org.hospital.connection_pool;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hospital.entity.*;

public class SessionUtil {

    private SessionUtil() {}
    private volatile static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }

        synchronized (SessionFactory.class) {
            try {
                if (sessionFactory == null) {
                    Configuration configuration = new Configuration();
                    ServiceRegistry serviceRegistry
                            = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

                    configuration.addAnnotatedClass(Admin.class);
                    configuration.addAnnotatedClass(HealingType.class);
                    configuration.addAnnotatedClass(MedicalWorker.class);
                    configuration.addAnnotatedClass(Patient.class);
                    configuration.addAnnotatedClass(Role.class);
                    configuration.addAnnotatedClass(Status.class);
                    configuration.addAnnotatedClass(StatusInHospital.class);
                    configuration.addAnnotatedClass(TreatingCard.class);

                    sessionFactory = configuration
                            .buildSessionFactory(serviceRegistry);

                }
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to build session factory");
            }
        }
    }
}
