package com.controller;

import com.model.Profile;
import com.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Profile> getProfiles(){
        return profileService.getProfiles();
    }

    @RequestMapping(value="/profile/{id}", method=RequestMethod.GET)
    public Profile getProfile(@PathVariable("id") Long id){
        return profileService.getProfile(id);
    }

    @RequestMapping(value="/profile", method=RequestMethod.POST)
    public Profile addProfile(@RequestBody Profile profile){
        return profileService.addProfile(profile);
    }

    @RequestMapping(value="/profile", method=RequestMethod.PUT)
    public Profile updateProfile(@RequestBody Profile profile){
        return profileService.updateProfile(profile);
    }

    @RequestMapping(value="/profile/{id}", method=RequestMethod.DELETE)
    public Profile deleteProfile(@PathVariable("id") Long id){
        return profileService.deleteProfile(id);
    }
}
