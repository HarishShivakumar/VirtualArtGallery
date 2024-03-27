package com.hexaware.entity;

/**
 * UserFavoriteArtwork
 *
 * This class represents a many-to-many relationship between users and artworks
 * in the virtual art gallery system. It stores the user ID and artwork ID to
 * signify that a particular user has favorited a specific artwork.
 */
public class UserFavoriteArtwork {

	/**
	 * Foreign key referencing the user who has favorited the artwork.
	 */
	private int userID;

	/**
	 * Foreign key referencing the artwork that has been favorited by the user.
	 */
	private int artworkID;

	// Default constructor
	public UserFavoriteArtwork() {
	}

	/**
	 * Parameterized constructor to create a UserFavoriteArtwork object with the
	 * given user and artwork IDs.
	 *
	 * @param userID    The unique identifier of the user who has favorited the
	 *                  artwork.
	 * @param artworkID The unique identifier of the artwork that has been
	 *                  favorited.
	 */
	public UserFavoriteArtwork(int userID, int artworkID) {
		this.userID = userID;
		this.artworkID = artworkID;
	}

	// Getters and setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getArtworkID() {
		return artworkID;
	}

	public void setArtworkID(int artworkID) {
		this.artworkID = artworkID;
	}
}
