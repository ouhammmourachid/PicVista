package com.picvista.clientui.proxies;


import com.picvista.clientui.beans.CommentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name ="microservice-comments",url = "localhost:5013")
public interface MicroserviceCommentProxy {
    @GetMapping("/Comment/{id}")
    public Optional<CommentBean> getCommentById(@PathVariable("id") Long id);

    @GetMapping("/Comment/All")
    public Iterable<CommentBean> getAllComments();

    @PostMapping("/Comment/save")
    public ResponseEntity<String> saveComment(CommentBean comment);

    @DeleteMapping("/Comment/delete/{id}")
    ResponseEntity<String> deleteComment(@PathVariable("id") Long id);

    @GetMapping("/Comment/AllByWriterId/{id}")
    Iterable<CommentBean> getAllCommentsByWriterId(@PathVariable("id") Long id);

    @GetMapping("/Comment/AllByImageId/{id}")
    Iterable<CommentBean> getAllCommentsByImageId(@PathVariable("id") Long id);

    @GetMapping("/Comment/CountByImageId/{id}")
    Long CountCommentsByImageId(@PathVariable("id") Long id);


}
