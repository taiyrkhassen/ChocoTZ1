package com.example.chocotz1;

import java.util.concurrent.ConcurrentMap;

public class Book {
    private String nameBook;
    private int pagesCount;
    private int price;
    public Book(String nameBook, int pagesCount, int price){
        this.nameBook = nameBook;
        this.pagesCount = pagesCount;
        this.price = price;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
