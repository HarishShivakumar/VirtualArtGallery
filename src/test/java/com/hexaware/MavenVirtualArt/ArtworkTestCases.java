package com.hexaware.MavenVirtualArt;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import com.hexaware.dao.VirtualArtGalleryImpl;
import com.hexaware.entity.Artwork;

/**
 * Test class for Artwork functionality in the VirtualArtGalleryImpl class.
 * It covers adding, updating, removing, and searching artwork.
 */
public class ArtworkTestCases {

	VirtualArtGalleryImpl artGallery;
	VirtualArtGalleryImpl gallery;
	VirtualArtGalleryImpl artwork;

    /**
     * Set up method that executes before each test method.
     * It initializes the VirtualArtGalleryImpl object.
     */
	@Before
	public void setUp() {
		System.out.println("From Setup()");
		artGallery = new VirtualArtGalleryImpl();
		gallery = new VirtualArtGalleryImpl();
		artwork = new VirtualArtGalleryImpl();
	}
	/**
     * Test method to verify the addition of new artwork to the gallery.
     */
	@Test
	public void testUploadNewArtwork() {
		Artwork testartwork = new Artwork(100, "MonaLisa", "ByMike", java.sql.Date.valueOf("2024-03-27"), "Null",
				"Null", 123);
		boolean artworkAdded = artGallery.addArtwork(testartwork);
		assertTrue("New Artwork Uploaded Successfully", artworkAdded);
	}
	/**
     * Test method to verify the update of existing artwork details in the gallery.
     */
	@Test
	public void testUpdateArtworkDetails() {
		Artwork existingArtwork = new Artwork(102, "StarBoy", "TheWeeknd", java.sql.Date.valueOf("2024-03-27"),
				"Mp3", "Null", 234);
		boolean isArtworkUpdated = gallery.updateArtwork(existingArtwork);
		assertTrue("Artwork Updated Successfully", isArtworkUpdated);
	}
	/**
     * Test method to verify the removal of artwork from the gallery.
     */
	@Test
	public void testRemoveArtwork() {
		int artworkToRemove =104;
		boolean isArtworkRemoved = artwork.removeArtwork(artworkToRemove);
		assertTrue("Artwork removed successfully", isArtworkRemoved);
	}

    /**
     * Test method to verify the search functionality for artworks in the gallery.
     */
	@Test
	public void testsearchArtwork() {
		VirtualArtGalleryImpl artwork = new VirtualArtGalleryImpl();
		String keywordToSearch = "EyeOfTheTiger";
		artwork.searchArtworks(keywordToSearch);
		assertEquals(1, artwork.searchArtworks("inspiration").size());
	}
	/**
     * Tear down method that executes after each test method.
     * It sets the VirtualArtGalleryImpl object to null for cleanup.
     */
	@After
	public void teardown() {
		System.out.println("From TearDown() ");
		artGallery = null;
		gallery = null;
		artwork = null;
	}
}
