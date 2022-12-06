package org.hospital.dao.implementations;


import org.hibernate.Session;
import org.hospital.dao.TreatingCardDAO;
import org.hospital.entity.Patient;
import org.hospital.entity.TreatingCard;

import java.util.List;

public class TreatingCardDAOImpl implements TreatingCardDAO {

    private final Session session;

    public TreatingCardDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addNewTreatingCard(TreatingCard treatingCard) {
        session.save(treatingCard);
    }

    @Override
    public TreatingCard getTreatingCardById(int id) {
        return session.createQuery("SELECT tc FROM TreatingCard tc WHERE tc.id = :id", TreatingCard.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<TreatingCard> getAllUsersTreatingCard(Patient patient) {
        return session.createQuery("SELECT tc FROM TreatingCard tc WHERE tc.patient.id = :patientsId", TreatingCard.class)
                .setParameter("patientsId", patient.getId())
                .list();
    }

    @Override
    public void updateTreatingCard(TreatingCard treatingCard) {
        session.save(treatingCard);
    }

    @Override
    public void deleteTreatingCard(TreatingCard treatingCard) {
        session.createQuery("DELETE FROM TreatingCard tc WHERE tc.id = :id AND tc.description = :description")
                .setParameter("id", treatingCard.getId())
                .setParameter("description", treatingCard.getDescription())
                .executeUpdate();
    }
}
