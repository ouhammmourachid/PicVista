package com.picvista.like.repository;

import com.picvista.like.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Long countByImageId(int imageId);

    Long countByUserId(int userId);

    Optional<Like> findByUserIdAndImageId(int userId, int imageId);

}
