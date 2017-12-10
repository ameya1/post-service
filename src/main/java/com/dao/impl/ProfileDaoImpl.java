package com.dao.impl;

import com.dao.ProfileDao;
import com.model.Contact;
import com.model.Post;
import com.model.PostDetails;
import com.model.Profile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProfileDaoImpl extends AbstractDaoImpl<Profile> implements ProfileDao{

    public ProfileDaoImpl(){

    }

    @PostConstruct
    public void inflateData(){

        /*Profile profile1 = new Profile("jondoe", "Jon", "Doe");
        Profile profile2 = new Profile("joanadale", "Joana", "Dale");
        Profile profile3 = new Profile("janeross", "Jane", "Ross");

        Contact contact1 = new Contact("jondoe@gmail.com", "8457541214", profile1);
        Contact contact2 = new Contact("jon@yahoo.com", "5214632598", profile1);
        Contact contact3 = new Contact("joanadale@gmail.com", "7854965812", profile2);
        Contact contact4 = new Contact("joan@yahoo.com", "5246352412", profile2);
        Contact contact5 = new Contact("janeross@gmail.com", "9652387412", profile3);

        profile1.getContacts().add(contact1);
        profile1.getContacts().add(contact2);
        profile2.getContacts().add(contact3);
        profile2.getContacts().add(contact4);
        profile3.getContacts().add(contact5);

        Post post = new Post("Good Morning");
        Post post2 = new Post("Java Concurrency");
        Post post3 = new Post("C++ Concurrency");

        PostDetails postDetails = new PostDetails("joan", post, "This is the hello message");
        PostDetails postDetails2 = new PostDetails("Rob", post2, "Java has lot of concurrency");
        PostDetails postDetails3 = new PostDetails("joan", post3, "C++ has better concurrency");

        post.setPostDetails(postDetails);
        post2.setPostDetails(postDetails2);
        post3.setPostDetails(postDetails3);

        profile1.getPosts().add(post);
        profile2.getPosts().add(post2);
        profile3.getPosts().add(post3);

        this.persist(profile1);
        this.persist(profile2);
        this.persist(profile3);*/

    }


    @Override
    public List<Profile> getProfiles() {
        List<Profile> list = this.getAll();
        return list;
    }



    public Profile getProfile(Long id){
        Session session = getSession();
        Query query = session.createQuery("from " + this.getClassName() + " where id = " + id);
        Profile profile = (Profile)query.uniqueResult();
        return profile;
    }

    @Override
    public Profile addProfile(Profile profile) {
        Session session = this.getSession();
        session.save(profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Session session = this.getSession();
        Query query = session.createQuery("from " + this.getClassName() + " where id = " + profile.getId());
        Profile p = (Profile) query.uniqueResult();
        p.setContacts(profile.getContacts());
        p.setFirstname(profile.getFirstname());
        p.setJoinDate(profile.getJoinDate());
        p.setLastname(profile.getLastname());
        p.setUsername(p.getUsername());
        session.saveOrUpdate(p);
        session.flush();
        return profile;
    }

    @Override
    public Profile deleteProfile(Long id) {
        Session session = this.getSession();
        Query query = session.createQuery("from " + this.getClassName() + " where id = " + id);
        Profile profile = (Profile)query.uniqueResult();
        session.delete(profile);
        session.flush();
        return profile;
    }


    @Override
    protected String getClassName() {
        return Profile.class.getSimpleName();
    }
}
