package com.company.ubuntuserver.ubuntu_server.services;

import com.company.ubuntuserver.ubuntu_server.daos.IPreference;
import com.company.ubuntuserver.ubuntu_server.entities.Preference;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.IPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PreferenceServiceImplementation implements IPreferenceService {

    @Autowired
    private IPreference iPreference;

    @Override
    public Preference createPreference(Preference preference) {
        try {
            return iPreference.save(preference);
        }catch (Exception e ){
            return null;
        }
    }

    @Override
    public Preference updatePreference(Preference preference) {
        try {
            return iPreference.save(preference);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
