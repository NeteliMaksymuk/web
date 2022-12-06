package org.hospital.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_in_hospital_name")
    private StatusInHospital statusInHospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_admin_id")
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_worker_id")
    private MedicalWorker medicalWorker;

    @OneToMany(mappedBy = "patient")
    private List<TreatingCard> cards;

    public Patient() {}
    public Patient(int id, String firstName, String lastName, String phoneNumber, String password,
                   StatusInHospital statusInHospital, Admin admin, MedicalWorker medicalWorker) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.statusInHospital = statusInHospital;
        this.admin = admin;
        this.medicalWorker = medicalWorker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StatusInHospital getStatusInHospital() {
        return statusInHospital;
    }

    public void setStatusInHospital(StatusInHospital statusInHospital) {
        this.statusInHospital = statusInHospital;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public MedicalWorker getMedicalWorker() {
        return medicalWorker;
    }

    public void setMedicalWorker(MedicalWorker medicalWorker) {
        this.medicalWorker = medicalWorker;
    }

    public List<TreatingCard> getCards() {
        return cards;
    }

    public void setCards(List<TreatingCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", statusInHospital=" + statusInHospital +
                ", admin's id: " + admin.getId() +
                ", medicalWorker's id: " + medicalWorker.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(phoneNumber, patient.phoneNumber) && Objects.equals(password, patient.password) && statusInHospital == patient.statusInHospital && Objects.equals(admin, patient.admin) && Objects.equals(medicalWorker, patient.medicalWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, password, statusInHospital, admin, medicalWorker);
    }
}
