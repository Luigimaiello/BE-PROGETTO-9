package esercizio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esercizio.enetity.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

	
}
