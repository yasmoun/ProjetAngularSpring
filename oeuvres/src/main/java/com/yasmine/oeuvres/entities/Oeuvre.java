package com.yasmine.oeuvres.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Oeuvre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOeuvre ;
	private String titre ;
	private String artiste ;
	private LocalDate dateCreation ;
	private String categorie ;
	private String dimensions ;
	private String description ;
	private Double prix ;
		
	@ManyToOne
	private Exposition exposition ;
	

	@Override
	public String toString() {
		return "Oeuvre [idOeuvre=" + idOeuvre + ", titre=" + titre + ", artiste=" + artiste + ", dateCreation="
				+ dateCreation + ", Categorie=" + categorie + ", dimensions=" + dimensions + ", description="
				+ description + ", prix=" + prix + "]";
	}

	
}
