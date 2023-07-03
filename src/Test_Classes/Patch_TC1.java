package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_Method.Patch_API_Method;
import Request_Repository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	@Test
	public static void extractor() 
	{
		int statusCode = Patch_API_Method.ResponsestatusCode(
		Patch_Req_Repository.baseURI(),
		Patch_Req_Repository.Patch_Resource(),
		Patch_Req_Repository.Patch_Req_TC1());
		System.out.println(statusCode);
		
		String ResponseBody =Patch_API_Method.ResponseBody (
		Patch_Req_Repository.baseURI(),
		Patch_Req_Repository.Patch_Resource(),
		Patch_Req_Repository.Patch_Req_TC1());
		System.out.println(ResponseBody);
		
		JsonPath JspResponse =new JsonPath(ResponseBody);
		String patch_res_name=JspResponse.getString("name");
		String patch_res_job=JspResponse.getString("job");
		
		
		Assert.assertEquals(patch_res_name, "morpheus");
		Assert.assertEquals(patch_res_job, "zion resident");
	}
}
