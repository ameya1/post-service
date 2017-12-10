package com.dao.impl;

import com.dao.PostDao;
import com.model.Post;
import com.model.PostDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class PostDaoImpl extends AbstractDaoImpl<Post> implements PostDao{


    @PostConstruct
    private void inflateDB(){
        //Session session = getSession();
/*
        Post post = new Post("Good Morning");
        Post post2 = new Post("Java Concurrency");
        Post post3 = new Post("C++ Concurrency");

        PostDetails postDetails = new PostDetails("joan", post, "This is the hello message");
        PostDetails postDetails2 = new PostDetails("Rob", post2, "Java has lot of concurrency");
        PostDetails postDetails3 = new PostDetails("joan", post3, "C++ has better concurrency");

        post.setPostDetails(postDetails);
        post2.setPostDetails(postDetails2);
        post3.setPostDetails(postDetails3);

        this.persist(post);
        this.persist(post2);
        this.persist(post3);*/
        //session.flush();


    }

    @Override
    public List<Post> getPosts(Long id) {
        Session session = getSession();
        Query query = session.createQuery("from " + this.getClassName() + " where profile_id = " + id);
        List<Post> posts = query.list();
        return posts;
    }

    @Override
    protected String getClassName() {
        return Post.class.getSimpleName();
    }
}
