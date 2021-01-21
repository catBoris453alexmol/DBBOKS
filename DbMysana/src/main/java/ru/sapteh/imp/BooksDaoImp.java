package ru.sapteh.imp;

import ru.sapteh.Books;
import ru.sapteh.ConnectionUtil;
import ru.sapteh.Dao.BooksDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BooksDaoImp implements BooksDao {

    private Connection connection;

    @Override
    public List<Books> findAll() {
        List<Books> result = new ArrayList<Books>();
        try {
            connection = new ConnectionUtil().openConnect();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Books books = new Books();
                books.setId(rs.getLong(Books.ID_COLUMN));
                books.setName(rs.getString(Books.NAME_COLUMN));
                books.setAuthor(rs.getString(Books.AUTOR_COLUMN));
                books.setPublishers(rs.getString(Books.PUBLISHER_COLUMN));
                result.add(books);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

//    public Books findById(Long id) {
//        Connection connection = null;
//        Books books = null;
//        try {
//            connection = new ConnectionUtil().openConnect();
//            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ID);
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                books.setName(rs.getString(Books.NAME_COLUMN));
//                books.setAuthor(rs.getString(Books.AUTOR_COLUMN));
//                books.setPublishers(rs.getString(Books.PUBLISHER_COLUMN));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            new ConnectionUtil().closeConnect(connection);
//        }
//        return books;
//    }

    public void insert(Books books) {
        Connection connection = null;
        try {
            connection = new ConnectionUtil().openConnect();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, books.getName());
            statement.setString(2, books.getAuthor());
            statement.setString(3, books.getPublishers());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                books.setId(rs.getLong(1));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            new ConnectionUtil().closeConnect(connection);
        }
    }

    public void update(Books books) {
        Connection connection = null;
        try {
            connection = new ConnectionUtil().openConnect();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, books.getName());
            statement.setString(2, books.getAuthor());
            statement.setString(3, books.getPublishers());
            statement.setLong(4, books.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            new ConnectionUtil().closeConnect(connection);
        }
    }

    public void delete(Books books) {
        Connection connection = null;
        try {
            connection = new ConnectionUtil().openConnect();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, books.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            new ConnectionUtil().closeConnect(connection);
        }
    }
}

