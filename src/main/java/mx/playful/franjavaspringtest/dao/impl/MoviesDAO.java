package mx.playful.franjavaspringtest.dao.impl;

import org.springframework.stereotype.Component;

import mx.playful.franjavaspringtest.dao.IMoviesDAO;
import mx.playful.franjavaspringtest.dto.MoviesDTO;

@Component
public class MoviesDAO implements IMoviesDAO {

	@Override
	public MoviesDTO getTitle(Integer id) throws Exception {
		// Database access
		return new MoviesDTO(id, " A Clockwork Orange - 1970");
	}

	@Override
	public void setTitle(Integer id, String title) throws Exception {
		// database
		MoviesDTO b = new MoviesDTO(id, title);
		System.out.println("Movie insert" + b.toString());
	}

}
