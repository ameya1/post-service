package com.dao;

import com.model.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Repository
public interface ProfileDao {
    List<Profile> getProfiles();
    Profile getProfile(Long id);
    Profile addProfile(Profile profile);
    Profile updateProfile(Profile profile);
    Profile deleteProfile(Long id);
}
