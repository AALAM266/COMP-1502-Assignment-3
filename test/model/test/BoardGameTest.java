package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BoardGames;

/**
 * This JUnit test class tests the constructor and toString method of the BoardGames class
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
class BoardGameTest {

    /**
     * This method tests the constructor and toString method of the BoardGames class
     */
    @Test
    public void testConstructorAndToStringMethod() {
        BoardGames boardGame = new BoardGames("9870097486", "castle risk", "game sky", 64.1, 10, 2, "Board Game", 2, 4, "milla baxter,harpreet reilly");

        // Updating the assertions to reflect the expectedToString details
        assertEquals("9870097486", boardGame.getSerialNumber());
        assertEquals("castle risk", boardGame.getName());
        assertEquals("game sky", boardGame.getBrand());
        assertEquals(64.1, boardGame.getPrice());
        assertEquals(10, boardGame.getAvailabityCount());
        assertEquals(2, boardGame.getAppropriateAge());
        assertEquals("Board Game", boardGame.getToyType()); 
        assertEquals(2, boardGame.getMinPlayers());
        assertEquals(4, boardGame.getMaxPlayers());
        assertEquals("milla baxter,harpreet reilly", boardGame.getDesigners());

        
        String expectedToString = "Category: Board Game, Serial Number: 9870097486, Name: castle risk, Brand: game sky, Price: 64.1, Available Count: 10, Age Appropriate: 2, Number of Players: 2-4, Designer(s): milla baxter,harpreet reilly";
        assertEquals(expectedToString, boardGame.toString());
    }
}
