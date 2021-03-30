package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.Preference;

public interface IPreferenceService {

    Preference createPreference(Preference preference);
    Preference updatePreference(Preference preference);
}
