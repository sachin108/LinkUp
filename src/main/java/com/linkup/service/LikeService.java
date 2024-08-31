package com.linkup.service;

import com.linkup.model.Post;
import com.linkup.model.User;
import com.linkup.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private PostRepository postRepository;

    public Long countLikesOnPost(Post post) {
        return postRepository.countByPost(post);
    }

    public boolean hasUserLikedPost(Post post, User user) {
        return postRepository.existsByPostAndUser(post, user);
    }

    // Add additional methods as needed, e.g., for adding or removing likes
}
