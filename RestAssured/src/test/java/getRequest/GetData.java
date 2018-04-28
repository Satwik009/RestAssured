package getRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetData {

	@Test
	public void testResponsecode()
	{
	
		Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
	ResponseBody body =   resp.getBody();

		this.fileWriter(body.prettyPrint());
	}
	
	 public static void fileWriter(String data){    
         try{   
        	 File file = new File("/Users/satwik/Documents/Workspace/RestAssured/Response.txt");
        long length=	 file.length();
        System.out.println(length);
        if(length==0)
        {
        	FileWriter fw=new FileWriter("/Users/satwik/Documents/Workspace/RestAssured/Response.txt");    
            fw.write(data);    
            fw.close();    
           }
        else
        {
        	file.delete();
        	file.createNewFile();
        	FileWriter fw=new FileWriter("/Users/satwik/Documents/Workspace/RestAssured/Response.txt");    
           fw.write(data);    
            fw.close();  
        }
         }
        catch(Exception e)
        {System.out.println(e);}    
           System.out.println("Success...");    
	 }     
}
