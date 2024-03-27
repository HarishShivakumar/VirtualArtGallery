package com.hexaware.entity;
/**
 * Artist
 *
 * This class represents an artist entity in the virtual art gallery system.
 * It holds information about an artist, including their ID, name, biography, birth date, nationality, website, and contact information.
 */
public class Artist {

    /**
     * Unique identifier for the artist.
     */
    private int artistId;

    /**
     * Name of the artist.
     */
    private String name;

    /**
     * Biographical information about the artist.
     */
    private String biography;

    /**
     * Artist's date of birth.
     */
    private String birthDate;

    /**
     * Nationality of the artist.
     */
    private String nationality;

    /**
     * Artist's website URL (if available).
     */
    private String website;

    /**
     * Artist's contact information (phone number or email address).
     */
    private int contact;  // Consider using a String for contact information (phone or email)

    // Default constructor (already documented)
    public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

    /**
     * Parameterized constructor to create an Artist object with the given details.
     *
     * @param artistId The unique identifier for the artist.
     * @param name The name of the artist.
     * @param biography The biographical information about the artist.
     * @param birthDate The artist's date of birth.
     * @param nationality The nationality of the artist.
     * @param website The artist's website URL (if available).
     * @param contact The artist's contact information (phone number or email address).
     */
	public Artist(int artistId, String name, String biography, String birthDate, String nationality, String website,
			int contact) {
		super();
		this.artistId = artistId;
		this.name = name;
		this.biography = biography;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.website = website;
		this.contact = contact;
	}
	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", name=" + name + ", biography=" + biography + ", birthDate="
				+ birthDate + ", nationality=" + nationality + ", website=" + website + ", contact=" + contact + "]";
	}

}
