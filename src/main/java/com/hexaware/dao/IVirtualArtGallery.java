package com.hexaware.dao;

import java.util.List;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.exception.ArtworkNotFoundException;
import com.hexaware.exception.UserNotFoundException;

/**
 * Interface defining methods for interacting with the virtual art gallery
 * system. This interface provides methods for managing artworks, user
 * favorites, and galleries.
 */
public interface IVirtualArtGallery {
	// Artwork Management Methods

	/**
	 * Adds a new artwork to the virtual art gallery.
	 *
	 * @param artwork The Artwork object representing the artwork to be added.
	 * @return True if the artwork is added successfully, false otherwise.
	 */
	boolean addArtwork(Artwork artwork);

	/**
	 * Updates the details of an existing artwork in the virtual art gallery.
	 *
	 * @param artwork The Artwork object containing the updated details.
	 * @return True if the artwork is updated successfully, false otherwise.
	 */
	boolean updateArtwork(Artwork artwork);

	/**
	 * Removes an artwork from the virtual art gallery.
	 *
	 * @param artworkID The ID of the artwork to be removed.
	 * @return True if the artwork is removed successfully, false otherwise.
	 */
	boolean removeArtwork(int artworkID);

	/**
	 * Retrieves an artwork by its ID from the virtual art gallery.
	 *
	 * @param artworkID The ID of the artwork to be retrieved.
	 * @return The Artwork object representing the retrieved artwork.
	 * @throws ArtworkNotFoundException If the artwork with the specified ID is not
	 *                                  found.
	 */
	Artwork getArtworkById(int artworkID) throws ArtworkNotFoundException;

	/**
	 * Searches for artworks in the virtual art gallery based on a keyword.
	 *
	 * @param keyword The keyword to be used for searching.
	 * @return A List of Artwork objects matching the search criteria.
	 */
	List<Artwork> searchArtworks(String keyword);
	// User-Favourite Methods

	/**
	 * Adds an artwork to a user's favorite list.
	 *
	 * @param userID    The ID of the user for whom the artwork is to be favorited.
	 * @param artworkID The ID of the artwork to be added to the user's favorites.
	 * @return True if the artwork is added to the user's favorites successfully,
	 *         false otherwise.
	 */
	boolean addArtworkToFavorite(int userID, int artworkID);

    /**
     * Removes an artwork from a user's favorite list.
     *
     * @param userID The ID of the user from whose favorites the artwork is to be removed.
     * @param artworkID The ID of the artwork to be removed from the user's favorites.
     * @return True if the artwork is removed from the user's favorites successfully, false otherwise.
     */
	boolean removeArtworkFromFavorite(int userID, int artworkID);
	/**
     * Retrieves a list of artworks from a user's favorite list.
     *
     * @param userId The ID of the user whose favorite artworks are to be retrieved.
     * @return A List of Artwork objects representing the user's favorite artworks.
     * @throws UserNotFoundException If the user with the specified ID is not found.
     */
	List<Artwork> getUserFavoriteArtworks(int userId) throws UserNotFoundException;

	// Gallery Methods
	  /**
     * Updates the details of an existing gallery in the virtual art gallery.
     *
     * @param gallery The Gallery object containing the updated details.
     * @return True if the gallery is updated successfully, false otherwise.
     */
	boolean createNewGallery(Gallery gallery);
	 /**
     * Updates the details of an existing gallery in the virtual art gallery.
     *
     * @param gallery The Gallery object containing the updated details.
     * @return True if the gallery is updated successfully, false otherwise.
     */
	boolean updateGallery(Gallery gallery);
	 /**
     * Removes a gallery from the virtual art gallery.
     *
     * @param galleryID The ID of the gallery to be removed.
     * @return True if the gallery is removed successfully, false otherwise.
     */
	boolean removeGallery(int artworkID);
	/**
     * Searches for galleries in the virtual art gallery based on a keyword.
     *
     * @param keyword The keyword to be used for searching.
     * @return A List of Gallery objects matching the search criteria.
     */
	List<Gallery> searchGallery(String keyword);

}
