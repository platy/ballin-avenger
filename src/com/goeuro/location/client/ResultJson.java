package com.goeuro.location.client;

class ResultJson {
    public final String _type;
    public final String _id;
    public final String name;
    public final String type;
    public final GeoPosition geo_position;

    public ResultJson(String type, String id, String name, String type1, GeoPosition geo_position) {
        _type = type;
        _id = id;
        this.name = name;
        this.type = type1;
        this.geo_position = geo_position;
    }

    public static class GeoPosition {
        public final String latitude;
        public final String longitude;

        public GeoPosition(String latitude, String longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
