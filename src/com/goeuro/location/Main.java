package com.goeuro.location;

import com.goeuro.location.client.HttpRequesterImpl;
import com.goeuro.location.client.LocationClient;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	    CommandLineParser clp = new CommandLineParser(args);
        if(clp.isValid())
            doMain(clp.getSearchString());
        else
            printUsage();
    }

    private static void doMain(String searchString) {
        LocationClient locationClient = new LocationClient(new HttpRequesterImpl(GoEuroSSLUtil.getGoEuroSSLSocketFactory()));
        Collection<Result> results = locationClient.requestLocation(searchString);
        CSVPrinter cp = new CSVPrinter(System.out);
        for (Result result : results)
            cp.write(result);
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar GoEuroTest.jar \"STRING\"");
    }
}
