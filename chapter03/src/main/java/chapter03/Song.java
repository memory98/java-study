package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int track;
	private int year;

	public Song(String title, String artist) {
		this(title,artist,null,null,0,0);
		
		System.out.println("some codes6");
	}

	public Song(String title, String artist, String album, String composer, int track, int year) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.track = track;
		this.year = year;

		System.out.println("..... somecode1");
		System.out.println("..... somecode2");
		System.out.println("..... somecode3");
		System.out.println("..... somecode4");
		System.out.println("..... somecode5");
		System.out.println("..... somecode6");

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void Show() {
		System.out.println(
				artist + " : " + title + "(" + album + ", " + composer + " 작곡, " + track + "번, " + year + "년) ");
	}

}
