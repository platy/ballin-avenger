package com.goeuro.location;

public class Result {
    public final String _type;
    public final String _id;
    public final String name;
    public final String type;
    public final String latitude;
    public final String longitude;

    public Result(String _type, String _id, String name, String type, String latitude, String longitude) {
        this._type = _type;
        this._id = _id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static class ResultBuilder {
        private String _type;
        private String _id;
        private String name;
        private String type;
        private String latitude;
        private String longitude;

        public ResultBuilder set_type(String type) {
            this._type = type;
            return this;
        }

        public ResultBuilder set_id(String id) {
            this._id = id;
            return this;
        }

        public ResultBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ResultBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ResultBuilder setLatitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public ResultBuilder setLongitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public Result createResult() {
            return new Result(_type, _id, name, type, latitude, longitude);
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "_type='" + _type + '\'' +
                ", _id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (_id != null ? !_id.equals(result._id) : result._id != null) return false;
        if (_type != null ? !_type.equals(result._type) : result._type != null) return false;
        if (latitude != null ? !latitude.equals(result.latitude) : result.latitude != null) return false;
        if (longitude != null ? !longitude.equals(result.longitude) : result.longitude != null) return false;
        if (name != null ? !name.equals(result.name) : result.name != null) return false;
        if (type != null ? !type.equals(result.type) : result.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _type != null ? _type.hashCode() : 0;
        result = 31 * result + (_id != null ? _id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
