package com.mayank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.dto.BlogDTO;
import com.mayank.entity.Blog;
import com.mayank.exception.BlogNotFoundException;
import com.mayank.repository.BlogRepository;

import jakarta.validation.Valid;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	public BlogRepository blogRepo;
	
	@Autowired
	public ModelMapper modelmapper;

	@Override
	public BlogDTO postBlog(@Valid BlogDTO blogdto) 
	{
		// TODO Auto-generated method stub
		Blog blog = modelmapper.map(blogdto, Blog.class);
		blog = blogRepo.save(blog);
		return modelmapper.map(blog, BlogDTO.class);
	}

	@Override
	public BlogDTO getBlog(Long id) 
	{
		// TODO Auto-generated method stub
		Blog blog = blogRepo.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog with ID " + id + " not found."));
		
		return modelmapper.map(blog, BlogDTO.class);
	}

	@Override
	public BlogDTO updateBlog(Long id, @Valid BlogDTO blogdto) 
	{
		// TODO Auto-generated method stub
		Blog existblog = blogRepo.findById(id)
				.orElseThrow(() -> new BlogNotFoundException("Blog with ID " + id + " not found."));
		
		existblog.setTitle(blogdto.getTitle());
		existblog.setContent(blogdto.getContent());
		
		Blog updatedblog = blogRepo.save(existblog);
		return modelmapper.map(updatedblog, BlogDTO.class);
	}

	@Override
	public Boolean deleteBlog(Long id) 
	{
		// TODO Auto-generated method stub
		if (!blogRepo.existsById(id)) 
		{
			throw new BlogNotFoundException("Blog with ID " + id + " not found.");
		}
		blogRepo.deleteById(id);
		return true;
	}
	
	//Optional Method
	@Override
	public List<BlogDTO> getAllBlogs() 
	{
		// TODO Auto-generated method stub
        List<Blog> blogs = blogRepo.findAll();
        return blogs.stream()
                .map(blog -> modelmapper.map(blog, BlogDTO.class))
                .collect(Collectors.toList());
	}
}
