package dtos;


import entities.Bookshelf;

import java.io.Serializable;

public class BookshelfDTO implements Serializable {

    private String bookshelf_id;
    private String book_id;
    private String user_name;
    private String title;
    private String author;
    private String description;

    public BookshelfDTO(Bookshelf bs){

    }

    public BookshelfDTO(String bookshelf_id, String book_id, String user_name, String title, String author, String description) {
        this.bookshelf_id = bookshelf_id;
        this.book_id = book_id;
        this.user_name = user_name;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getBookshelf_id() {
        return bookshelf_id;
    }
    public void setBookshelf_id(String bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBook_id() {
        return book_id;
    }
    public void setBook_id(String book_id) {
        this.book_id = book_id;
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
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
