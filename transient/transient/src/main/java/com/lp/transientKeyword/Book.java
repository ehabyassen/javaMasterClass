package com.lp.transientKeyword;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = -8221347241071951642L;
    private String bookName;
    private transient String description;
    private transient int copies;
    private final transient String bookCategory = "Fiction";

    private final transient String bookCategoryNewOperator = new String("Fiction with new Operator");

    private Writer writer;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                ", copies=" + copies +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookCategoryNewOperator='" + bookCategoryNewOperator + '\'' +
                ", writer=" + writer +
                '}';
    }
}
