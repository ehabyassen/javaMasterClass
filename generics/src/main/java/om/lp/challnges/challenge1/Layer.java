package om.lp.challnges.challenge1;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends MapObject> {

    private final List<T> elements;

    public Layer(T[] elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }

    public void addElements(T[] elements) {
        this.elements.addAll(List.of(elements));
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void renderLayer() {
        elements.forEach(MapObject::render);
    }
}
