package com.hexaware.dao;

import java.util.List;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.exception.ArtworkNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public interface IVirtualArtGallery {
	// Artwork management Methods
	boolean addArtwork(Artwork artwork);
    
    boolean updateArtwork(Artwork artwork);

    boolean removeArtwork(int artworkID);

    Artwork getArtworkById(int artworkID)throws ArtworkNotFoundException;

    List<Artwork> searchArtworks(String keyword);
   // User-Favourite Methods
    
    boolean addArtworkToFavorite(int userID, int artworkID);
    
    boolean removeArtworkFromFavorite(int userID, int artworkID);
    
    List<Artwork> getUserFavoriteArtworks(int userId) throws UserNotFoundException;
    
    //Gallery Methods
    
    boolean createNewGallery(Gallery gallery);
    
    boolean updateGallery(Gallery gallery);
    
    boolean removeGallery(int artworkID);
    
    List<Gallery> searchGallery(String keyword);
    
}
