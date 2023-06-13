package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {

    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void loggerTest1(){

        logger.fatal("Fatal log ... ");
        logger.error("Error log ... ");
        logger.warn("Warn log ... ");//You can see this log after log4j2.xml configuration.
        logger.info("Info log ... ");//You can see this log after log4j2.xml configuration.
        logger.debug("Debug log ... ");//You can see this log after log4j2.xml configuration.
    }

    @Test
    public void loggerTest2(){

        System.out.println("===Utils===");

        LoggerUtils.fatal("Fatal log from Utils class");
        LoggerUtils.error("Error log from Utils class");
        LoggerUtils.warn("Warn log from Utils class");
        LoggerUtils.info("Info log from Utils class");
        LoggerUtils.debug("Debug log from Utils class");

    }

}