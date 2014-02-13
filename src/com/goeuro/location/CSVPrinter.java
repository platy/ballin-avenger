package com.goeuro.location;

import java.io.PrintStream;

public class CSVPrinter {
    private final PrintStream writer;

    public CSVPrinter(PrintStream out) {
        writer = out;
        writer.println("_type, _id, name, type, latitude, longitude");
    }

    public void flush() {
        writer.flush();
    }


    public void write(Result res) {
        writer.format("\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\"",
                res._type, res._id, res.name, res.type, res.latitude, res.longitude);
        writer.println();
    }
}
