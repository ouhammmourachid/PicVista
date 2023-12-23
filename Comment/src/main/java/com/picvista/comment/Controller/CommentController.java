package com.picvista.comment.Controller;


import com.picvista.comment.Model.Comment;
import com.picvista.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/Comment/{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") Long id){
      Optional<Comment> comment=commentService.getCommentById(id);
      return comment;

    }

    @GetMapping("/Comment/All")
    public Iterable<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @PostMapping("/Comment/save")
    public ResponseEntity<String> saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
        return ResponseEntity.ok("Created successfully");

    }

    @DeleteMapping("/Comment/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id){
        commentService.DeleteComment(id);
        return ResponseEntity.ok("Removed successfully");
    }

    @GetMapping("/Comment/AllByWriterId/{id}")
    public Iterable<Comment> getAllCommentsByWriterId(@PathVariable("id") Long id){
        return commentService.getAllCommentsByWriterId(id);
    }

    @GetMapping("/Comment/AllByImageId/{id}")
    public Iterable<Comment> getAllCommentsByImageId(@PathVariable("id") Long id){
        return commentService.getAllCommentsByImageId(id);
    }

    @GetMapping("/Comment/CountByImageId/{id}")
    public Long CountCommentsByImageId(@PathVariable("id") Long id){
        return commentService.countCommentsByImageId(id);
    }


}
