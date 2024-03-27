package com.hexaware.entity;

public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String profilePic;
	private int favArtworks;

	public User() {
		super();
	}

	public User(int userId, String username, String password, String email, String firstname, String lastname,
			String dateOfBirth, String profilePic, int favArtworks) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.profilePic = profilePic;
		this.favArtworks = favArtworks;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public int getFavArtworks() {
		return favArtworks;
	}

	public void setFavArtworks(int favArtworks) {
		this.favArtworks = favArtworks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth
				+ ", profilePic=" + profilePic + ", favArtworks=" + favArtworks + "]";
	}

}
