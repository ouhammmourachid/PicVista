package com.picvista.like.web;


import com.picvista.like.model.Like;
import com.picvista.like.repository.LikeRepository;
import com.picvista.like.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping(value = "/like/{imageId}")
    public ResponseEntity<Long> nombreDesLikes(@PathVariable int imageId){

        Long count = likeService.getNombreDesLikesByImageId(imageId);

        return ResponseEntity.ok(count);

    }
    @GetMapping(value = "/like/{userId}")
    public ResponseEntity<Long> nombreDesLikesFaitParUser(@PathVariable int userId){

        Long count = likeService.getNombreDesLikesByUserId(userId);

        return ResponseEntity.ok(count);

    }
    @GetMapping(value = "/like/{userId}/{imageId}")
    public ResponseEntity<Date> getDateDuLike(@PathVariable int userId, @PathVariable int imageId) {
        // Utiliser le LikeRepository pour obtenir la date du like pour l'userId et l'imageId spécifiés
        Optional<Date> date = likeService.getDateDuLike(userId, imageId);

        return date.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/like/add")
    public ResponseEntity<String> ajouterLike(@RequestParam int userId, @RequestParam int imageId) {
        boolean ajoutReussi = likeService.ajouterLike(userId, imageId);

        if (ajoutReussi) {
            return ResponseEntity.ok("Like ajouté avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Échec de l'ajout du like. Assurez-vous que l'utilisateur et l'image existent.");
        }
    }

    @DeleteMapping("/like/remove")
    public ResponseEntity<String> supprimerLike(@RequestParam int userId, @RequestParam int imageId) {
        boolean suppressionReussie = likeService.supprimerLike(userId, imageId);

        if (suppressionReussie) {
            return ResponseEntity.ok("Like supprimé avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Échec de la suppression du like. Assurez-vous que le like existe et que vous avez les droits nécessaires.");
        }
    }

}
