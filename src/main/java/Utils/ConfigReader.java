package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    private final String propertyFilePath= "./src/test/resources/config.properties";

    public ConfigReader(){
        FileInputStream fis;
        try {
            fis = new FileInputStream(propertyFilePath);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }
    public String getBaseURI(){
        String baseURI = prop.getProperty("baseURI");
        if(baseURI!= null) return baseURI.trim();
        else throw new RuntimeException("baseURI is not specified in the config.properties file.");
    }
    public String getKey(){
        String key = prop.getProperty("key");
        if(key!= null) return key.trim();
        else throw new RuntimeException("key is not specified in the config.properties file.");
    }
    public String getGetResource(){
        String putcallresource = prop.getProperty("putcallresource");
        if(putcallresource!= null) return putcallresource.trim();
        else throw new RuntimeException("putcallresource is not specified in the config.properties file.");
    }
    public String getDeleteCall(){
        String deleteCall= prop.getProperty("deleteCall");
        if(deleteCall!= null) return deleteCall.trim();
        else throw new RuntimeException("baseURI1 is not specified in the config.properties file.");
    }
    public String getGET(){
        String resource1= prop.getProperty("resource1");
        if(resource1!= null) return resource1.trim();
        else throw new RuntimeException("resource1 is not specified in the config.properties file.");
    }
    public String getFile2(){
        String file2= prop.getProperty("file2");
        if(file2!= null) return file2.trim();
        else throw new RuntimeException("file2 is not specified in the config.properties file.");
    }
    public String getSheet2(){
        String sheet2= prop.getProperty("sheet2");
        if(sheet2!= null) return sheet2.trim();
        else throw new RuntimeException("sheet2 is not specified in the config.properties file.");
    }

    public String getPostResource(){
        String postResource = prop.getProperty("postResource");
        if(postResource!= null) return postResource.trim();
        else throw new RuntimeException("postResource is not specified in the config.properties file.");
    }
    public String getSuccessStatus(){
        String Status = prop.getProperty("Status");
        if(Status!= null) return Status.trim();
        else throw new RuntimeException("Status is not specified in the config.properties file.");

    }

    public String getTestDataFilePath(){
        String testDataFilePath = prop.getProperty("testDataFilePath");
        if(testDataFilePath!= null) return testDataFilePath.trim();
        else throw new RuntimeException("testDataFilePath is not specified in the config.properties file.");
    }
    public String getTestDataFileName(){
        String testDataFileName = prop.getProperty("testDataFileName");
        if(testDataFileName!= null) return testDataFileName.trim();
        else throw new RuntimeException("testDataFileName is not specified in the config.properties file.");
    }
    public String getTestDataSheetName(){
        String testDataSheetName = prop.getProperty("testDataSheetName");
        if(testDataSheetName!= null) return testDataSheetName.trim();
        else throw new RuntimeException("testDataSheetName is not specified in the config.properties file.");
    }
    public String getTestDataFileName1(){
        String testDataFileName1 = prop.getProperty("testDataFileName1");
        if(testDataFileName1!= null) return testDataFileName1.trim();
        else throw new RuntimeException("testDataFileName1 is not specified in the config.properties file.");
    }
    public String getTestDataSheetName1(){
        String testDataSheetName1 = prop.getProperty("testDataSheetName1");
        if(testDataSheetName1!= null) return testDataSheetName1.trim();
        else throw new RuntimeException("testDataSheetName1 is not specified in the config.properties file.");
    }
    public Long getResponseTime(){
        Long time= Long.valueOf(prop.getProperty("time"));
        if(time!=null) return time.longValue();
        else throw new RuntimeException("time not found");

    }
}
