package files;

import io.restassured.path.json.JsonPath;

public class ReUsabelMethods {

		public static JsonPath rawToJson(String resp) {
			JsonPath jp = new JsonPath(resp);
			return jp;
	}

}
