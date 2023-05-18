package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "review")
@NamedQuery(name = "Review.deleteAllRows", query = "DELETE from Review ")
public class Review implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "review_id")
    private int review_id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "books_in_bookshelf_id")
    private int books_in_bookshelf_id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "review_score")
    private int review_score;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "review_text")
    private String review_text;


    public Review() {
    }

    public Review(int books_in_bookshelf_id, int review_score, String review_text) {
        this.books_in_bookshelf_id = books_in_bookshelf_id;
        this.review_score = review_score;
        this.review_text = review_text;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }


    public int getReview_score() {
        return review_score;
    }

    public void setReview_score(int review_score) {
        this.review_score = review_score;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public int getBooks_in_bookshelf_id() {
        return books_in_bookshelf_id;
    }

    public void setBooks_in_bookshelf_id(int books_in_bookshelf_id) {
        this.books_in_bookshelf_id = books_in_bookshelf_id;
    }
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
        return "Review{" +
                "review_id=" + review_id +
                ", books_in_bookshelf_id='" + books_in_bookshelf_id + '\'' +
//                ", google_id='" + google_id + '\'' +
                ", review_score=" + review_score +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}


