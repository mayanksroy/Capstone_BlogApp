package com.mayank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.dto.CommentDTO;
import com.mayank.entity.Comment;
import com.mayank.exception.BlogNotFoundException;
import com.mayank.repository.BlogRepository;
import com.mayank.repository.CommentRepository;

import jakarta.validation.Valid;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	public BlogRepository blogRepo;

	@Autowired
	public CommentRepository commentRepo;

	@Autowired
	public ModelMapper modelmapper;

	@Override
	public CommentDTO postComment(@Valid CommentDTO commentdto) 
	{
		if (!blogRepo.existsById(commentdto.getBlogid())) 
		{
			throw new BlogNotFoundException("Blog not found for ID: " + commentdto.getBlogid());
		}

		Comment comment = modelmapper.map(commentdto, Comment.class);
		comment = commentRepo.save(comment);
		return modelmapper.map(comment, CommentDTO.class);

	}
	
	//Optional Method
	@Override
	public List<CommentDTO> getAllComments() 
	{
		// TODO Auto-generated method stub
		List<Comment> comments = commentRepo.findAll();
        return comments.stream()
                .map(comment -> modelmapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
	}

}
