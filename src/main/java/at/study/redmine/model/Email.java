package at.study.redmine.model;

import at.study.redmine.db.requests.EmailRequests;
import at.study.redmine.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import static at.study.redmine.utils.StringUtils.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Email extends CreatableEntity implements Creatable<Email> {

    private Integer userid;
    private String address = randomEmail();
    private Boolean isDefault = true;
    private Boolean notify = true;

    public Email(User user) {
        this.userid = user.id;
        user.getEmails().add(this);

    }

    @Override
    public Email create() {
        new EmailRequests().create(this);
        return this;
    }


}
