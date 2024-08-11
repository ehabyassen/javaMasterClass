package om.lp.challnges.challenge1;

public abstract class MapObject {

    private final String name;

    private final String type;

    public MapObject(String name, String type) {
        this.name = name;
        this.type = type;
    }

    protected static double[] stringToLatLon(String locationStr) {
        String[] latLonPair = locationStr.split(", ");
        double lat = Double.parseDouble(latLonPair[0]);
        double lon = Double.parseDouble(latLonPair[1]);
        return new double[]{lat, lon};
    }

    abstract void render();

    @Override
    public String toString() {
        return name + " " + type;
    }
}
