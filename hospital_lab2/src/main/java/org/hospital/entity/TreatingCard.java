package org.hospital.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "treating_card")
public class TreatingCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    @Enumerated(EnumType.STRING)
    @Column(name = "healing_type_name")
    private HealingType healingType;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_name")
    private Status status;

    public TreatingCard() {}
    public TreatingCard(int id, String description, Patient patient, HealingType healingType, Status status) {
        this.id = id;
        this.description = description;
        this.patient = patient;
        this.healingType = healingType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealingType getHealingType() {
        return healingType;
    }

    public void setHealingType(HealingType healingType) {
        this.healingType = healingType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TreatingCard{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", patient's id: " + patient.getId() +
                ", healingType=" + healingType +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatingCard that = (TreatingCard) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(patient, that.patient) && healingType == that.healingType && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, patient, healingType, status);
    }
}
