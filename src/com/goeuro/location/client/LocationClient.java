package com.goeuro.location.client;

import com.goeuro.location.Result;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.Collections2;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;

public class LocationClient {
    private final HttpRequester requester;

    public LocationClient(HttpRequester requester) {
        this.requester = requester;
    }

    public Collection<Result> requestLocation(String locationString) {
        URL url = getURL(locationString);
        final String responseString = requester.get(url);
        Collection<ResultJson> resultJsons = new Gson().fromJson(responseString, ResultsJson.class).results;
        return Collections2.transform(resultJsons, TRANSFORM_FROM_JSON);
    }

    private URL getURL(String urlString) {
        try {
            return new URI("https", "api.goeuro.com", "/api/v1/suggest/position/en/name/" + urlString, null).toURL();
        } catch (MalformedURLException e) {
            throw Throwables.propagate(e);
        } catch (URISyntaxException e) {
            throw Throwables.propagate(e);
        }
    }

    private static final Function<ResultJson,Result> TRANSFORM_FROM_JSON = new Function<ResultJson, Result>() {
        @Override
        public Result apply(ResultJson resultJson) {
            return new Result.ResultBuilder()
                    .set_id(resultJson._id)
                    .set_type(resultJson._type)
                    .setType(resultJson.type)
                    .setName(resultJson.name)
                    .setLatitude(resultJson.geo_position.latitude)
                    .setLongitude(resultJson.geo_position.longitude)
                    .createResult();
        }
    };

}
