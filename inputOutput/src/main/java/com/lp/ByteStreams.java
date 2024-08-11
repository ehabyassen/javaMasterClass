package com.lp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {

    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("Xanadu.txt");
             FileOutputStream out = new FileOutputStream("output.txt")) {
            out.write(in.readAllBytes());
        }
    }
}
