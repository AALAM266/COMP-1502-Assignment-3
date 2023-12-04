package controller.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.AppController;
import model.Toys;

class ControllerTest {

	private AppController appcontrollerInstance;
	
	/**
	 * Sets up the testing environment before each test
	 * Initializes the AppController class and sets the file path to the testing file
	 */
	@BeforeEach
	public void setup() {
		try {
			appcontrollerInstance = new AppController();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception was thrown: " + e.getMessage());
		}
		appcontrollerInstance.fileName = "res/toysTEST.txt";
	}
	
	/**
	 * This test checks if the loadData method properly populates the toy inventory
	 * @throws Exception if an error happens during the load
	 */
	@Test
	void testLoadData() throws Exception {
		appcontrollerInstance.loadData();
		assertNotNull(appcontrollerInstance.toyInventory);
		assertFalse(appcontrollerInstance.toyInventory.isEmpty());

	}
	
	
	
	@Test
	public void testAddAndRemoveItem() throws Exception {
		
		int toyInventoryStartingSize = appcontrollerInstance.toyInventory.size();
		
		appcontrollerInstance.addNewAnimal("1111111111", "axolotl", "gamescape", "4.20", "6", "9", "metal", "l");
		assertTrue(appcontrollerInstance.toyInventory.size() == toyInventoryStartingSize + 1);
		 
		appcontrollerInstance.removeToy(appcontrollerInstance.toyInventory.get(toyInventoryStartingSize).getSerialNumber());
		assertTrue(appcontrollerInstance.toyInventory.size() == toyInventoryStartingSize);
	
	}
	
	/**
	 * This test verifies that the save method executes without throwing an exception
	 */
	@Test
	void testSaveDoesNotThrowException() {
		try {
			appcontrollerInstance.save();
		} catch (Exception e) {
			fail("Save method should not throw an exception!");
		}
	}
	
	/**
	 * This test verifies if the save method creates a file (if one doesn't already exist)
	 */
	@Test
	void testSaveFileCreation() {
		File testFile = new File(appcontrollerInstance.fileName);
		if (testFile.exists()) {
			assertTrue(testFile.delete());
		}
		try {
			appcontrollerInstance.save();
		} catch (Exception e) {
			fail("Save method should not throw an exception!");
		}
		assertTrue(testFile.exists());
	}
	
	/**
	 * This test checks how the loadData method handles a non-existent file
	 */
	@Test
	public void testLoadFileDoesNotExist() {
		appcontrollerInstance.toyInventory.clear(); 

		appcontrollerInstance.fileName = "res/nonExistentFile.txt"; 
																	

		try {
			appcontrollerInstance.loadData();
			assertTrue(appcontrollerInstance.toyInventory.isEmpty());
		} catch (Exception e) {
			fail("An unexpected exception was thrown!: " + e.getMessage());
		}
	}
	
}
