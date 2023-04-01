package tests;

import Specifications.SpecificationsClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojoClasses.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private final static String URL = "https://reqres.in/";


    @Test
    public void checkUsers() {
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(200));
        List<UserClass> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserClass.class);

        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }

    @Test
    public void checkUser() {
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(200));
        Data user = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract()
                .body()
                .as(Root.class)
                .getData();

        Assertions.assertEquals("Janet", user.getFirst_name());

    }

    @Test
    public void createUserTest() {
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(201));
        String name = "test";
        String job = "test";
        Create user = new Create("name", "job");
        SuccessCreate successCreate = given()
                .body(user)
                .when()
                .post("api/users/2")
                .then().log().all()
                .extract().as(SuccessCreate.class);

        System.out.println(successCreate.getName());
    }


}
