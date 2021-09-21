package Lesson1.project;


import Lesson1.CreatableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static Lesson1.StringUtils.randomHexString;

@NoArgsConstructor
@Getter
@Setter
public class Project extends CreatableEntity {

    private String name = randomHexString(10);
    private String description = randomHexString(15);
    private String homepage = randomHexString(10);
    private Boolean isPublic = false;
    private Integer parentId = null; // Id родительского проекта по дефолту NUll
    private String identifier = randomHexString(12);
    private Integer status = 1; // надо ли через enum реализовать??
    private Integer lft = 9;
    private Integer rgt = 10;
    private Boolean inheritMembers = false; //checkBox "Наследовать участников"
    private Integer defaultVersionId = 2; // id из таблицы Version
    private Integer defaultAssignedToId = 26472; // непонятное поле


}
