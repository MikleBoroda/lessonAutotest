package at.study.redmine.model;

import at.study.redmine.utils.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static at.study.redmine.utils.StringUtils.*;


@Getter
@Setter
public class Email extends CreatableEntity implements Creatable<Email> {

    private Integer userid;
    private String address = randomEmail();
    private Boolean isDefault = true;
    private Boolean notify = true;
    Email(User user ){
        this.userid = user.id;
    }
    @Override
    public Email create() {
        //todo: реализовать через базу SQl- запросы
       throw new UnsupportedOperationException();
    }



}
