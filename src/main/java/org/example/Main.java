package org.example;
public class Main {
    public static void main(String[] args) {
        Insert insert = new Insert();
        insert.insertInto("courses", "101, 'Java', 'Introduction to Java'");
        insert.insertInto("themes", "1, 'OOP', 101");
    }
}