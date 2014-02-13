package com.goeuro.location;

import com.google.common.base.Throwables;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class GoEuroSSLUtil {

    /**
     * Gets an SSLSocketFactory including the goeuro certificate
     */
    public static SSLSocketFactory getGoEuroSSLSocketFactory() {
        try {
            KeyStore defaultKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            defaultKeyStore.load(null, "".toCharArray());
            defaultKeyStore.setCertificateEntry("alias", getGoEuroCertificate());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(defaultKeyStore);

            SSLContext ctx = SSLContext.getInstance("SSL");
            ctx.init(null, trustManagerFactory.getTrustManagers(), null);
            return ctx.getSocketFactory();

        } catch (NoSuchAlgorithmException e) {
            throw Throwables.propagate(e);
        } catch (KeyManagementException e) {
            throw Throwables.propagate(e);
        } catch (CertificateException e) {
            throw Throwables.propagate(e);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        } catch (KeyStoreException e) {
            throw Throwables.propagate(e);
        }
    }

    private static Certificate getGoEuroCertificate() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        return cf.generateCertificate(GoEuroSSLUtil.class.getResourceAsStream("api.goeuro.com"));
    }
}
