package com.company.ubuntuserver.ubuntu_server.services;

import com.company.ubuntuserver.ubuntu_server.daos.IPreference;
import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.Preference;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.IPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PreferenceServiceImplementation implements IPreferenceService {

    @Autowired
    private IPreference iPreference;

    @Autowired
    private IUser iUser;

    @Override
    public Preference createPreference(Integer userId,Preference preference) {
        try {
            Optional<User> user = iUser.findById(userId);
            if (user.get().getPreference() == null){
                user.get().setPreference(preference);
                iPreference.save(preference);
                return preference;
            }else{
                return preference;
            }

        }catch (Exception e ){
            return null;
        }
    }

    @Override
    public Preference updatePreference(Integer userId,Preference preference) {
        try {
            Optional<User> user = iUser.findById(userId);
            user.get().setPreference(preference);
            iPreference.save(preference);
            return preference;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
