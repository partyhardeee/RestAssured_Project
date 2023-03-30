package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojoClasses.Data;
import pojoClasses.Root;
import pojoClasses.UserClass;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private final static String URL = "https://reqres.in/";


    @Test
    public void checkUsers() {
        List<UserClass> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserClass.class);

        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }

    @Test
    public void checkUser() {
        Data user = given()
                .when()
                .get(URL + "api/users/2")
                .then().log().all()
                .extract()
                .body()
                .as(Root.class)
                .getData();

        Assertions.assertEquals("Janet", user.getFirst_name());

    }


}
