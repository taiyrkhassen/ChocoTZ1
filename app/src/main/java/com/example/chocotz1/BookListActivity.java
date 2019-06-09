package com.example.chocotz1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BookListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private BookNetwork bookNetwork;
    private BookRepository bookRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        bookNetwork = new BookNetwork();
        bookRepository = new BookRepository();
        initRectclerView();

        try {
            loadToRv();
        } catch (NetworkException e) {
            e.printStackTrace();
        }
    }


    private void loadToRv() throws NetworkException{
        Random rand = new Random();
        if(rand.nextInt(101)>50){
            //from network
            Collection<Book> books = bookNetwork.getAllBooks();
            bookAdapter.setItems(books);
        } else{
            //from db
            Collection<Book> books = bookRepository.getAllBooks();
            bookAdapter.setItems(books);
            throw new NetworkException("Network exception!");
        }


    }


    private void initRectclerView(){
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);
    }

}
