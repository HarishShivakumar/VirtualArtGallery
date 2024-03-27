package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.exception.ArtworkNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;

/**
 * VirtualArtGalleryImpl
 *
 * This class implements the IVirtualArtGallery interface, providing methods to
 * interact with the virtual art gallery database. It handles operations related
 * to artworks, galleries, favorites, and user management.
 */
public class VirtualArtGalleryImpl implements IVirtualArtGallery {
	/**
	 * Connection to the database.
	 */
	private Connection connection;

	/**
	 * Constructs a VirtualArtGalleryImpl object with the provided database
	 * connection.
	 *
	 * @param connection The database connection to use.
	 */
	public VirtualArtGalleryImpl(Connection connection) {
		this.connection = connection;
	}

	public VirtualArtGalleryImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Adds a new artwork to the database.
	 *
	 * @param artwork The Artwork object representing the artwork to be added.
	 * @return True if the artwork is added successfully, false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean addArtwork(Artwork artwork) {
		try {

			String INSERT_ARTWORK_SQL = "INSERT INTO Artwork (Title, Description, CreationDate, Medium, ImageURL, ArtistID) VALUES (?, ?,CURRENT_DATE, ?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ARTWORK_SQL)) {
				preparedStatement.setString(1, artwork.getTitle());
				preparedStatement.setString(2, artwork.getDescription());
				preparedStatement.setString(3, artwork.getMedium());
				preparedStatement.setString(4, artwork.getImageURL());
				preparedStatement.setInt(5, artwork.getArtistID());

				int rowsAffected = preparedStatement.executeUpdate();

				return rowsAffected > 0;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return false;

	}

	/**
	 * Updates an existing artwork in the database.
	 *
	 * @param artwork The Artwork object containing the updated information.
	 * @return True if the artwork is updated successfully, false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean updateArtwork(Artwork artwork) {
		// TODO Auto-generated method stub
		String UPDATE_ARTWORK_SQL = "UPDATE Artwork SET Title=?, Description=?, Medium=?, ImageURL=?, ArtistID=? WHERE ArtworkID=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ARTWORK_SQL)) {
			preparedStatement.setString(1, artwork.getTitle());
			preparedStatement.setString(2, artwork.getDescription());
			preparedStatement.setString(3, artwork.getMedium());
			preparedStatement.setString(4, artwork.getImageURL());
			preparedStatement.setInt(5, artwork.getArtistID());
			preparedStatement.setInt(6, artwork.getArtworkID());

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Removes an artwork from the database by its ID.
	 *
	 * @param artworkID The unique identifier of the artwork to be removed.
	 * @return True if the artwork is removed successfully, false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean removeArtwork(int artworkID) {
		// TODO Auto-generated method stub
		String DELETE_ARTWORK_SQL = "DELETE FROM Artwork WHERE ArtworkID=? LIMIT 1 ";

		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ARTWORK_SQL)) {
			preparedStatement.setInt(1, artworkID);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Retrieves an artwork from the database by its ID.
	 *
	 * @param artworkID The unique identifier of the artwork to retrieve.
	 * @return The Artwork object representing the retrieved artwork, or null if not
	 *         found.
	 * @throws ArtworkNotFoundException If the artwork with the specified ID is not
	 *                                  found in the database.
	 * @throws SQLException             If an error occurs while interacting with
	 *                                  the database.
	 */
	@Override
	public Artwork getArtworkById(int artworkID) throws ArtworkNotFoundException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Artwork WHERE ArtworkID = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, artworkID);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					// Create and populate the Artwork object
					Artwork artwork = new Artwork();
					artwork.setArtworkID(resultSet.getInt("ArtworkID"));
					artwork.setTitle(resultSet.getString("Title"));
					artwork.setDescription(resultSet.getString("Description"));
					artwork.setCreationDate(resultSet.getDate("CreationDate"));
					artwork.setMedium(resultSet.getString("Medium"));
					artwork.setImageURL(resultSet.getString("ImageURL"));
					artwork.setArtistID(resultSet.getInt("ArtistID"));

					return artwork;
				} else {
					throw new ArtworkNotFoundException("Artwork with ID " + artworkID + " not found");
				}
			}
		} catch (SQLException e) {

			System.err.println("Error retrieving artwork with ID " + artworkID + ": " + e.getMessage());
		}

		return null;
	}

	/**
	 * Searches for artworks in the database based on a keyword. The keyword can be
	 * matched against the title or description of the artwork.
	 *
	 * @param keyword The keyword to search for.
	 * @return A list of Artwork objects matching the search criteria. An empty list
	 *         is returned if no matching artworks are found.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public List<Artwork> searchArtworks(String keyword) {
		List<Artwork> matchingArtworks = new ArrayList<>();
		String sql = "SELECT * FROM Artwork WHERE Title LIKE ? OR Description LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Artwork artwork = new Artwork();
					artwork.setArtworkID(resultSet.getInt("ArtworkID"));
					artwork.setTitle(resultSet.getString("Title"));
					artwork.setDescription(resultSet.getString("Description"));
					artwork.setCreationDate(resultSet.getDate("CreationDate"));
					artwork.setMedium(resultSet.getString("Medium"));
					artwork.setImageURL(resultSet.getString("ImageURL"));
					artwork.setArtistID(resultSet.getInt("ArtistID"));
					matchingArtworks.add(artwork);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return matchingArtworks;
	}

	/**
	 * Adds an artwork to a user's favorite list.
	 *
	 * @param userID    The ID of the user adding the artwork to their favorites.
	 * @param artworkID The ID of the artwork to be added to the favorites list.
	 * @return True if the artwork is added to the favorites list successfully,
	 *         false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean addArtworkToFavorite(int userID, int artworkID) {
		String INSERT_FAVORITE_SQL = "INSERT INTO UserFavArtist (UserID, ArtworkID) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FAVORITE_SQL)) {
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, artworkID);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Retrieves a list of artworks favorited by a user.
	 *
	 * @param userID The ID of the user whose favorite artworks are to be retrieved.
	 * @return A list of Artwork objects representing the user's favorite artworks.
	 *         An empty list is returned if the user has no favorited artworks.
	 * @throws UserNotFoundException If the user with the specified ID is not found
	 *                               in the database.
	 * @throws SQLException          If an error occurs while interacting with the
	 *                               database.
	 */
	@Override
	public List<Artwork> getUserFavoriteArtworks(int userID) throws UserNotFoundException {
		List<Artwork> favoriteArtworks = new ArrayList<>();
		String sql = "SELECT A.* FROM Artwork A " + "JOIN UserFavArtist UFA ON A.ArtworkID = UFA.ArtworkID "
				+ "WHERE UFA.UserID = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, userID);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					Artwork artwork = new Artwork();
					artwork.setArtworkID(resultSet.getInt("ArtworkID"));
					artwork.setTitle(resultSet.getString("Title"));
					artwork.setDescription(resultSet.getString("Description"));
					artwork.setCreationDate(resultSet.getDate("CreationDate"));
					artwork.setMedium(resultSet.getString("Medium"));
					artwork.setImageURL(resultSet.getString("ImageURL"));
					artwork.setArtistID(resultSet.getInt("ArtistID"));

					favoriteArtworks.add(artwork);
				} else {
					throw new UserNotFoundException("User with ID " + userID + " not found");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return favoriteArtworks;
	}

	/**
	 * Removes an artwork from a user's favorite list.
	 *
	 * @param userID    The ID of the user removing the artwork from their
	 *                  favorites.
	 * @param artworkID The ID of the artwork to be removed from the favorites list.
	 * @return True if the artwork is removed from the favorites list successfully,
	 *         false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean removeArtworkFromFavorite(int userID, int artworkID) {
		String DELETE_FAVORITE_SQL = "DELETE FROM UserFavArtist WHERE UserID = ? AND ArtworkID = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FAVORITE_SQL)) {
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, artworkID);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
	// Document methods for creating, updating, removing, and searching galleries
	// (similar format)

	/**
	 * Creates a new gallery in the database.
	 *
	 * @param gallery The Gallery object representing the gallery to be created.
	 * @return True if the gallery is created successfully, false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean createNewGallery(Gallery gallery) {
		try {

			String INSERT_GALLERY_SQL = "INSERT INTO Gallery (Name, Description, Location, Curator, OpeningHours) VALUES (?, ?,?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GALLERY_SQL)) {
				preparedStatement.setString(1, gallery.getName());
				preparedStatement.setString(2, gallery.getDescription());
				preparedStatement.setString(3, gallery.getLocation());
				preparedStatement.setInt(4, gallery.getCurator());
				preparedStatement.setString(5, gallery.getOpeningHours());

				int rowsAffected = preparedStatement.executeUpdate();

				return rowsAffected > 0;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return false;

	}

	/**
	 * Updates an existing gallery in the database.
	 *
	 * @param gallery The Gallery object containing the updated information.
	 * @return True if the gallery is updated successfully, false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean updateGallery(Gallery gallery) {
		// TODO Auto-generated method stub
		String UPDATE_GALLERY_SQL = "UPDATE Gallery SET Name=?, Description=?, Location=?, Curator=?, OpeningHours=? WHERE GalleryID=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GALLERY_SQL)) {
			preparedStatement.setString(1, gallery.getName());
			preparedStatement.setString(2, gallery.getDescription());
			preparedStatement.setString(3, gallery.getLocation());
			preparedStatement.setInt(4, gallery.getCurator());
			preparedStatement.setString(5, gallery.getOpeningHours());
			preparedStatement.setInt(6, gallery.getGalleryId());

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Removes a gallery from the database by its ID.
	 *
	 * @param galleryID The unique identifier of the gallery to be removed.
	 * @return True if the gallery is removed successfully, false otherwise.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public boolean removeGallery(int galleryID) {
		// TODO Auto-generated method stub
		String DELETE_GALLERY_SQL = "DELETE FROM Gallery WHERE GalleryID=? LIMIT 1 ";

		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GALLERY_SQL)) {
			preparedStatement.setInt(1, galleryID);

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Searches for galleries in the database based on a keyword. The keyword can be
	 * matched against the name or description of the gallery.
	 *
	 * @param keyword The keyword to search for.
	 * @return A list of Gallery objects matching the search criteria. An empty list
	 *         is returned if no matching galleries are found.
	 * @throws SQLException If an error occurs while interacting with the database.
	 */
	@Override
	public List<Gallery> searchGallery(String keyword) {
		// TODO Auto-generated method stub
		List<Gallery> matchingGallery = new ArrayList<>();
		String sql = "SELECT * FROM Gallery WHERE Name LIKE ? OR Description LIKE ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Gallery gallery = new Gallery();
					gallery.setGalleryId(resultSet.getInt("GalleryID"));
					gallery.setName(resultSet.getString("Name"));
					gallery.setDescription(resultSet.getString("Description"));
					gallery.setLocation(resultSet.getString("Location"));
					gallery.setCurator(resultSet.getInt("Curator"));
					gallery.setOpeningHours(resultSet.getString("OpeningHours"));

					matchingGallery.add(gallery);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return matchingGallery;
	}
}
