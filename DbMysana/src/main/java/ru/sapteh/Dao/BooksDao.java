package ru.sapteh.Dao;

import ru.sapteh.Books;

import java.util.List;

public interface BooksDao {
    String SQL_FIND_ALL = String.format("SELECT * FROM %s", Books.TABLE_Name);
    String SQL_FIND_ID =String.format( "SELECT * FROM %s WHERE %s = ?", Books.TABLE_Name,Books.ID_COLUMN);
    String SQL_INSERT = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?) ",  Books.TABLE_Name,
            Books.NAME_COLUMN, Books.AUTOR_COLUMN, Books.PUBLISHER_COLUMN );
    String SQL_UPDATE = String.format("UPDATE %s SET %s = ?, %s =?, %s = ? WHERE %s = ? ",Books.TABLE_Name,
            Books.NAME_COLUMN,Books.AUTOR_COLUMN,Books.PUBLISHER_COLUMN,Books.ID_COLUMN);
    String SQL_DELETE = String.format("DELETE FROM %s WHERE %s = ? ",Books.TABLE_Name,Books.ID_COLUMN);

    List<Books> findAll();
    //Books findById(Long id);
    void insert(Books books);
    void update(Books books);
    void delete(Books books);
}
