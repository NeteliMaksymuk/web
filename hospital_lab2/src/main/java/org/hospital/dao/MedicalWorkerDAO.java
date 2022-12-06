package org.hospital.dao;

import org.hospital.entity.MedicalWorker;

import java.util.List;

public interface MedicalWorkerDAO {
    void addNewMedicalWorker(MedicalWorker medicalWorker);
    MedicalWorker getMedicalWorkerById(int id);
    MedicalWorker getMedicalWorkerByEmail(String email);
    List<MedicalWorker> getAll();
    void updateMedicalWorker(MedicalWorker medicalWorker);
    void deleteMedicalWorker(MedicalWorker medicalWorker);
}
