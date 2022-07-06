package io.github.seondongpyo.jdbc.domain;

public class Client {

    private Long id;
    private String name;
    private int age;

    public Client(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
