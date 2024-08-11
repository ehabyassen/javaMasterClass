package om.lp.challnges.challenge1;

import java.util.Arrays;

public class Point extends MapObject {

    private final double[] location;

    public Point(String name, String type, String location) {
        super(name, type);
        this.location = stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT " + "(" + getLocation() + ")");
    }

    private String getLocation() {
        return Arrays.toString(location);
    }
}
