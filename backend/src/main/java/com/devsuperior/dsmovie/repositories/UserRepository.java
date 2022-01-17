/*
 *  Data access object
 *  Operations needed to access the movie database (CRUD)
 */

package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

// Interface that inherits JpaRepository, parameterized with kind of entity (Movie) and id_movie type (Long)
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
