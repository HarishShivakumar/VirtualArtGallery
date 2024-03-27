package com.hexaware.entity;

/**
 * User
 *
 * This class represents a user entity in the virtual art gallery system. It
 * holds information about a user, including their ID, username, password (store
 * securely!), email address, first name, last name, date of birth, profile
 * picture URL (if available), and the number of favorited artworks.
 */
public class User {

	/**
	 * Unique identifier for the user.
	 */
	private int userId;

	/**
	 * Username for user login.
	 */
	private String username;

	/**
	 * Password for user login (store securely using hashing techniques).
	 */
	private String password;

	/**
	 * User's email address.
	 */
	private String email;

	/**
	 * User's first name.
	 */
	private String firstname;

	/**
	 * User's last name.
	 */
	private String lastname;

	/**
	 * User's date of birth.
	 */
	private String dateOfBirth;

	/**
	 * URL of the user's profile picture (if available).
	 */
	private String profilePic;

	/**
	 * Number of artworks favourited by the user.
	 */
	private int favArtworks;

	// Default constructor (already documented)
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor to create a User object with the given details.
	 *
	 * @param userId      The unique identifier for the user.
	 * @param username    The username for user login.
	 * @param password    The password for user login (store securely!).
	 * @param email       The user's email address.
	 * @param firstname   The user's first name.
	 * @param lastname    The user's last name.
	 * @param dateOfBirth The user's date of birth.
	 * @param profilePic  The URL of the user's profile picture (if available).
	 * @param favArtworks The number of artworks favourited by the user.
	 */
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
