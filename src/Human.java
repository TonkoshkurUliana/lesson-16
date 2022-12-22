import java.util.Objects;

public class Human {
    private String name;
    private String lastName;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && name.equals(human.name) && lastName.equals(human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age);
    }

    public String name() {
        return name;
    }

    public Human setName(String name) {
        this.name = name;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public Human setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int age() {
        return age;
    }

    public Human setAge(int age) {
        this.age = age;
        return this;
    }

    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public void myMethod(String a) {
        this.name = a;
    }
}
