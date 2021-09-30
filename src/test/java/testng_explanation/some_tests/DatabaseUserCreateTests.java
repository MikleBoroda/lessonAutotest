package testng_explanation.some_tests;

import at.study.redmine.model.Email;
import at.study.redmine.model.Token;
import at.study.redmine.model.User;
import at.study.redmine.model.user.Status;
import org.testng.annotations.Test;

import java.util.Random;

public class DatabaseUserCreateTests {
    @Test
    public void userDatabaseCreationTests() {
        User user = new User();
        user.setPassword("qazWSXedc");
        user.setFirstName("Имя" + new Random().nextInt(100));
        user.setLastName("Фамилия" + new Random().nextInt(100));

        Token token = new Token(user);
        token.setAction(Token.TokenType.API);

        Email email1 = new Email(user);
        Email email2 = new Email(user);
        email2.setIsDefault(false);
        Email email3 = new Email(user);
        email3.setIsDefault(false);
        Email email4 = new Email(user);
        email4.setAddress("ManualTesterMixa@SDET.ru");
        email4.setIsDefault(false);

        user.create();

        System.out.println(user.getLogin());
        System.out.println(token.getValue());
        System.out.println(email1.getAddress());
        System.out.println(email2.getAddress());
        System.out.println(email3.getAddress());


    }
}
