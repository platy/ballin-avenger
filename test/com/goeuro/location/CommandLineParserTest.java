package com.goeuro.location;

import com.goeuro.location.CommandLineParser;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandLineParserTest {
    @Test public void parseSingleString() {
        CommandLineParser p = newCommandLineParser("STRING");
        assertThat(p.isValid(), is(true));
        assertThat(p.getSearchString(), is("STRING"));
    }

    @Test public void parseEmpty() throws Exception {
        CommandLineParser p = newCommandLineParser();
        assertThat(p.isValid(), is(false));
    }

    @Test public void parse2Strings() throws Exception {
        CommandLineParser p = newCommandLineParser("one", "two");
        assertThat(p.isValid(), is(false));
    }

    private CommandLineParser newCommandLineParser(String... args) {
        return new CommandLineParser(args);
    }
}
