package com.goeuro.location.client;

import com.google.common.base.Throwables;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequesterImpl implements HttpRequester {

    private SSLSocketFactory sslSocketFactory;

    public HttpRequesterImpl(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    @Override
    public String get(URL url) {
        HttpsURLConnection conn = null;
        try {
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(sslSocketFactory);
            assert(conn.getResponseCode() == 200);
            return IOUtils.toString(conn.getInputStream(), "UTF-8");
        } catch (IOException e) {
            throw Throwables.propagate(e);
        } finally {
            closeConnection(conn);
        }
    }

    private void closeConnection(HttpURLConnection conn) {
        if(conn != null) {
            conn.disconnect();
        }
    }
}
