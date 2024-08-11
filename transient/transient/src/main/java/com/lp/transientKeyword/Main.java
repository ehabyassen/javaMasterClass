package com.lp.transientKeyword;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.setBookName("Java Reference");
        book.setDescription("will not be saved");
        book.setCopies(25);
        Writer writer = new Writer();
        writer.setAge(40);
        writer.setName("Taha Hussein");
        book.setWriter(writer);

        try {
            serialize(book);
            Book deserialized = deserialize();
            System.out.println(deserialized);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void serialize(Book book) throws Exception {
        FileOutputStream file = new FileOutputStream("book.tmp");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(book);
        out.close();
        file.close();
    }

    private static Book deserialize() throws Exception {
        FileInputStream file = new FileInputStream("book.tmp");
        ObjectInputStream in = new ObjectInputStream(file);
        Book book = (Book) in.readObject();
        in.close();
        file.close();
        return book;
    }
}
