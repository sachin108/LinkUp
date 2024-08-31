package com.linkup.service;

import com.linkup.model.Post;
import com.linkup.model.User;
import com.linkup.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUser(user);
    }

    public List<Post> getPostsByUserOrderedByTimestamp(User user) {
        return postRepository.findByUserOrderByTimestampDesc(user);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
