package com.goeuro.location.client;

import com.goeuro.location.GoEuroSSLUtil;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HttpRequesterImplTest {
    @Test
    public void requestToServerSucceeds() throws Exception {
        HttpRequesterImpl requester = new HttpRequesterImpl(GoEuroSSLUtil.getGoEuroSSLSocketFactory());
        String result = requester.get(new URL("https://api.goeuro.com/api/v1/suggest/position/en/name/STRING"));
        assertThat(result , is("{\"results\":[]}"));
    }
}
