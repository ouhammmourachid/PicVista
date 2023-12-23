package com.picvista.comment.Service;

import com.picvista.comment.CommentApplication;
import com.picvista.comment.Model.Comment;
import com.picvista.comment.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    public Optional<Comment> getCommentById(Long id){
        return commentRepository.findById(id);
    }

    public Iterable<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }
    public List<Comment> getAllCommentsByWriterId(Long commentWriterId){
        return (List<Comment>)commentRepository.findByCommentWriterId(commentWriterId);
    }

    public List<Comment> getAllCommentsByImageId(Long ImageId){
        return (List<Comment>)commentRepository.findByImageId(ImageId);
    }

    public void DeleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    public Long countCommentsByImageId(Long ImageId){
        return commentRepository.countAllByImageId(ImageId);
    }

}
