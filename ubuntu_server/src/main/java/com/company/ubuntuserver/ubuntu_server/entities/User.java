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
    @Column(name = "user_name", length = 25)
    @NotNull @NotBlank
    private String userName;

    @Getter @Setter
    @Column(name = "user_lastnames", length = 25)
    @NotNull @NotBlank
    private String userLastName;

    @JsonFormat(pattern = "dd/MM/yy")
    @Getter @Setter
    @Column(name = "user_created")
    private Date userCreatedAt;

    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yy")
    //@NotNull @NotBlank
    @Column(name = "user_birth")
    private Date userBirth;

    @Getter @Setter
    @Column(name = "user_gender", length = 10)
    @NotNull @NotBlank
    private String gender;

    @Getter @Setter
    @Column(name = "user_phone_number", length = 25)
    @NotNull @NotBlank
    private String phoneNumber;

    @Getter @Setter
    @Column(name = "user_status", length = 10)
    @NotNull @NotBlank
    private String status;

    @Getter @Setter
    @Column(name = "user_image", length = 500)
    @NotNull @NotBlank
    private String imageUrl;

    @Getter @Setter
    @Column(name = "user_email", length = 30)
    @NotNull @NotBlank
    private String email;

    @Getter @Setter
    @Column(name = "user_password", length = 120)
    @NotNull @NotBlank
    private String password;

    @PrePersist
    void generateDate(){
        this.userCreatedAt = new Date();
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_relations", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
    @Getter @Setter
    private List<User> users;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<Post> posts;

}
