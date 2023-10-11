package org.goldenalf.springcourse.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "name not empty")
    @Size(min = 2, max = 35, message = "Имя должно быть между 2 и 35 символами")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Возраст должен быть положительным числом")
    private int age;

    @Email
    @NotEmpty(message = "email не может быть пустым")
    @Column(name = "email")
    private String email;

    //Страна, Город, 123456 <- индекс шесть цифр
    @Pattern(regexp = "[А-ЯЁ|A-Z][а-яё|\\w]+, [А-ЯЁ|A-Z][а-яё|\\w]+, \\d{6}", message = "Ваше сообщение должно быть вида: Страна, Город, индекс (6 цифр)")
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "person")
    private List<Item> itemList;

    public Person() {
    }

    public Person(String name, int age, String email, String address) {
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(email, person.email) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

