package ru.sapteh;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Books {

    public static final String TABLE_Name ="table_books";
    public static final String ID_COLUMN ="id_books";
    public static final String NAME_COLUMN ="Name_books";
    public static final String AUTOR_COLUMN ="Autor";
    public static final String PUBLISHER_COLUMN ="Publisher";


    private Long id;
    private String name;
    private String author;
    private String publishers;
    private Set<Books> books = new HashSet<Books>();
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    @Override
    public String toString(){
        return String.format("%d %s %s %s", getId(),getName(),getAuthor(),getPublishers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return id == books.id && name.equals(books.name) && author.equals(books.author) && publishers.equals(books.publishers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publishers);
    }
}
