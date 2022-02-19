package esercizio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import esercizio.enetity.Film;
import esercizio.service.FilmService;



@Controller
@RequestMapping("/films")
public class FilmController {

private FilmService filmService;
	
	@Autowired
	public FilmController(FilmService thefilmService) {
		filmService = thefilmService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listfilms(Model theModel) {
		
		// get films from db
		List<Film> thefilms = filmService.findAll();
		
		// add to the spring model
		theModel.addAttribute("films", thefilms);
		
		return "films/list-films";
	}
	
	@GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        List<Film> thefilms = filmService.findAll();
        int theId =1;

        for(int i=0; i<thefilms.size();i++) {

            theId++;

        }
        // create model attribute to bind form data
        Film thefilm = new Film();

//        thefilm.setTitolo();

        theModel.addAttribute("film", thefilm);

        return "films/film-form";
    }
	
	@PostMapping("/save")
	public String savefilm(@ModelAttribute("film") Film theFilm, Model theModel) {
		
		// save the film
		filmService.save(theFilm);
		
		listfilms(theModel);
		
		// use a redirect to prevent duplicate submissions
		return "films/list-films";
	}
	
	
	@GetMapping("/search")
    public String searchFilms(@RequestParam("titolo") String titolo, Model theModel) {

        // get films from db
        List<Film> thefilm = filmService.findByName(titolo);

        // add to the spring model
        theModel.addAttribute("films", thefilm);

        return "films/list-films";
    }
}
