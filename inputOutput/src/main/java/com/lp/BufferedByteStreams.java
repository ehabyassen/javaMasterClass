package com.lp;

import java.io.*;

public class BufferedByteStreams {

    public static void main(String[] args) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream("Xanadu.txt"));
            out = new BufferedOutputStream(new FileOutputStream("bufferedBytes.txt"));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            out.flush();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
