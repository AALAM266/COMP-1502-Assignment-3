package controller.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import controller.Manager;
import exceptions.MinMaxException;
import exceptions.NegativePriceException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

class ManagerTest {

	private Manager manager;

    @Before
    public void setUp() {
        try {
            manager = new Manager();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception was thrown: " + e.getMessage());
        }
    }
    
    @Test
    void testLoadFXML() {
        assertDoesNotThrow(() -> {
            Parent root = FXMLLoader.load(getClass().getResource("/view/lsview.fxml"));
            assertNotNull(root);
        });
    }

	@Test
	public void testIsValidSerialNumber() {
		assertTrue(manager.isValidSerialNumber("1234567890"));
		assertFalse(manager.isValidSerialNumber("12345"));
		assertFalse(manager.isValidSerialNumber("abcdefghij"));
		assertFalse(manager.isValidSerialNumber(null));
	}

	@Test
	public void testIsValidToyPrice() throws NegativePriceException {
		assertTrue(manager.isValidToyPrice("10.99"));
		assertThrows(NegativePriceException.class, () -> manager.isValidToyPrice("-5.00"));
		assertThrows(NumberFormatException.class, () -> manager.isValidToyPrice("wrong"));
	}

    @Test
    public void testIsValidToyAvailabilityCount() {
        assertTrue(manager.isValidToyAvailabilityCount("10"));
        assertFalse(manager.isValidToyAvailabilityCount("-1"));
        assertFalse(manager.isValidToyAvailabilityCount("abc"));
    }

    @Test
    public void testIsValidToyAgeRating() {
        assertTrue(manager.isValidToyAgeRating("5"));
        assertFalse(manager.isValidToyAgeRating("-3"));
        assertFalse(manager.isValidToyAgeRating("abc"));
    }

    @Test
    public void testIsValidString() {
        assertTrue(manager.isValidString("valid"));
        assertFalse(manager.isValidString(""));
        assertFalse(manager.isValidString(" "));
        assertFalse(manager.isValidString(null));
    }

    @Test
    public void testIsValidFigureClassification() {
        assertTrue(manager.isValidFigureClassification("action"));
        assertFalse(manager.isValidFigureClassification("hero"));
    }

    @Test
    public void testIsValidPuzzleType() {
        assertTrue(manager.isValidPuzzleType("mechanical"));
        assertFalse(manager.isValidPuzzleType("jigsaw"));
    }

    @Test
    public void testIsValidAnimalSize() {
        assertTrue(manager.isValidAnimalSize("small"));
        assertFalse(manager.isValidAnimalSize("huge"));
    }

    @Test
    public void testIsValidMinPlayers() {
        assertTrue(manager.isValidMinPlayers("1"));
        assertFalse(manager.isValidMinPlayers("-1"));
        assertFalse(manager.isValidMinPlayers("abc"));
    }

    @Test
    public void testIsValidMaxPlayers() throws MinMaxException {
        assertTrue(manager.isValidMaxPlayers("4", "2"));
        assertFalse(manager.isValidMaxPlayers("1", "3"));
        assertFalse(manager.isValidMaxPlayers("-1", "2"));
        assertFalse(manager.isValidMaxPlayers("abc", "2"));
    }

}