package com.service;

import com.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {
    List<Profile> getProfiles();
    Profile getProfile(Long id);
    Profile addProfile(Profile profile);
    Profile updateProfile(Profile profile);
    Profile deleteProfile(Long id);
}
