package dtos;

import entities.Review;

import java.io.Serializable;

public class ReviewDTO implements Serializable {

    private int review_id;
    private int bookshelf_id;
    private int review_score;
    private String review_text;

    public ReviewDTO() {
    }

    public ReviewDTO(Review r) {
    }

    public int getReview_id() {
        return review_id;
    }
    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getBookshelf_id() {
        return bookshelf_id;
    }
    public void setBookshelf_id(int bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
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

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "review_id=" + review_id +
                ", bookshelf_id=" + bookshelf_id +
                ", review_score=" + review_score +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}
