package web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotBlank(message = "Имя не может быть пустым")
    @Column(name = "user_name")
    private String name;
    @NotBlank(message = "Фамилия не может быть пустым")
    @Column(name = "user_last_name")
    private String lastName;
    @Positive(message = "Возраст не может быть меньше 0")
    @Column(name = "user_age")
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(@Positive int age) {
        this.age = age;
    }

    public User(@NotBlank String name, @NotBlank String lastName, @Positive int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", age = " + age +
                '}';
    }
}
