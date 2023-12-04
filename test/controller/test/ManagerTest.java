package controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import controller.Manager;
import exceptions.MinMaxException;
import exceptions.NegativePriceException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * This JUnit test class is used to test the functionality of the Manager class
 * 
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
class ManagerTest {

	private static Manager manager; // Manager instance used for testing

	/**
	 * Sets up the testing environment before each test
	 * Initializes the Manager class and JavFX Platform
	 */
	@BeforeAll
	static void setUp() {
	    Platform.startup(() -> {});
	    
	    try {
	        manager = new Manager();
	        manager.listViewToyInvRemove = new ListView<>();
	        manager.listViewToyInvHome = new ListView<>();
	        manager.categoryDropDown = new ComboBox<>();
	        
	        manager.initialize(null, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        fail("Exception was thrown: " + e.getMessage());
	    }
	}

	/**
	 * This tests checks if the isValidSerialNumber method properly validates the serial number
	 */
	@Test
	public void testIsValidSerialNumber() {
		assertTrue(manager.isValidSerialNumber("1234567890"));
		assertFalse(manager.isValidSerialNumber("12345"));
		assertFalse(manager.isValidSerialNumber("abcdefghij"));
		assertFalse(manager.isValidSerialNumber(null));
	}

	/**
	 * This tests checks if the isValidToyPrice method properly validates the toy name
	 *
	 * @throws NegativePriceException if the price is negative
	 * @throws NumberFormatException if the price is not a number
	 */
	@Test
	public void testIsValidToyPrice() throws NegativePriceException {
		assertTrue(manager.isValidToyPrice("10.99"));
		assertThrows(NegativePriceException.class, () -> manager.isValidToyPrice("-5.00"));
		assertThrows(NumberFormatException.class, () -> manager.isValidToyPrice("wrong"));
	}
	
	/**
	 * This tests checks if the IsValidToyAvailabilityCount method properly validates the toy availability count
	 */
	@Test
	public void testIsValidToyAvailabilityCount() {
		assertTrue(manager.isValidToyAvailabilityCount("10"));
		assertFalse(manager.isValidToyAvailabilityCount("-1"));
		assertFalse(manager.isValidToyAvailabilityCount("abc"));
	}

	/**
	 * This tests checks if the isValidToyAgeRating method properly validates the toy age rating
	 */
	@Test
	public void testIsValidToyAgeRating() {
		assertTrue(manager.isValidToyAgeRating("5"));
		assertFalse(manager.isValidToyAgeRating("-3"));
		assertFalse(manager.isValidToyAgeRating("abc"));
	}

	/**
	 * This tests checks if the isValidString method properly validates certain user input (name, type, animal material, board game designers, etc.)
	 */
	@Test
	public void testIsValidString() {
		assertTrue(manager.isValidString("valid"));
		assertFalse(manager.isValidString(""));
		assertFalse(manager.isValidString(" "));
		assertFalse(manager.isValidString(null));
	}

	/**
	 * This tests checks if the isValidFigureClassification method properly validates the figure classification
	 */
	@Test
	public void testIsValidFigureClassification() {
		assertTrue(manager.isValidFigureClassification("action"));
		assertFalse(manager.isValidFigureClassification("hero"));
	}

	/**
	 * This tests checks if the isValidPuzzleType method properly validates the puzzle type
	 */
	@Test
	public void testIsValidPuzzleType() {
		assertTrue(manager.isValidPuzzleType("mechanical"));
		assertFalse(manager.isValidPuzzleType("jigsaw"));
	}

	/**
	 * This tests checks if the IsValidAnimalSize method properly validates the animal type
	 */
	@Test
	public void testIsValidAnimalSize() {
		assertTrue(manager.isValidAnimalSize("small"));
		assertFalse(manager.isValidAnimalSize("huge"));
	}

	/**
	 * This tests checks if the isValidMinPlayers method properly validates the minimum number of players
	 */
	@Test
	public void testIsValidMinPlayers() {
		assertTrue(manager.isValidMinPlayers("1"));
		assertFalse(manager.isValidMinPlayers("-1"));
		assertFalse(manager.isValidMinPlayers("abc"));
	}

	/**
	 * This tests checks if the isValidMaxPlayers method properly validates the maximum number of players
	 * 
	 * @throws MinMaxException if the minimum number of players is greater than the maximum number of players
	 */
	@Test
	public void testIsValidMaxPlayers() throws MinMaxException {
		assertTrue(manager.isValidMaxPlayers("4", "2"));
		assertFalse(manager.isValidMaxPlayers("1", "3"));
		assertFalse(manager.isValidMaxPlayers("-1", "2"));
		assertFalse(manager.isValidMaxPlayers("abc", "2"));
	}

	/**
	 * This test checks if the initialize method properly initializes the JavaFX components
	 */
	@Test
	void testInitialize() {
		
		assertNotNull(manager.listViewToyInvRemove.getItems());
		assertFalse(manager.listViewToyInvRemove.getItems().isEmpty());
		assertNotNull(manager.listViewToyInvHome.getItems());
		assertNotNull(manager.categoryDropDown.getItems());
		assertEquals(4, manager.categoryDropDown.getItems().size());
		assertTrue(manager.categoryDropDown.getItems()
				.containsAll(FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "BoardGame")));
	}
}
