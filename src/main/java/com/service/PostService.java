package com.service;

import com.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getPosts(Long id);
    Post getPost(Long id);
}
