package com.example.chocotz1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BookNetwork implements  IRepository {
    Book book;
    @Override
    public Collection<Book> getAllBooks(){
        List coll = new ArrayList<Book>();
        coll.addAll(Arrays.asList(
                new Book("'Kosmos'", 25, 1852),
                new Book("'Android'", 752, 5120),
                new Book("'Kitchen'", 855, 3500)
        ));
        Collections.sort(coll, new BookPriceComparator());
        return coll;
    }
}
