package com.prodapt.learningspring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.prodapt.learningspring.entity.Comment;

public interface CommentCountRepository extends Repository<Comment, Integer> {
	
	  @Query(value = "select count(*) from `comment` where post_id = ?1", nativeQuery=true)
	  Integer countByPostIdnative(Integer postId);

}
