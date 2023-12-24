package com.picvista.clientui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@FeignClient(name ="microservice-like",url = "localhost:5014")
public interface MicroserviceLikeProxy {
    @GetMapping(value = "/likeImage/{imageId}")
    ResponseEntity<Long> nombreDesLikes(@PathVariable int imageId);
    @GetMapping(value = "/likeUser/{userId}")
    ResponseEntity<Long> nombreDesLikesFaitParUser(@PathVariable int userId);
    @GetMapping(value = "/like/{userId}/{imageId}")
    ResponseEntity<Date> getDateDuLike(@PathVariable int userId, @PathVariable int imageId);

    @PostMapping("/like/add")
    ResponseEntity<String> ajouterLike(@RequestParam int userId, @RequestParam int imageId);

    @DeleteMapping("/like/remove")
    public ResponseEntity<String> supprimerLike(@RequestParam int userId, @RequestParam int imageId);
}
