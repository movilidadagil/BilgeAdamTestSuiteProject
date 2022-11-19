import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BilgeAdamApiTest {
    @Test
    public void testAGetPetById() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/pet/1")
                .asString();
        //Assert.assertEquals("OK",response.getStatusText());
        System.out.println(response.getStatusText());
        //System.out.println(response.getStatusText().equals("Not Found"));
        Assert.assertTrue(response.getStatusText().equalsIgnoreCase("OK"));
        Assert.assertNotEquals(response.getStatusText(),"Not Found");
    }

    @Test
    public void testBGetOrderById() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/order/1")
                .asString();
        Assert.assertEquals("OK",response.getStatusText());
    }

    @Test
    public void testCGetInventoryById() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/inventory")
                .asString();
        Assert.assertEquals("OK",response.getStatusText());

    }
}
