package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class baseUrl {

    protected static RequestSpecification req;
    @BeforeAll
    public static void setUp(){

        req = new RequestSpecBuilder().
                setBaseUri("https://api.trello.com").
                build();
    }
}
