package com.example.bloggerms.controller;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bloggerms.dto.RegisterBloggerRequest;
import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.constants.BloggerType;
import com.example.bloggerms.dto.BloggerDetails;
import com.example.bloggerms.exceptions.IdNotFoundException;
import com.example.bloggerms.exceptions.InvalidIdException;
import com.example.bloggerms.service.IBloggerService;
import com.example.bloggerms.util.BloggerUtil;

@RequestMapping("/bloggers")
@RestController
public class BloggerController {
	@Autowired
	private IBloggerService service;
	@Autowired
	private BloggerUtil bloggerutil;
	/*
	 * effective url : /bloggers/add
	 */
	@RequestMapping(path = "/add", method=RequestMethod.POST)
	@PostMapping(value = "/add")
	public BloggerDetails add(@RequestBody RegisterBloggerRequest requested_blogger) throws InvalidNameException {
		String bloggerTypeText = requested_blogger.getBloggerType();
		BloggerType bloggerType = bloggerutil.toEnum(bloggerTypeText);
		Blogger blogger = service.register(requested_blogger.getFirstName(), requested_blogger.getLastName(), bloggerType);
		BloggerDetails response = bloggerutil.toBloggerDetails(blogger);
		return response;
	}

	/*
	 * effective url : /bloggers/find/byid/{id}
	 */
	@RequestMapping(path = "/find/byid/{id}", method = RequestMethod.GET)
	@GetMapping(value = "/find/byid/{id}")
	public Blogger findById(@PathVariable long id) throws IdNotFoundException, InvalidIdException {
		Blogger blogger = service.findById(id);
		return blogger;
	}

	/*
	 * effective url : /bloggers/update
	 */
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	@PutMapping(value = "/update")
	public Blogger changBloggerName(@RequestBody Blogger requested_blogger)
			throws InvalidNameException, IdNotFoundException, InvalidIdException {
		Blogger blogger = service.changeBloggerName(requested_blogger.getId(), requested_blogger.getFirstName(),
				requested_blogger.getLastName());
		return blogger;
	}

}
