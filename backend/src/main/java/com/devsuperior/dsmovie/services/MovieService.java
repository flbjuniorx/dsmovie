package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;


// Annotation to register the class as a system component (needed when the class is customized)
@Service

public class MovieService {
		
		@Autowired
		private MovieRepository repository;
		
		@Transactional(readOnly = true)
		/* The method return needs to be DTO, 
		 * 'cos we want to resolve the transaction inside service 
		 * and deliver a simple DTO object to controller;
		 * Pageable - returns sets of objects, instead of all objects at once
		 */
		public Page<MovieDTO> findAll(Pageable pageable) {
			Page<Movie> result = repository.findAll(pageable);
			Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
			return page;
		}
		
		public MovieDTO findById(long id) {
			Movie result = repository.findById(id).get();
			MovieDTO dto = new MovieDTO(result);
			return dto;
		}


}
