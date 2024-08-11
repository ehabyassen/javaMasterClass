package com.lp.interfaces.challenge;

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}""";

    GeometryType getGeometryType();

    String getLabel();

    String getIconType();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getGeometryType(), getLabel(), getIconType());
    }

    static void print(Mappable mappable) {
        System.out.printf((JSON_PROPERTY) + "%n", mappable.toJSON());
    }
}
