package org.hospital.dao.implementations;


import org.hibernate.Session;
import org.hospital.dao.AdminDAO;
import org.hospital.entity.Admin;

public class AdminDAOImpl implements AdminDAO {

    private final Session session;

    public AdminDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void createAdmin(Admin admin) {
        session.save(admin);
    }

    @Override
    public Admin getById(int id) {
        return session.createQuery("SELECT a FROM Admin a WHERE a.id = :id", Admin.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Admin getByEmail(String email) {
        return session.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public void updateAdmin(Admin admin) {
        session.save(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        session.createQuery("DELETE Admin a WHERE a.id = :id AND a.email = :email " +
                "AND a.firstName = :firstName AND a.lastName = :lastName")
                .setParameter("id", admin.getId())
                .setParameter("email", admin.getEmail())
                .setParameter("firstName", admin.getFirstName())
                .setParameter("lastName", admin.getLastName())
                .executeUpdate();
    }
}
