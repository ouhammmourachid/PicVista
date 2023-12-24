package com.picvista.clientui.controller;

import com.picvista.clientui.beans.*;
import com.picvista.clientui.proxies.MicroserviceCommentProxy;
import com.picvista.clientui.proxies.MicroserviceImageProxy;
import com.picvista.clientui.proxies.MicroserviceLikeProxy;
import com.picvista.clientui.proxies.MicroserviceUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {


    @Autowired
    MicroserviceCommentProxy microcerviceCommentProxy;

    @Autowired
    MicroserviceImageProxy microserviceImageProxy;

    @Autowired
    MicroserviceUserProxy microserviceUserProxy;

    @Autowired
    MicroserviceLikeProxy microserviceLikeProxy;



    @RequestMapping("/picvista/All")
    public List<PostBean> GetAllPosts(){
        List<PostBean> posts =new ArrayList<>();
        ResponseEntity<List<ImageBean>> ResponseImages=microserviceImageProxy.getAllImages();
        List<ImageBean> images=ResponseImages.getBody();
        for (ImageBean image:images) {
            PostBean postBean =new PostBean();
            int userId=(int)image.getUserId();
            Long imageId= image.getId();
            int imageId2= Math.toIntExact(imageId);
            String path=image.getPath();

            ResponseEntity<UserBean> user=microserviceUserProxy.getUserById(userId);
            String userName=user.getBody().getName();

            Long likes=microserviceLikeProxy.nombreDesLikes(imageId2).getBody();
            Iterable<CommentBean> commentsList=microcerviceCommentProxy.getAllCommentsByImageId(imageId);
            List<String> comments=new ArrayList<>();
            for (CommentBean comment: commentsList) {
                String commentText=comment.getCommentText();
                comments.add(commentText);
            }
            postBean.setPath(path);
            postBean.setUserName(userName);
            postBean.setComments(comments);
            postBean.setLikes(likes);

            posts.add(postBean);
        }
        return posts;
    }

    @RequestMapping("/picvista/createAccount")
    public String createAccount(@RequestBody UserBean userBean){

        microserviceUserProxy.createUser(userBean);
        return "Account created successfully !!!";

    }

    @RequestMapping("/Picvista/addComment")
    public String addComment(@RequestBody CommentBean comment){
        microcerviceCommentProxy.saveComment(comment);
        return "Comment added successfully !!!";
    }

    @RequestMapping("/Picvista/addLike")
    public String addLike(@RequestBody LikeBean like){
        microserviceLikeProxy.ajouterLike(like.getUserId(), like.getImageId());
        return "Like added successfully !!!";
    }

    /*@RequestMapping("/Picvista/addPost")
    public String addPost(@RequestParam Long userId,
                          @RequestParam MultipartFile image){
        microserviceImageProxy.uploadImage(userId,image);
        return "Post added successfully !!!";
    }*/





}
