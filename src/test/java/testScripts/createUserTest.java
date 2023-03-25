package testScripts;

import Model.userRequest;
import Model.userResponse;
import com.google.common.base.Strings;
import controller.userController;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utility.utility;

public class createUserTest {
    utility obj= new utility();
    String basePath;
    userController userController;
    public  String className2;

    @BeforeSuite(alwaysRun = true)
    void setup(){
        System.out.println("Before test has started");
        className2= this.getClass().getSimpleName();
        obj.testSetup();
        userController= new userController(className2);
    }

    @Test
    void createUser() {

        userRequest user= new userRequest(utility.pro.getProperty("userName"),utility.pro.getProperty("userJob") );
        basePath=utility.pro.getProperty("createUserBasePath");
        userResponse resp= userController.createUser(basePath,user);
        System.out.println("POST response result");
        Assert.assertEquals(user.getName(),resp.getName());
        Assert.assertEquals(user.getJob(),resp.getJob());
        System.out.println("ID created: "+resp.getId());
        System.out.println("ID created at: "+resp.getCreatedAt());
    }
}
