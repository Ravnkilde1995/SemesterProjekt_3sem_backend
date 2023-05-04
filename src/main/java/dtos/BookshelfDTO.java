package dtos;


import entities.Bookshelf;

import java.io.Serializable;

public class BookshelfDTO implements Serializable {

    private int bookshelf_id;
    private String user_name;
    private String title;
    private String author;
    private String description;

    public BookshelfDTO(Bookshelf bs){

    }

    public BookshelfDTO(int bookshelf_id, String user_name, String title, String author, String description) {
        this.bookshelf_id = bookshelf_id;
        this.user_name = user_name;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public int getBookshelf_id() {
        return bookshelf_id;
    }

    public void setBookshelf_id(int bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookshelfDTO{" +
                "bookshelf_id=" + bookshelf_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
