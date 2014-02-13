package com.goeuro.location.client;

import com.goeuro.location.Result;
import org.junit.Test;

import java.net.URL;
import java.util.Collection;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LocationClientTest {

    HttpRequester requester = mock(HttpRequester.class);
    LocationClient client = new LocationClient(requester);

    @Test
    public void constructsUrlCorrectly() throws Exception {
        try {
            client.requestLocation("string");
        } catch (Exception e) {}
        verify(requester).get(new URL("https://api.goeuro.com/api/v1/suggest/position/en/name/string"));
    }

    @Test
    public void encodesSpaceCorrectly() throws Exception {
        try {
            client.requestLocation("string with space");
        } catch (Exception e) {}
        verify(requester).get(new URL("https://api.goeuro.com/api/v1/suggest/position/en/name/string%20with%20space"));
    }

    @Test
    public void decodesResult() throws Exception {
        when(requester.get(any(URL.class))).thenReturn(testJson);
        Collection<Result> results = client.requestLocation("something");
        assertThat(results, containsInAnyOrder(
                new Result.ResultBuilder()
                        .set_id("410978").set_type("Position").setName("Potsdam, USA").setType("location")
                        .setLatitude("44.66978").setLongitude("-74.98131").createResult(),
                new Result.ResultBuilder()
                        .set_id("377078").set_type("Position").setName("Potsdam, Deutschland").setType("location")
                        .setLatitude("52.39886").setLongitude("13.06566").createResult()
        ));
    }

    private final String testJson = "{\n" +
            " \"results\" : [ {\n" +
            " \"_type\" : \"Position\",\n" +
            " \"_id\" : 410978,\n" +
            " \"name\" : \"Potsdam, USA\",\n" +
            " \"type\" : \"location\",\n" +
            " \"geo_position\" : {\n" +
            " \"latitude\" : 44.66978,\n" +
            " \"longitude\" : -74.98131\n" +
            " }\n" +
            " }, {\n" +
            " \"_type\" : \"Position\",\n" +
            " \"_id\" : 377078,\n" +
            " \"name\" : \"Potsdam, Deutschland\",\n" +
            " \"type\" : \"location\",\n" +
            " \"geo_position\" : {\n" +
            " \"latitude\" : 52.39886,\n" +
            " \"longitude\" : 13.06566\n" +
            " }\n" +
            " } ]\n" +
            "}";
}
