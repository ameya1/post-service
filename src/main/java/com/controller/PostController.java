package com.controller;

import com.model.Post;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profiles/{profileId}")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value="/posts", method= RequestMethod.GET)
    public List<Post> getPostsForProfile(@PathVariable("profileId") Long profileId){
        return postService.getPosts(profileId);
    }

}
