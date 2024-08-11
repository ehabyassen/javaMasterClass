package com.lp;

import java.io.*;
import java.util.Iterator;

public class CopyLines {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("Xanadu.txt"));
            writer = new PrintWriter(new FileWriter("lines.txt"));
            Iterator<String> it = reader.lines().iterator();
            while (it.hasNext()) {
                writer.println(it.next());
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
