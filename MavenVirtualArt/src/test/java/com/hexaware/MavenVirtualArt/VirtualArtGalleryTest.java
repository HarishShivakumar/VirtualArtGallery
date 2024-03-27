package com.hexaware.MavenVirtualArt;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import com.hexaware.dao.VirtualArtGalleryImpl;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;

public class VirtualArtGalleryTest {

	VirtualArtGalleryImpl artGallery;
	VirtualArtGalleryImpl gallery;
	VirtualArtGalleryImpl artwork;

	@Before
	public void setUp() {
		System.out.println("From Setup()");
		artGallery = new VirtualArtGalleryImpl();
		gallery = new VirtualArtGalleryImpl();
		artwork = new VirtualArtGalleryImpl();
	}

	@Test
	public void testUploadNewArtwork() {
		Artwork testartwork = new Artwork(100, "MonaLisa", "ByDaVinci",
				java.sql.Date.valueOf("2024-03-27"), "Null", "Null", 123);
		boolean artworkAdded = artGallery.addArtwork(testartwork);
		assertTrue("New Artwork Uploaded Successfully", artworkAdded);
	}

	@Test
	public void testUpdateArtworkDetails() {
		Artwork existingArtwork = new Artwork(101, "BlindingLights", "Pop#1",
				java.sql.Date.valueOf("2024-03-27"), "Song", "Null", 234);
		boolean isArtworkUpdated = gallery.updateArtwork(existingArtwork);
		assertTrue("Artwork Updated Successfully", isArtworkUpdated);
	}

	@Test
	public void testRemoveArtwork() {
		int artworkToRemove = 5;
		boolean isArtworkRemoved = artwork.removeArtwork(artworkToRemove);
		assertTrue("Artwork removed successfully", isArtworkRemoved);
	}

	@Test
	public void testsearchArtwork() {
		VirtualArtGalleryImpl artwork = new VirtualArtGalleryImpl();
		String keywordToSearch = "inspiration";
		artwork.searchArtworks(keywordToSearch);
		assertEquals(1, artwork.searchArtworks("inspiration").size());
	}

	@Test
	public void testCreateNewGallery() {
		VirtualArtGalleryImpl Gallery = new VirtualArtGalleryImpl();
		Gallery testgallery = new Gallery(8, "Memories", "Photographs", "Ahmedabad", 4, "10:00AM - 6:00PM");
		boolean GalleryAdded = Gallery.createNewGallery(testgallery);
		assertTrue("New Gallery Created Successfully", GalleryAdded);
	}

	@Test
	public void testUpdateGalleryDetails() {
		VirtualArtGalleryImpl gallery = new VirtualArtGalleryImpl();
		Gallery update = new Gallery(1, "Historical", "Old,Ancient", "California", 123, "2-3");
		boolean isGalleryUpdated = gallery.updateGallery(update);
		assertTrue("Gallery Updated Successfully", isGalleryUpdated);
	}

	@Test
	public void testRemoveGallery() {
		VirtualArtGalleryImpl gallery = new VirtualArtGalleryImpl();
		int galleryToRemove = 5;
		boolean isGalleryRemoved = gallery.removeArtwork(galleryToRemove);
		assertTrue("Gallery removed successfully", isGalleryRemoved);
	}

	@Test
	public void testsearchGallery() {
		VirtualArtGalleryImpl gallery = new VirtualArtGalleryImpl();
		String keywordToSearch = "memories";
		gallery.searchArtworks(keywordToSearch);
		assertEquals(1, gallery.searchArtworks("memories").size());
	}
	
	@After
	public void teardown() {
		System.out.println("From Setup() Empdao");
		artGallery = null;
	}
}
