package org.hospital.dao.implementations;


import org.hibernate.Session;
import org.hospital.dao.PatientDAO;
import org.hospital.entity.MedicalWorker;
import org.hospital.entity.Patient;

import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    private final Session session;

    public PatientDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addNewPatient(Patient patient) {
        session.save(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return session.createQuery("SELECT pt FROM Patient pt WHERE pt.id = :id", Patient.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Patient getPatientByPhoneNumber(String phoneNumber) {
        return session.createQuery("SELECT pt FROM Patient pt WHERE pt.phoneNumber = :phoneNumber", Patient.class)
                .setParameter("phoneNumber", phoneNumber)
                .uniqueResult();
    }

    @Override
    public List<Patient> getAllMedicalWorkersPatients(MedicalWorker medicalWorker) {
        return session.createQuery("SELECT pt FROM Patient pt WHERE pt.medicalWorker.id = :workerId", Patient.class)
                .setParameter("workerId", medicalWorker.getId())
                .list();
    }

    @Override
    public void updatePatient(Patient patient) {
        session.update(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        session.createQuery("DELETE FROM Patient pt WHERE pt.id = :id AND pt.phoneNumber = :phoneNumber " +
                "AND pt.firstName = :firstName AND pt.lastName = :lastName")
                .setParameter("id", patient.getId())
                .setParameter("phoneNumber", patient.getPhoneNumber())
                .setParameter("firstName", patient.getFirstName())
                .setParameter("lastName", patient.getLastName())
                .executeUpdate();
    }
}
