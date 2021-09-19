package at.study.redmine.model;

import at.study.redmine.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

import static at.study.redmine.utils.StringUtils.randomHexString;

@Getter
@Setter
public class Token extends CreatableEntity implements Creatable<Token> {

    private Integer userid;
    private TokenType action = TokenType.API; //api || feeds || session
    private String value = randomHexString(16);

    Token(User user) {
        this.userid = user.id;
    }

    @Override
    public Token create() {
        //todo: реализовать через базу SQl- запросы
        return null;
    }


    public enum TokenType {
        API,
        FEEDS,
        SESSION
    }
}
