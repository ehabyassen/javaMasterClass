package com.learn.localClass;

import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static Button btn = new Button("Print");

    public static void main(String[] args) {

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });

        btn.onClick();
    }
}
