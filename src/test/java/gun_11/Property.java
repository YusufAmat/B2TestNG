package gun_11;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {

    //read property file
    @Test
    public void propertyFile() {

        //properties Classina ihtiyac var
        Properties properties = new Properties();   //property nesnesi
        properties.put("username", "myUser");       //nesneye ikili veri eklenir
        properties.put("password", "myPass");       //nesneye ikili veri eklenir

        String user = properties.getProperty("username");
        String pass = properties.getProperty("password");

        System.out.println(user + " , " + pass);

    }

    @Test
    public void readPropertyFromFile() throws IOException {

        Properties properties = new Properties();
        FileReader fileReader = new FileReader("src/test/java/gun_11/configT.properties");
        properties.load(fileReader);

        String url = properties.getProperty("url");
        String user = properties.getProperty("username");
        String pass = properties.getProperty("password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(pass);

        fileReader.close();
    }


}
