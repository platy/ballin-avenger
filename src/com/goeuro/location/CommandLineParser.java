package com.goeuro.location;

class CommandLineParser {

    private boolean valid = false;
    private String searchString;

    CommandLineParser(String[] args) {
        if(args.length == 1) {
            searchString = args[0];
            valid = true;
        }
    }

    boolean isValid() {
        return valid;
    }

    String getSearchString() {
        return searchString;
    }
}
