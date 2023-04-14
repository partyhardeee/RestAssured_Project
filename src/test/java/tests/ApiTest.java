package tests;

import specifications.SpecificationsClass;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojoClasses.request.CreateUser;
import pojoClasses.request.RegisterUser;
import pojoClasses.request.UpdateUser;
import pojoClasses.response.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkUsers() {
        SoftAssertions softAssertions = new SoftAssertions();
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(200));
        List<UserClass> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserClass.class);
        users.forEach(x -> softAssertions.assertThat(x.getAvatar()).contains(x.getId().toString()));
        softAssertions.assertThat(users.stream().allMatch(x->x.getEmail().endsWith("reqres.in"))).isTrue();
        softAssertions.assertAll();
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
    public void createUserByClass() {
        SoftAssertions softAssertions = new SoftAssertions();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(201));
        String name = "test";
        String job = "test";
        CreateUser user = new CreateUser(name, job);
        SuccessCreate successCreate = given()
                .body(user)
                .when()
                .post("api/users")
                .then().log().all()
                .extract().as(SuccessCreate.class);
        softAssertions.assertThat(successCreate.getId()).isNotEmpty();
        softAssertions.assertThat(formatter.format(successCreate.getCreatedAt())).isEqualTo(formatter.format(new Date()));
        softAssertions.assertAll();
    }
    @Test
    public void createUserByMap() {
        SoftAssertions softAssertions = new SoftAssertions();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(201));
        String name = "test";
        String job = "test";
        Map<String, Object> user = new HashMap<>();
        user.put("name" , name);
        user.put("job", job);
        SuccessCreate successCreate = given()
                .body(user)
                .when()
                .post("api/users")
                .then().log().all()
                .extract().as(SuccessCreate.class);
        softAssertions.assertThat(successCreate.getId()).isNotEmpty();
        softAssertions.assertThat(formatter.format(successCreate.getCreatedAt())).isEqualTo(formatter.format(new Date()));
        softAssertions.assertAll();
    }

    @Test
    public void updateUserTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(200));
        String name = "test";
        String job = "test1";
        UpdateUser user = new UpdateUser(name, job);
        Root successUpdate = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(Root.class);
        softAssertions.assertThat(formatter.format(successUpdate.getUpdatedAt())).isEqualTo(formatter.format(new Date()));
        softAssertions.assertAll();
    }

    @Test
    public void registerUserTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(200));
        String email = "eve.holt@reqres.in";
        String password = "pistol";
        RegisterUser register = new RegisterUser(email, password);
        SuccessRegister successRegister = given()
                .body(register)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegister.class);
        softAssertions.assertThat(successRegister.getId()).isEqualTo(id);
        softAssertions.assertThat(successRegister.getToken()).isEqualTo(token);
        softAssertions.assertAll();
    }

    @Test
    public void UnsuccessfulRegisterTest() {
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(400));
        String email = "eve.holt@reqres.in";
        String password = null;
        RegisterUser register = new RegisterUser(email, password);
        UnsuccessfulRegister unsuccessfulRegister = given()
                .body(register)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);
        Assertions.assertEquals(unsuccessfulRegister.getError(), "Missing password");
    }

    @Test
    public void checkUsersWithDelay() {
        SoftAssertions softAssertions = new SoftAssertions();
        SpecificationsClass.installSpecification(SpecificationsClass.requestSpecification(URL), SpecificationsClass.responseSpecification(200));
        List<UserClass> users = given()
                .when()
                .get("api/users?delay=3")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserClass.class);
        users.forEach(x -> softAssertions.assertThat(x.getAvatar()).contains(x.getId().toString()));
        softAssertions.assertThat(users.stream().allMatch(x->x.getEmail().endsWith("reqres.in"))).isTrue();
        softAssertions.assertAll();
    }


}
