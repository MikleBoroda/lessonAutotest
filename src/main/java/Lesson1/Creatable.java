package Lesson1;

public interface Creatable<T extends Entity> {
    T create();
}
