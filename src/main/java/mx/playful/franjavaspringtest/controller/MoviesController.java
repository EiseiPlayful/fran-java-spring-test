package mx.playful.franjavaspringtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.playful.franjavaspringtest.dao.IMoviesDAO;
import mx.playful.franjavaspringtest.dto.MoviesDTO;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

	@Autowired
	private IMoviesDAO moviesDAO;

	@RequestMapping(value = "/get/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public MoviesDTO getTitle(@PathVariable Integer id) {
		MoviesDTO b = null;
		try {
			b = moviesDAO.getTitle(id);
		} catch (Exception e) {
			System.out.println("Recovery data exception!");
		}

		return b;
	}

	@RequestMapping(value = "/set/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public void setTitle(@PathVariable Integer id, @RequestParam(value="title", required=true) String title) {
		try {
			moviesDAO.setTitle(id, title);
		} catch (Exception e) {
			System.out.println("Set data exception!");
		}
	}
}
