package testScripts;
import Model.bookStoreResponse;
import com.google.common.base.Strings;
import controller.bookStoreController;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utility.utility;

import java.util.List;

public class bookStoreApiTest {

    utility obj= new utility();
    String basePath;
    bookStoreController bookStoreController;
    boolean flag;
    public  String className;

    @BeforeSuite(alwaysRun = true)
    void setup(){
        System.out.println("Before test has started");
        className= this.getClass().getSimpleName();
        obj.testSetup();
        bookStoreController= new bookStoreController(className);
    }
    @Test
    void getBookWithISBN() {

        basePath=utility.pro.getProperty("getISBNBasePath");
        String ISBNValue=utility.pro.getProperty("ISBNValue");
        String ISBNQueryParam=utility.pro.getProperty("ISBNQueryParam");
        String resp=bookStoreController.getBookUsingISBN(basePath,ISBNQueryParam,ISBNValue);
        if (!Strings.isNullOrEmpty(resp)){
            JsonPath js = new JsonPath(resp);
            String title= js.get("title");
            System.out.println("The book title is - "+title);
        }else{
            System.out.println("Error stack logged ");
        }
    }

    @Test
    void getAllBooks() {

        basePath=utility.pro.getProperty("getBooksBasePath");
        String resp=bookStoreController.getBooks(basePath);
        if (!Strings.isNullOrEmpty(resp)){
            JsonPath js = new JsonPath(resp);
            List<bookStoreResponse> bookList=js.getList("books", bookStoreResponse.class);
            int resSize= bookList.size();
            if (resSize>0){
                System.out.println("The list of titles being returned by the API:");
                for (bookStoreResponse i:
                     bookList) {
                    System.out.println(i.getTitle());
                }
            }
            else{
                System.out.println("Response list returned is empty.");
            }
        }else{
            System.out.println("Error stack logged ");
        }
    }
}

