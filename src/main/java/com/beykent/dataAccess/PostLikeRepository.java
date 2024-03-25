package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike, UUID> {

}
