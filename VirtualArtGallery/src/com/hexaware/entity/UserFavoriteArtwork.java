package com.hexaware.entity;

public class UserFavoriteArtwork{
	 	private int userID;
	    private int artworkID;

	    // Default constructor
	    public UserFavoriteArtwork() {
	    }

	    // Parameterized constructor
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
