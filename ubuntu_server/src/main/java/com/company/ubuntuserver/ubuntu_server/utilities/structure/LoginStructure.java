package com.company.ubuntuserver.ubuntu_server.utilities.structure;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor @NoArgsConstructor
public class LoginStructure {

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String jwt;

}
