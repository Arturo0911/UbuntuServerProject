package com.company.ubuntuserver.ubuntu_server.daos;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Integer> {
}
