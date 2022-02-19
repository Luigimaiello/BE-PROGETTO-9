package esercizio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import esercizio.dao.FilmRepository;
import esercizio.enetity.Film;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	public FilmServiceImpl(FilmRepository theFilmRepository) {
		filmRepository = theFilmRepository;
	}
	
	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Film theFilm) {

		filmRepository.save(theFilm);
	}


	public List<Film> findByName(String Titolo) {

        List<Film> result = filmRepository.findAll();

        List<Film> ricercaParziale = new ArrayList();

        if (!result.isEmpty()) {
            for (Film film : result) {
            if(film.getTitolo().startsWith(Titolo)) {
                ricercaParziale.add(film);
            }

            if(film.getTitolo().contentEquals(Titolo)){
                List<Film> filmResult = new ArrayList();
                result.add(film);
                    return  filmResult;
                }
            }
        }

        return ricercaParziale;


	}
        
}
