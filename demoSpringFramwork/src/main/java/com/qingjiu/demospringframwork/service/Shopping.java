package com.qingjiu.demospringframwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David
 */
public class Shopping {
    Logger logger = LoggerFactory.getLogger(Shopping.class);
    public void showInfo(){
        logger.info("Shopping...");
    }
}
