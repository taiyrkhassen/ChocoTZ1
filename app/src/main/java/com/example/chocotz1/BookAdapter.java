package com.example.chocotz1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private List<Book> bookList = new ArrayList();

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int position) {
        bookViewHolder.bind(bookList.get(position));

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView pages;

        public BookViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            pages = itemView.findViewById(R.id.pages);

        }

        public void bind(Book book){
            name.setText(book.getNameBook());
            pages.setText(book.getPagesCount()+" pages");
            price.setText(book.getPrice()+" tg");
        }
    }

    public void setItems(Collection books){
        bookList.addAll(books);
        notifyDataSetChanged();
    }
}
