package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task0 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task0() {
    }

    private void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }
}
