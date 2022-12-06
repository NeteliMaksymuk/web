package org.hospital.dao;

import org.hospital.entity.Admin;

public interface AdminDAO {
    void createAdmin(Admin admin);
    Admin getById(int id);
    Admin getByEmail(String email);
    void updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
}
