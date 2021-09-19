package at.study.redmine.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public abstract class CreatableEntity extends Entity {
    protected LocalDateTime createdOn = LocalDateTime.now();
    protected LocalDateTime updatedOn = LocalDateTime.now();
}
