package com.service.impl;

import com.dao.ProfileDao;
import com.model.Profile;
import com.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    public List<Profile> getProfiles(){
        return profileDao.getProfiles();
    }

    public Profile getProfile(Long id){
        return profileDao.getProfile(id);
    }

    @Override
    public Profile addProfile(Profile profile) {
        return profileDao.addProfile(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileDao.updateProfile(profile);
    }

    @Override
    public Profile deleteProfile(Long id) {
        return profileDao.deleteProfile(id);
    }

}
