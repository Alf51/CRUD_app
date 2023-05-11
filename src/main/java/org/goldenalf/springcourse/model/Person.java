package org.goldenalf.springcourse.model;

import jakarta.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "name not empty")
    @Size(min = 2, max = 35, message = "Имя должно быть между 2 и 35 символами")
    private String name;

    @Min(value = 0, message = "Возраст должен быть положительным числом")
    private int age;

    @Email
    @NotEmpty(message = "email не может быть пустым")
    private String email;

    //Страна, Город, 123456 <- индекс шесть цифр
    @Pattern(regexp = "[А-ЯЁ|A-Z][а-яё|\\w]+, [А-ЯЁ|A-Z][а-яё|\\w]+, \\d{6}", message = "Ваше сообщене должно быть вида: Страна, Город, индекс (6 цифр)")
    private String address;

    public Person() {
    }

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
