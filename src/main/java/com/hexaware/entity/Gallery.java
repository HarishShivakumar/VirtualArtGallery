package com.hexaware.entity;
/**
 * Gallery
 *
 * This class represents a gallery entity in the virtual art gallery system.
 * It holds information about a gallery, including its ID, name, description, location, curator ID (foreign key), and opening hours.
 */
public class Gallery {
	/**
     * Unique identifier for the gallery.
     */
	private int galleryId;
	  /**
     * Name of the gallery.
     */
	private String name;
	   /**
     * Description of the gallery.
     */
	private String description;
	  /**
     * Location of the gallery (city, address, etc.).
     */
	private String location;

    /**
     * Foreign key referencing the curator who manages the gallery.
     */
	private int curator;

    /**
     * Opening hours of the gallery.
     */
	private String openingHours;

	public Gallery() {
		super();
	}
	 /**
     * Parameterized constructor to create a Gallery object with the given details.
     *
     * @param galleryId The unique identifier for the gallery.
     * @param name The name of the gallery.
     * @param description The description of the gallery.
     * @param location The location of the gallery.
     * @param curator The foreign key referencing the curator who manages the gallery.
     * @param openingHours The opening hours of the gallery.
     */
	public Gallery(int galleryId, String name, String description, String location, int curator, String openingHours) {
		super();
		this.galleryId = galleryId;
		this.name = name;
		this.description = description;
		this.location = location;
		this.curator = curator;
		this.openingHours = openingHours;
	}

	public int getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCurator() {
		return curator;
	}

	public void setCurator(int curator) {
		this.curator = curator;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	@Override
	public String toString() {
		return "Gallery [galleryId=" + galleryId + ", name=" + name + ", description=" + description + ", location="
				+ location + ", curator=" + curator + ", openingHours=" + openingHours + "]";
	}

}
