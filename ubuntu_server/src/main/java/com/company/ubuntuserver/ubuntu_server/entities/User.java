package com.company.ubuntuserver.ubuntu_server.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Getter @Setter
    @Column(name = "user_name")
    @NotNull @NotBlank
    private String userName;

    @Getter @Setter
    @Column(name = "user_lastnames")
    @NotNull @NotBlank
    private String userLastName;

    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yy")
    @Column(name = "user_birth")
    private Date userBirth;

    @Getter @Setter
    @Column(name = "user_gender")
    @NotNull @NotBlank
    private String gender;

    @Getter @Setter
    @Column(name = "user_phone_number")
    @NotNull @NotBlank
    private String phoneNumber;

    @Getter @Setter
    @Column(name = "user_status")
    @NotNull @NotBlank
    private String status;

    @Getter @Setter
    @Column(name = "user_email")
    @NotNull @NotBlank
    private String email;

    @Getter @Setter
    @Column(name = "user_password")
    @NotNull @NotBlank
    private String password;

    @PrePersist
    void generateDate(){
        this.userBirth = new Date();
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_relations", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
    @Getter @Setter
    private List<User> users;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<Post> posts;

}
