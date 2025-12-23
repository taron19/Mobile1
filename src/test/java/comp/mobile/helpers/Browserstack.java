package comp.mobile.helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoURL(String sessionID) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionID);

        return given()
                .auth().basic(System.getProperty("username"), System.getProperty("accessKey"))
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");

    }
}
