package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.entities.Preference;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.IPreferenceService;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preference")
public class PreferenceController {

    @Autowired
    private IPreferenceService iPreferenceService;

    @PostMapping("/newPreference/{userId}")
    public ResponseEntity<JsonResponseBody>createPreference(@PathVariable("userId") Integer userId,@RequestBody Preference preference) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,
                            iPreferenceService.createPreference(userId,preference)));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage,e.toString()));
        }
    }

    @PutMapping("/updatePreference/{userId}")
    public ResponseEntity<JsonResponseBody>updatePreferences(@PathVariable("userId")Integer userId, @RequestBody Preference preference) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,
                            iPreferenceService.updatePreference(userId,preference)));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage,e.toString()));
        }
    }
}
