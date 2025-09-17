package Movice;

import java.sql.Date;

public class MovieDTO {

	private int movie_id;
	private String title;
	private String img_url;
	private Date date;
	private String description;
	private String genre;
	private String director;
	private double rating;

	public MovieDTO() {
		// 기본 생성자
	}

	public MovieDTO(String title, String img_url, Date date) {
		this.title = title;
		this.img_url = img_url;
		this.date = date;
	}

	public MovieDTO(String title, String img_url, Date date, String description, String genre, String director, double rating) {
		this.title = title;
		this.img_url = img_url;
		this.date = date;
		this.description = description;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MovieDTO [movie_id=" + movie_id + ", title=" + title + ", img_url=" + img_url + ", date=" + date 
				+ ", description=" + description + ", genre=" + genre + ", director=" + director + ", rating=" + rating + "]";
	}

}
