package om.lp.challnges.challenge1;

import java.util.Arrays;

public class Line extends MapObject {

    private final double[][] locations;

    public Line(String name, String type, String... locations) {
        super(name, type);
        this.locations = Arrays.stream(locations)
                .map(MapObject::stringToLatLon)
                .toArray(double[][]::new);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE " + "(" + getLocations() + ")");
    }

    private String getLocations() {
        return Arrays.deepToString(locations);
    }
}
