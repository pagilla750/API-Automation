package files;

public class payload {
	
	public static String AddPlace() {
		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}";
		
	}
	
	public static String CourseResponse() {
		return "{\r\n"
				+ "\"dashboard\":{\r\n"
				+ "  \"purchaseAmount\":910,\r\n"
				+ "  \"website\":\"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "  \"courses\":[\r\n"
				+ "    {\r\n"
				+ "      \"title\":\"Selenium\",\r\n"
				+ "      \"price\":50,\r\n"
				+ "      \"copies\":6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\":\"Cypress\",\r\n"
				+ "      \"price\":40,\r\n"
				+ "      \"copies\":4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\":\"RPA\",\r\n"
				+ "      \"price\":45,\r\n"
				+ "      \"copies\":10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		
	}
	
}
