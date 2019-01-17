package com.demo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class LogTest1
{
    private static Logger logger = LoggerFactory.getLogger(LogTest1.class);

    public static void main(String[] args) {
//        Logger logger = LogManager.getLogger("Root");
//        Logger logger = LogManager.getLogger("mylog");

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        test();
    }


    public static void test(){
        logger.info("test");
    }

}
