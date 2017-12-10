package com.service.impl;

import com.dao.PostDao;
import com.model.Post;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public List<Post> getPosts(Long id) {
        return postDao.getPosts(id);
    }

    @Override
    public Post getPost(Long id) {
        return postDao.getPost(id);
    }
}
