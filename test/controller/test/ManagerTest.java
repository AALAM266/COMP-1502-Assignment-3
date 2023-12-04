package controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import controller.Manager;
import exceptions.MinMaxException;
import exceptions.NegativePriceException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;

class ManagerTest {

	private static Manager manager;

	@BeforeAll
	static void setUp2() {
		try {
			manager = new Manager();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception was thrown: " + e.getMessage());
		}
	}

	@BeforeAll
	static void setUp() {
		Platform.startup(() -> {});

		ObservableList<Toys> testToys = FXCollections.observableArrayList(
				new BoardGames("9870097486", "castle risk", "game sky", 64.1, 10, 2, "Board Game", 2, 4,
						"milla baxter,harpreet reilly"),
				new Animals("2296386544", "chimpanzee", "gamefluent", 12.89, 12, 10, "Animal", "fabric", "l"),
				new Figures("1024162826", "japanese traditional dolls", "game demon", 139.99, 12, 7, "Figure", "h"),
				new Puzzles("5726898779", "pocket cube", "game orc", 42.83, 1, 4, "Puzzle", "m")
				);

		manager.toyInventory = new ArrayList<>(testToys);

		manager.listViewToyInvRemove = new ListView<>();
		manager.listViewToyInvHome = new ListView<>();
		manager.categoryDropDown = new ComboBox<>();
		
		manager.initialize(null, null);
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
