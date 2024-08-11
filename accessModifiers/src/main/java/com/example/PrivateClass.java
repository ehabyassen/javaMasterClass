package com.example;

public class PrivateClass {

    private String name;

    public PrivateClass(String name) {
        this.name = name;
    }

    public void printOuterClassName() {
        System.out.println(name);
    }

    public void printInnerClassName() {
        new InnerClass().printName();
    }

    public class InnerClass {

        private String name = "B";


        public void printName() {
            System.out.println(PrivateClass.this.name);
        }
    }
}
