package FrameWrokTesting.APITesting;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWrokTesting.APIUtilities.dummyResponses;
import io.restassured.path.json.JsonPath;

public class responseValidation extends dummyResponses {
	
	@Test
	public void checkCourse() {
		SoftAssert softAssert = new SoftAssert(); //initialization of Soft Assert
		
		JsonPath js = new JsonPath(getFirstResponse());
		
		//Print No of courses returned by API
		int courseCount = js.getInt("courses.size()");		
		softAssert.assertEquals(courseCount, 3);
		
		//Print Purchase Amount
		String purchaseAmmount = js.getString("dashboard.purchaseAmount").toString();
		softAssert.assertEquals(purchaseAmmount, "910");
		
		//Print Title of the first course
		String firstCourseTitle = js.getString("courses[0].title").toString();
		softAssert.assertEquals(firstCourseTitle, "Selenium Python");
		
		//Print All course titles and their respective Prices
		StringBuilder build = new StringBuilder();
		for(int i = 0 ; i<courseCount;i++ ) {
			
			String courseTitle = js.getString("courses["+i+"].title").toString();
			String coursePrice = js.getString("courses["+i+"].price").toString();
			build.append(courseTitle).append(" : ").append(coursePrice).append(" || ");
			
						
		}
		System.out.println(build);
		
		//Print no of copies sold by RPA Course
		int copiesSold = 0;
		for (int j = 0 ; j<courseCount; j++) {
			String title = js.getString("courses["+j+"].title").toString();
			if (title.equalsIgnoreCase("RPA")) {
				 copiesSold = js.getInt("courses["+j+"].copies"); 
				 break;
			}
		}
		
		softAssert.assertEquals(copiesSold, 10);
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		int ammount=0; 
		int price = 0;
		int total = 0;		
		for (int k = 0 ; k<courseCount; k++) {
			
			ammount = js.getInt("courses["+k+"].copies")* js.getInt("courses["+k+"].price");
			total += ammount;
		}
		
			softAssert.assertEquals(total, 910);
			
			
		}
		
	}
	


