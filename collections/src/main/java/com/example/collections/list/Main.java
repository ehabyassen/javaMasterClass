package com.example.collections.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("ehab", 33, List.of("ahmed", "ali")));
        students.add(new Student("aya", 28, List.of("nada", "ahmed")));
        students.add(new Student("eslam", 21, List.of("nokia", "tarek")));

        List<String> friends = students.stream()
                .filter(s -> s.getAge() > 22)
                .flatMap(s -> s.getFriends().stream())
                .collect(toList());

        System.out.println(friends);



        List<Album> favs = new ArrayList<>();
        favs.add(new Album());

        List<Album> result = favs.stream()
                .filter(a -> a.getTracks().stream().anyMatch(t -> t.getRating() >= 4))
                .sorted(Comparator.comparing(Album::getName))
                .collect(toList());

        

        System.out.println(result);
    }

}

class Album {
    private String name;
    private List<Track> tracks;

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}

class Track {
    private int rating;

    public int getRating() {
        return rating;
    }
}
class Student {
    private String name;
    private int age;

    private List<String> friends;

    public Student(String name, int age, List<String> friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
