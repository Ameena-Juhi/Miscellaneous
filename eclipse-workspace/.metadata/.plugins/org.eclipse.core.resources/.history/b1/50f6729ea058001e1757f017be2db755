package com.prodapt.learningspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prodapt.learningspring.DTO.LikesCountDTO;
import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;
import com.prodapt.learningspring.repository.LikeCRUDRepository;
import com.prodapt.learningspring.repository.LikeCountRepository;
import com.prodapt.learningspring.repository.PostRepository;
import com.prodapt.learningspring.service.CustomUserDetailsService;
import com.prodapt.learningspring.service.DomainUserService;
import com.prodapt.learningspring.service.LikeCountService;
import com.prodapt.learningspring.service.PostService;

@Controller
public class PostsListController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LikeCountRepository likeCountRepository;
	
	@Autowired
	private CustomUserDetailsService userDetails;
	
	@Autowired
	private DomainUserService domainUserService;
	
	@Autowired
	private LikeCountService likeCountService;
	
	@Autowired
	private PostService postService;
	
	
	@RequestMapping("/list")
	public String getallPosts(Model model, @AuthenticationPrincipal UserDetails userDetails,@RequestParam(defaultValue = "1") int page) {
		List<Post> postList =  (List<Post>) postRepository.findAll();
		model.addAttribute("posts", postList);
		model.addAttribute("userName", userDetails.getUsername());
		LikesCountDTO likesCountDTO = new LikesCountDTO();
		List<LikesCountDTO> numlikes = likeCountService.getLikesCounts(postList);
		model.addAttribute("likeCount",numlikes );
//		model.addAttribute("likeCount",likeCountRepository.countByPostId()));
		 int postsPerPage = 2*(page); // Adjust as needed
//	        int offset = (page - 1) * postsPerPage;
		 int offset = 0;
	        List<Post> posts = postService.getPosts(offset, postsPerPage);

	        model.addAttribute("posts", posts);
	        model.addAttribute("nextPage", page + 1);
		return("forum/PostsList");
	}
	
}
