package org.hospital.worker_builder;

import org.hospital.entity.Admin;
import org.hospital.entity.MedicalWorker;
import org.hospital.entity.Role;

public class MedicalWorkerBuilder {
    private final MedicalWorker medicalWorker = new MedicalWorker();

    public MedicalWorkerBuilder(int id, String firstName, String lastName, String email,
                                String password, Role role, Admin admin) {
        medicalWorker.setId(id);
        medicalWorker.setFirstName(firstName);
        medicalWorker.setLastName(lastName);
        medicalWorker.setEmail(email);
        medicalWorker.setPassword(password);
        medicalWorker.setRole(role);
        medicalWorker.setAdmin(admin);
    }

    public MedicalWorkerBuilder setPhoneNumber(String phoneNumber) {
        medicalWorker.setPhoneNumber(phoneNumber);
        return this;
    }

    public MedicalWorkerBuilder setAge(int age) {
        medicalWorker.setAge(age);
        return this;
    }

    public MedicalWorker buildMedicalWorker() {
        return medicalWorker;
    }
}
