package Lesson1.role;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TimeEntriesVisibility {
    ALL("Все трудозатраты"),
    OWN("Только собственные трудозатраты");
    public final String description;
}
