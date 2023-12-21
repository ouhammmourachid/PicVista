package com.picvista.like.service;

import com.picvista.like.model.Like;
import com.picvista.like.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Long getNombreDesLikesByImageId(int imageId) {
        return likeRepository.countByImageId(imageId);
    }

    public Long getNombreDesLikesByUserId(int userId) {
        return likeRepository.countByUserId(userId);
    }

    public Optional<Date> getDateDuLike(int userId, int imageId) {
        return likeRepository.findByUserIdAndImageId(userId, imageId).map(Like::getDate);
    }

    public boolean ajouterLike(int userId, int imageId) {

        Like like = new Like();
        like.setUserId(userId);
        like.setImageId(imageId);
        like.setDate(new Date());

        likeRepository.save(like);
        return true;
    }

    public boolean supprimerLike(int userId, int imageId) {

        Optional<Like> likeOptional = likeRepository.findByUserIdAndImageId(userId, imageId);

        if (likeOptional.isPresent()) {
            Like like = likeOptional.get();
            likeRepository.delete(like);
            return true;
        } else {
            return false;
        }
    }
}
