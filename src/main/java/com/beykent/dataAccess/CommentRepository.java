package com.beykent.dataAccess;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
	List<Comment> findAllByPostId(UUID postId);

	List<Comment> findAllByUserId(UUID userId);
}
