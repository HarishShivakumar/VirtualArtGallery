package com.hexaware.entity;

public class Artist {
	private int artistId;
	private String name;
	private String biography;
	private String birthDate;
	private String nationality;
	private String website;
	private int contact;

	public Artist() {
		super();
	}

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
