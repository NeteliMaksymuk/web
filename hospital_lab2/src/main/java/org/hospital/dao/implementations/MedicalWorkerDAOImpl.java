package org.hospital.dao.implementations;


import org.hibernate.Session;
import org.hospital.dao.MedicalWorkerDAO;
import org.hospital.entity.MedicalWorker;

import java.util.List;

public class MedicalWorkerDAOImpl implements MedicalWorkerDAO {

    private final Session session;

    public MedicalWorkerDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addNewMedicalWorker(MedicalWorker medicalWorker) {
        session.save(medicalWorker);
    }

    @Override
    public MedicalWorker getMedicalWorkerById(int id) {
        return session.createQuery("SELECT mw FROM MedicalWorker mw WHERE mw.id = :id", MedicalWorker.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public MedicalWorker getMedicalWorkerByEmail(String email) {
        return session.createQuery("SELECT mw FROM MedicalWorker mw WHERE mw.email = :email", MedicalWorker.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public List<MedicalWorker> getAll() {
        return session.createQuery("SELECT mw FROM MedicalWorker mw", MedicalWorker.class)
                .list();
    }

    @Override
    public void updateMedicalWorker(MedicalWorker medicalWorker) {
        session.save(medicalWorker);
    }

    @Override
    public void deleteMedicalWorker(MedicalWorker medicalWorker) {
        session.createQuery("DELETE FROM MedicalWorker mw WHERE mw.id = :id AND mw.firstName = :firstName " +
                "AND mw.lastName = :lastName AND mw.email = :email")
                .setParameter("id", medicalWorker.getId())
                .setParameter("firstName", medicalWorker.getFirstName())
                .setParameter("lastName", medicalWorker.getLastName())
                .setParameter("email", medicalWorker.getEmail())
                .executeUpdate();
    }
}
