package Lesson1;

import Lesson1.Entity;

public interface Creatable<T extends Entity> {
    T create();
}
