package com.dao;

import com.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {
    List<Post> getPosts(Long id);
    //Post getPost(Long profileId, Long postId);
}
