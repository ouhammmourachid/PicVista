package com.picvista.comment.Repository;

import com.picvista.comment.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

    public Iterable<Comment> findByCommentWriterId(Long CommentWriterId);
    public Iterable<Comment> findByImageId(Long ImageId);

    public Long countAllByImageId(Long ImageId);


}
