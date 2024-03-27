package com.hexaware.entity;

import java.util.Date;

/**
 * Artwork
 *
 * This class represents an artwork entity in the virtual art gallery system.
 * It holds information about an artwork, including its ID, title, description, creation date, medium, image URL, and artist ID.
 */
public class Artwork {

    /**
     * Unique identifier for the artwork.
     */
	private int artworkID;
	/**
     * Title of the artwork.
     */
    private String title;
    /**
     * Description of the artwork.
     */
    private String description;
    /**
     * Date the artwork was created.
     */
    private Date creationDate;

    /**
     * Artistic medium used to create the artwork (e.g., painting, sculpture, photography).
     */
    private String medium;
    /**
     * URL of an image representing the artwork.
     */
    private String imageURL;

    /**
     * Foreign key referencing the artist who created the artwork.
     */
    private int artistID; 
 // Default constructor
    public Artwork() {
    }

    /**
     * Parameterized constructor to create an Artwork object with the given details.
     *
     * @param artworkID The unique identifier for the artwork.
     * @param title The title of the artwork.
     * @param description The description of the artwork.
     * @param creationDate The date the artwork was created.
     * @param medium The artistic medium used to create the artwork.
     * @param imageURL The URL of an image representing the artwork.
     * @param artistID The foreign key referencing the artist who created the artwork.
     */
    // Parameterized constructor
    public Artwork(int artworkID, String title, String description, Date creationDate, String medium, String imageURL, int artistID) {
        this.artworkID = artworkID;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.medium = medium;
        this.imageURL = imageURL;
        this.artistID = artistID;
    }

    // Getters and setters
    public int getArtworkID() {
        return artworkID;
    }

    public void setArtworkID(int artworkID) {
        this.artworkID = artworkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }
    @Override
    public String toString() {
        return "Artwork{" +
                "artworkID=" + artworkID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", medium='" + medium + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", artistID=" + artistID +
                '}';
    }
    
}

