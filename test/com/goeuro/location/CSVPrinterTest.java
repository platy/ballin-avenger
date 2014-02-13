package com.goeuro.location;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CSVPrinterTest {
    ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
    PrintStream writer = new PrintStream(out);
    @Test
    public void printsHeaderFields() throws Exception {
        CSVPrinter cp = new CSVPrinter(writer);
        cp.flush();
        assertThat(out.toString("UTF-8"), is("_type, _id, name, type, latitude, longitude\n"));
    }

    @Test
    public void printsResult() throws Exception {
        CSVPrinter cp = new CSVPrinter(writer);
        cp.flush();
        out.reset();
        cp.write(TEST_RESULT);
        cp.flush();
        assertThat(out.toString("UTF-8"), is("\"_type\", \"_id\", \"name\", \"type\", \"lat\", \"long\"\n"));
    }

    private static final Result TEST_RESULT = new Result.ResultBuilder().set_id("_id").set_type("_type").setType("type").setName("name").setLatitude("lat").setLongitude("long").createResult();
}
