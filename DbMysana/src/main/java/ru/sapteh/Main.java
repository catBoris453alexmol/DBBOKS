package ru.sapteh;

import ru.sapteh.Dao.BooksDao;
import ru.sapteh.imp.BooksDaoImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите действие Select, Create, Update, Delete: ");
        String give = reader.readLine();
        BooksDaoImp booksDaoImp = new BooksDaoImp();
        Books books = new Books();
        if (give.equals("Select")) {
            System.out.println(booksDaoImp.findAll());
        }
        if (give.equals("Create")){
            System.out.println("Input name books: ");
            String name = reader.readLine();
            System.out.println("Input autor: ");
            String autor = reader.readLine();
            System.out.println("Input publisher: ");
            String publisher = reader.readLine();
        }
    }
}
