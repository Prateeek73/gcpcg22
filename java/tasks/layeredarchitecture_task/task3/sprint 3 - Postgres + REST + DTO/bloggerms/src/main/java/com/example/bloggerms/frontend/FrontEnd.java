package com.example.bloggerms.frontend;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bloggerms.constants.BloggerType;
import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.IdNotFoundException;
import com.example.bloggerms.exceptions.InvalidIdException;
import com.example.bloggerms.service.IBloggerService;

@Component
public class FrontEnd {

	@Autowired
	private IBloggerService service;

	public void runUI() {
		try {
			// adding bloggers
			System.out.println("***Adding bloggers***");
			service.register("Toby", "Maggie", BloggerType.ARTICLE);
			service.register("Bandrew", "Garfield", BloggerType.PHOTOGRAPHER);
			service.register("Bomb", "Holland", BloggerType.SOCIAL);

			// finding bloggers
			System.out.println("***Displaying bloggers***");
			Blogger blogger = service.findById(2);
			System.out.println(blogger.toString());

			// changing name of blogger
			System.out.println("Before : " + blogger.toString());
			service.changeBloggerName(2, "Bruce", "Bane");
			System.out.println("After : " + blogger.toString());

		} catch (IdNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (InvalidIdException ex) {
			System.err.print(ex.getMessage());
		} catch (InvalidNameException ex) {
			System.err.print(ex.getMessage());
		} catch (Exception ex) {
			System.err.print(ex.getMessage());
		}
	}
}
