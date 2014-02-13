package com.goeuro.location.client;

import java.util.Collection;

class ResultsJson {
    public final Collection<ResultJson> results;

    public ResultsJson(Collection<ResultJson> results) {
        this.results = results;
    }
}
