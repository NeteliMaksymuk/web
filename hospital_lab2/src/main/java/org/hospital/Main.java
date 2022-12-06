package org.hospital;


import org.hibernate.Session;
import org.hospital.connection_pool.SessionUtil;
import org.hospital.dao.AdminDAO;
import org.hospital.dao.MedicalWorkerDAO;
import org.hospital.dao.PatientDAO;
import org.hospital.dao.TreatingCardDAO;
import org.hospital.dao.implementations.AdminDAOImpl;
import org.hospital.dao.implementations.MedicalWorkerDAOImpl;
import org.hospital.dao.implementations.PatientDAOImpl;
import org.hospital.dao.implementations.TreatingCardDAOImpl;
import org.hospital.entity.*;
import org.hospital.worker_builder.MedicalWorkerBuilder;

public class Main {
    public static void main(String[] args) {
        Session session = SessionUtil.getSessionFactory().openSession();
        TreatingCardDAO treatingCardDAO = new TreatingCardDAOImpl(session);
        session.beginTransaction();

        TreatingCard card1 = treatingCardDAO.getTreatingCardById(1);
        TreatingCard card2 = treatingCardDAO.getTreatingCardById(2);
        card1.setStatus(Status.DONE);
        treatingCardDAO.updateTreatingCard(card1);
        treatingCardDAO.deleteTreatingCard(card2);

        session.getTransaction().commit();
        session.close();
    }
}
