package mx.playful.franjavaspringtest.dto;

public class MoviesDTO {

	private Integer id;
	private String title;

	public MoviesDTO(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MoviesDTO [id=" + id + ", title=" + title + "]";
	}

}
