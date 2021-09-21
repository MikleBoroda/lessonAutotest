package Lesson1.project;

public interface Creatable<T extends Entity> {
    T create();
}
