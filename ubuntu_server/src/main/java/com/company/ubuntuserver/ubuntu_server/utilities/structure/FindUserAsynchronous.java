package com.company.ubuntuserver.ubuntu_server.utilities.structure;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor @NoArgsConstructor
public class FindUserAsynchronous {

    @Getter @Setter
    private String userName;

    @Getter @Setter
    private String userLastName;
}
