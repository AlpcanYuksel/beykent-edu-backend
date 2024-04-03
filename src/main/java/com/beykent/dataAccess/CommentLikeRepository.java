package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.CommentLike;

public interface CommentLikeRepository extends JpaRepository<CommentLike, UUID> {

}
