package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

//Mapeamento objeto-relacional - def JPA como os objetos são convertidos para o DB Relacional
@Entity
@Table(name = "tb_score")

public class Score {
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;
	
	public Score( ) {
	}
	
	// Método para associação filme - score
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}

	public void setUser(User user) {
		id.setUser(user);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Score(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
