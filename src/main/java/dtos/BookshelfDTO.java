package dtos;

import entities.Bookshelf;
import facades.BookshelfFacade;

import java.io.Serializable;

public class BookshelfDTO implements Serializable {

    private int bookshelf_id;
    private String user_name;

    public BookshelfDTO(Bookshelf bs) {
        this.bookshelf_id = bs.getBookshelfId();
        this.user_name = bs.getUser().getUserName();
    }

    public BookshelfDTO(String user_name) {
        this.user_name = user_name;

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


//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getGoogle_id() {
//        return google_id;
//    }
//
//    public void setGoogle_id(String google_id) {
//        this.google_id = google_id;
//    }

    @Override
    public String toString() {
        return "BookshelfDTO{" +
                "bookshelf_id=" + bookshelf_id +
                ", user_name='" + user_name + '\'' +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", description='" + description + '\'' +
//                ", google_id='" + google_id + '\'' +
                '}';
    }
}
