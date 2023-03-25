package utility;
import java.io.IOException;
import java.util.Properties;

public class utility {

    public static Properties pro;

    public void testSetup() {
        //RestAssured.useRelaxedHTTPSValidation();
        String propFileName="config.properties";
        pro= new Properties();
        try {
            pro.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
        System.out.println("Hello");
    }

}
