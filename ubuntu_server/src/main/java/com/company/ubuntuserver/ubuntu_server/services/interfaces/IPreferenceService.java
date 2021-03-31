package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.Preference;

public interface IPreferenceService {

    Preference createPreference(Integer userId,Preference preference);
    Preference updatePreference(Integer userId,Preference preference);
}
