package ru.job4j.generics;

public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", age=" + age + '}';
    }
}
