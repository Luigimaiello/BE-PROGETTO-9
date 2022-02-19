package esercizio.service;
import java.util.List;

import org.springframework.stereotype.Service;

import esercizio.enetity.Film;

@Service
public interface FilmService {

	public List<Film> findAll();
		
	public void save(Film theFilm);
		
	public List<Film> findByName(String Titolo);
}
