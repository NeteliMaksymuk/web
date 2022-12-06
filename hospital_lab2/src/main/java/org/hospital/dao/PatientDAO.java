package org.hospital.dao;

import org.hospital.entity.MedicalWorker;
import org.hospital.entity.Patient;

import java.util.List;

public interface PatientDAO {
    void addNewPatient(Patient patient);
    Patient getPatientById(int id);
    Patient getPatientByPhoneNumber(String phoneNumber);
    List<Patient> getAllMedicalWorkersPatients(MedicalWorker medicalWorker);
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
