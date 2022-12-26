package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.comment.domain.Comment;
import com.nhnacademy.jdbc.board.comment.service.CommentService;
import com.nhnacademy.jdbc.board.login.domain.User;
import com.nhnacademy.jdbc.board.login.service.UserLoginService;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final UserLoginService userService;
    private final CommentService commentService;

    public PostController(PostService postService, UserLoginService userService,
                          CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping
    public String viewPosts(HttpSession session,
                            ModelMap modelMap) {
        String userID = (String) session.getAttribute("loginID");
        List<Post> postList = postService.viewPosts();
        modelMap.put("postList", postList);

        if (userID.equals("admin")) {
            return "postList_admin";
        } else {
            return "postList_user";
        }
    }

    @GetMapping("/detailView/{postID}")
    public String detailView(@PathVariable("postID") Long postID,
                             ModelMap modelMap) {
        Post post = postService.findPost(postID);
        modelMap.put("post", post);

        List<Comment> commentList = commentService.viewCommentsByPostID(postID);
        modelMap.put("commentList", commentList);

        return "postDetailView";
    }

    @GetMapping("/writePost")
    public String writePost() {
        return "writePostForm";
    }

    @PostMapping("/writePost")
    public String createPost(HttpServletRequest request,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        HttpSession session = request.getSession();
        String loginID = (String) session.getAttribute("loginID");
        postService.createPost(title, content);

        return "redirect:/posts";
    }

}