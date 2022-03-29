package com.example.bloggerms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.bloggerms.constants.BloggerType;
import com.example.bloggerms.dto.BloggerDetails;
import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.InvalidBloggerException;

@Component
public class BloggerUtil {

    public BloggerDetails toBloggerDetails(Blogger blogger){
        BloggerType bloggerType = blogger.getBloggerType();
        String bloggerTypeText = bloggerType.toString();
        BloggerDetails desired = new BloggerDetails(blogger.getId(),blogger.getFirstName(), blogger.getLastName(), bloggerTypeText);
        return desired;
    }

    public List<BloggerDetails> toListBloggerDetails(Collection<Blogger>Bloggers){
        List<BloggerDetails> desired = new ArrayList<>();
        for (Blogger blogger : Bloggers){
        	BloggerDetails response = toBloggerDetails(blogger);
            desired.add(response);
        }
        return desired;
    }

    public BloggerType toEnum(String BloggerText){
        BloggerType values[] = BloggerType.values();
        for (BloggerType iterated : values){
            String iteratedText = iterated.toString();
            if(iteratedText.equalsIgnoreCase(BloggerText))return iterated;
        }
        throw new InvalidBloggerException("invalid Blogger");
    }

}
