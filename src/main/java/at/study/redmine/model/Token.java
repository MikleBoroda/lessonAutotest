package at.study.redmine.model;

import at.study.redmine.db.requests.TokenRequests;
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

    public Token(User user) {
        this.userid = user.id;
        user.getTokens().add(this);
    }

    @Override
    public Token create() {
        new TokenRequests().create(this);
        return this;
    }


    public enum TokenType {
        API,
        FEEDS,
        SESSION
    }
}
