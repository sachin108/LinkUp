package com.linkup.repository;

import com.linkup.model.Post;
import com.linkup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
    List<Post> findByUserOrderByTimestampDesc(User user);
    
    @Query("SELECT COUNT(p) FROM Post p JOIN p.likedBy u WHERE p = :post")
    Long countByPost(@Param("post") Post post);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Post p JOIN p.likedBy u WHERE p = :post AND u = :user")
    boolean existsByPostAndUser(@Param("post") Post post, @Param("user") User user);

}
