package org.hospital.dao;

import org.hospital.entity.Patient;
import org.hospital.entity.TreatingCard;

import java.util.List;

public interface TreatingCardDAO {
    void addNewTreatingCard(TreatingCard treatingCard);
    TreatingCard getTreatingCardById(int id);
    List<TreatingCard> getAllUsersTreatingCard(Patient patient);
    void updateTreatingCard(TreatingCard treatingCard);
    void deleteTreatingCard(TreatingCard treatingCard);
}
