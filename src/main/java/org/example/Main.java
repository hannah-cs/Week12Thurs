package org.example;
public class Main {
    public static void main(String[] args) {
        Insert insert = new Insert();
        insert.insertInto("courses", "101, 'Java', 'Introduction to Java'");
        insert.insertInto("themes", "1, 'OOP', 101");
        Delete delete = new Delete();
        delete.deleteFrom("themes", 1);
        Update update = new Update();
        update.updateCourse(101, "SQL", "Intro to SQL");
        update.updateTheme(1, "Databases", 101);
        Display display = new Display();
        display.displayAll("courses");
        display.displayAll("themes");
    }
}