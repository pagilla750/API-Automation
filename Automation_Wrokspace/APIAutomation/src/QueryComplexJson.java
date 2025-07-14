import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class QueryComplexJson {

	public static void main(String[] args) {
		
		JsonPath jp = new JsonPath(payload.CourseResponse());
		
//		Print No of courses returned by API
		System.out.println("Print No of courses returned by API "+jp.get("courses.size()"));
		
//		2.Print Purchase Amount
		System.out.println("Print Purchase Amount "+ jp.get("dashboard.purchaseAmount"));

//		3. Print Title of the first course
//		System.out.println("3. Print Title of the first course "+ js.get("courses(0).title"));
		
//		4. Print All course titles and their respective Prices
		int count = jp.getInt("courses.size()");
		
		for(int i=0;i<count;i++) {			
			System.out.println("Course Name "+jp.get("courses["+i+"].title")+" and Course Prise is "+jp.get("courses["+i+"].price"));			
		}

//		5. Print no of copies sold by RPA Course
		
		for(int i=0;i<count;i++) {	
			if(jp.get("courses["+i+"].title").toString().equalsIgnoreCase("rpa")) {
				System.out.println("Course Name "+jp.get("courses["+i+"].title")+" and no of copies sold is "+jp.get("courses["+i+"].copies"));	
				break;
			}			
		}
		
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		int TotalCoursePrice = 0;
		int TotalPurchasePrice = jp.get("dashboard.purchaseAmount");		
		for(int i=0;i<count;i++) {		
			int coursePrice = jp.getInt("courses["+i+"].price");
			int numberofcopies = jp.getInt("courses["+i+"].copies");
			int coursetotal = coursePrice*numberofcopies;
			TotalCoursePrice = TotalCoursePrice + coursetotal;
		} Assert.assertEquals(TotalPurchasePrice, TotalCoursePrice, "Fail");
		
		
		
		
		
	}

}
