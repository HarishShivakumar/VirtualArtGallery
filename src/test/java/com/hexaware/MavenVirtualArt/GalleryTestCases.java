package com.hexaware.MavenVirtualArt;

import static org.junit.Assert.assertEquals;

import java.sql.*;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

import com.hexaware.dao.VirtualArtGalleryImpl;
import com.hexaware.entity.Gallery;
import com.hexaware.util.DbConnection;

/**
 * This JUnit test class tests functionalities related to managing gallery data
 * in the virtual art gallery system. The tests focus on adding, updating, and
 * removing galleries from the database.
 */
public class GalleryTestCases {
	private static Connection connection;
	private static VirtualArtGalleryImpl service;

	/**
	 * Establishes a connection to the database before each test case execution.
	 * Prints a message indicating success or failure of the connection attempt.
	 */
	@Before
	public void setUp() {
		connection = DbConnection.getConnection();
		if (connection == null) {
			System.out.println("Failed to establish database connection.");
		} else {
			System.out.println("Database connection established successfully.");
		}
	}

	/**
	 * Test case to verify adding a new gallery to the database. 1. Creates a new
	 * Gallery object with sample data. 2. Prepares a SQL statement to insert the
	 * gallery data. 3. Executes the insert statement and retrieves the newly
	 * created gallery record. 4. Compares the inserted gallery data with the
	 * retrieved data using the `equal` method. 5. Uses JUnit's `assertEquals` to
	 * verify if the comparison is successful.
	 */
	@Test
	public void TestAddingNewGallery() {
		Gallery gallery = new Gallery(4, "name4", "desc4", "loc4", 1, "10 Am - 12 PM");
		ResultSet rs = null;
		try {
			PreparedStatement ps = connection.prepareStatement("insert into gallery values(?,?,?,?,?,?)");
			ps.setInt(1, gallery.getGalleryId());
			ps.setString(2, gallery.getName());
			ps.setString(3, gallery.getDescription());
			ps.setString(4, gallery.getLocation());
			ps.setInt(5, gallery.getCurator());
			ps.setString(6, gallery.getOpeningHours());
			ps.execute();
			rs = ps.executeQuery("select * from gallery where galleryID=4");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(true, equal(gallery, rs));
	}

	/**
	 * Test case to verify updating an existing gallery in the database. 1. Creates
	 * a Gallery object with updated data for an existing gallery. 2. Prepares a SQL
	 * statement to update the gallery data based on the gallery ID. 3. Executes the
	 * update statement and retrieves the updated gallery record. 4. Compares the
	 * updated gallery data with the retrieved data using the `equal` method. 5.
	 * Uses JUnit's `assertEquals` to verify if the comparison is successful.
	 */
	@Test
	public void TestUpdatingNewGallery() {
		Gallery gallery = new Gallery(2, " name2", "desc4", "loc4", 1, "11 Am - 12 PM");
		ResultSet rs = null;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"update gallery set Name=?,Description=?,Location=?,Curator=?,OpeningHours=? where galleryId=?");

			ps.setString(1, gallery.getName());
			ps.setString(2, gallery.getDescription());
			ps.setString(3, gallery.getLocation());
			ps.setInt(4, gallery.getCurator());
			ps.setString(5, gallery.getOpeningHours());
			ps.setInt(6, gallery.getGalleryId());
			ps.execute();
			rs = ps.executeQuery("select * from gallery where galleryID=2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, equal(gallery, rs));
	}

	/**
	 * Test case to verify removing a gallery from the database. 1. Executes a SQL
	 * DELETE statement to remove a gallery based on its ID (ID=4 in this case). 2.
	 * Stores the number of rows affected by the DELETE statement. 3. Uses JUnit's
	 * `assertEquals` to verify if exactly one row was deleted (successful removal).
	 */
	@Test
	public void TestRemoveGallery() {
		int rows_affected = 0;
		Statement s;
		try {
			s = connection.createStatement();
			rows_affected = s.executeUpdate("Delete from gallery where galleryID=4");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(1, rows_affected);
	}

	/**
	 * Closes the database connection after each test case execution.
	 */
	@After
	public void tearDown() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Compares a `Gallery` object with a result set (`ResultSet`) from a database
	 * query.
	 * 
	 * @param gallery The `Gallery` object to compare.
	 * @param rs      The `ResultSet` containing data retrieved from the database.
	 * @return `true` if the `Gallery` object data matches the corresponding record
	 *         in the `ResultSet`, `false` otherwise.
	 */
	public boolean equal(Gallery gallery, ResultSet rs) {
		try {
			if (rs.next()) {
				if (gallery.getGalleryId() == rs.getInt(1) && gallery.getCurator() == rs.getInt(5)) {
					if (gallery.getName().compareTo(rs.getString(2)) == 0
							&& (gallery.getLocation().compareTo(rs.getString(4)) == 0)
							&& gallery.getDescription().compareTo(rs.getString(3)) == 0
							&& gallery.getOpeningHours().compareTo(rs.getString(6)) == 0)
						return true;
				}
			}
		} catch (SQLException e) {

			System.out.print(e.getMessage());
		}
		return false;
	}

	public static VirtualArtGalleryImpl getService() {
		return service;
	}

	public static void setService(VirtualArtGalleryImpl service) {
		GalleryTestCases.service = service;
	}
}