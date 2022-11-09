package automation.services.core;

import automation.core.PropertyReader;
import automation.services.dto.ValCurs;
import automation.services.dto.Valute;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BNMAction {
    public static double getValueFromBNM(String charcode, String date) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl") + date);

        CloseableHttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String fullresponse = "";
        String line = "";

        while ((line = rd.readLine()) != null) {
            fullresponse += line + "\r\n";
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(ValCurs.class);
        xStream.processAnnotations(Valute.class);

        xStream.addPermission(AnyTypePermission.ANY);
        xStream.addImplicitCollection(ValCurs.class, "valutes", Valute.class);
        ValCurs valCurs = (ValCurs) xStream.fromXML(fullresponse);

        double valueFromBNM = 0d;
        for (Valute valute : valCurs.getValutes()) {
            if(valute.getCharCode().equals(charcode)){
                valueFromBNM = valute.getValue();
            }
        }

        return valueFromBNM;
    }
}
