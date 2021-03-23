package com.company.ubuntuserver.ubuntu_server.daos;


import com.company.ubuntuserver.ubuntu_server.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPost extends JpaRepository<Post, Integer> {
}
