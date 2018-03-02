package mx.playful.franjavaspringtest.dao;

import mx.playful.franjavaspringtest.dto.MoviesDTO;

public interface IMoviesDAO {

	public MoviesDTO getTitle(Integer id) throws Exception;

	public void setTitle(Integer id, String title) throws Exception;
}
