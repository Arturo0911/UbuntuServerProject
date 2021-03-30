package com.company.ubuntuserver.ubuntu_server.daos;

import com.company.ubuntuserver.ubuntu_server.entities.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreference extends JpaRepository<Preference,Integer> {
}
