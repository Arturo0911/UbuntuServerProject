package com.company.ubuntuserver.ubuntu_server.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_title")
    @Getter @Setter
    @NotNull
    private String postTitle;

    @Column(name = "post_content")
    @Getter @Setter
    @NotNull
    private String postContent;

    @Column(name = "post_date")
    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yy")
    private Date postDate;

    @Column(name = "post_modify")
    @Getter @Setter
    @JsonFormat(pattern="dd/MM/yy")
    private Date postModify;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @PrePersist
    void generateDate(){
        this.postDate = new Date();
    }

    /**
     * Management the like per user.
     */
    @OneToMany
    @Getter @Setter
    private List<User> userLikes;


}