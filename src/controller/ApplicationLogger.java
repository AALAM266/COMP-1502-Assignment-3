package controller;

import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 * The ApplicationLogger class is used to create and update a log while the user is running the application
 * 
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class ApplicationLogger {
	
    private static Logger logger = Logger.getLogger("applog");  // Logger name is "applog"
    private static FileHandler fh; // FileHandler to write to file
    
    /**
     * The static block is used to initialize the FileHandler
     */
    static {
        try {
            fh = new FileHandler("res/applog.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * The logInfo method is used to log an info message
     * @param message the info message to be logged
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * The logWarning method is used to log a warning message
     * @param message the warning message to be logged
     */
    public static void logWarning(String message) {
        logger.warning(message);
    }

    /**
     * The logSevere method is used to log a severe message
     * @param message the severe message to be logged
     */
    public static void logSevere(String message) {
        logger.severe(message);
    }
    
    /**
     * The close method is used to close the FileHandler
     */
    public static void close() {
        fh.close();
    }
}


