package com.myfirstproject.utilities;

import com.myfirstproject.Day15_Log4J2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {


    //We will use this class for logging info in Test classes


    private static Logger logger = LogManager.getLogger(LoggerUtils.class.getName());

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

}