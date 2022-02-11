package com.qingjiu.demospringframwork.service;

import com.qingjiu.demospringframwork.dao.entity.Book;
import com.qingjiu.demospringframwork.dao.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reading {
    Logger logger = LoggerFactory.getLogger(Reading.class);

    private int state = 0;
    private Person person;
    private Book book;

    private Reading(Person person){
        this.person = person;
    }
    private Reading(Person person, Book book){
        this.person = person;
        this.book = book;
    }

    public void showState(){
        switch (state){
            case 0:
                logger.info(person.getName()+": "+"Not begin to read.");
                break;
            case 1:
                logger.info(person.getName()+": "+"Reading...");
                break;
            case 2:
                logger.info(person.getName()+": "+"Read OK!");
                break;
            default:
                break;
        }
        return;
    }
    public void beginRead(){
        this.state = 1;
    }
    public void readOk(){
        this.state = 2;
    }
    public void resetState(){
        this.state = 0;
    }

}
