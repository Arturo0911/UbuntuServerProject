package com.company.ubuntuserver.ubuntu_server.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
@AllArgsConstructor @NoArgsConstructor
public class Preference {

    @Id
    @Column(name = "preference_id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer preferenceId;


    @Getter @Setter
    @Column(name = "currently_status", length = 15)
    private String currentlyStatus;

    @Getter @Setter
    @Column(name = "code_preferences", length = 200)
    private String codePreferences;

    @Getter @Setter
    @Column(name = "ranking")
    private Integer ranking;

    @Getter @Setter
    @Column(name = "experience", length = 2000)
    private String experience;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @Getter @Setter
    private User user;


}
