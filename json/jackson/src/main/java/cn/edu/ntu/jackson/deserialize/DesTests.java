package cn.edu.ntu.jackson.deserialize;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author asd <br>
 * @create 2021-11-25 10:40 AM <br>
 * @project json <br>
 */
public class DesTests {
    public static void main(String[] args) {
        String jsonMessage =
                ""
                        + "{"
                        + "   \"Activity\": [{ "
                        + "       \"ActivityLocation\": { "
                        + "           \"Address\": { "
                        + "               \"City\": \"Hana\", "
                        + "               \"StateProvinceCode\": \"Hi\", "
                        + "               \"CountryCode\": \"US\" "
                        + "           } "
                        + "       } "
                        + "   }, "
                        + "   { "
                        + "       \"ActivityLocation\": { "
                        + "           \"Address\": { "
                        + "               \"City\": \"Honolulu\", "
                        + "               \"StateProvinceCode\": \"Hi\", "
                        + "               \"CountryCode\": \"US\" "
                        + "           } "
                        + "       } "
                        + "   }] "
                        + "} ";

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            Shipment shipment = mapper.readValue(jsonMessage, Shipment.class);
            System.out.println("shipment.toString = " + shipment.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
