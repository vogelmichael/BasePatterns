package main.java.basePattern.plugin;

import main.java.basePattern.gateway.SalesTaxMockGateway;
import main.java.basePattern.gateway.SalesTaxAPIGateway;
import main.java.basePattern.taxSystem.ISalesTaxService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SalesTaxGatewayFactory {

    private String _propFileName;
    private InputStream _inputStream;

    public SalesTaxGatewayFactory() {
        this._propFileName = ".\\src\\main\\resources\\config.properties";
    }

    public ISalesTaxService getSalesTaxService(String currentEnvironment) throws IOException, ClassNotFoundException {

        try{
            Properties prop = new Properties();
            _inputStream = new FileInputStream(_propFileName);

            if(_inputStream != null) {
                prop.load(_inputStream);
            }else {
                throw new FileNotFoundException("Properties file not found");
            }

            String classToLoad = prop.getProperty(currentEnvironment);
            if (SalesTaxAPIGateway.class.toString().split(" ")[1].equals(classToLoad)){
                return new SalesTaxAPIGateway();

            }else if(SalesTaxMockGateway.class.toString().split(" ")[1].equals(classToLoad)){
                return new SalesTaxMockGateway();
            }
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }finally {
            if(_inputStream != null)
                _inputStream.close();
        }
        throw new ClassNotFoundException("Class not found!");
    }
}
