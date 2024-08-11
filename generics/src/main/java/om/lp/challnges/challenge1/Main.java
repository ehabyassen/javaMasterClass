package om.lp.challnges.challenge1;

public class Main {

    public static void main(String[] args) {
        Park[] nationalParks = new Park[]{
                new Park("Yellowstone", "44.4882, -110.5916"),
                new Park("Grand Canyon", "36.0636, -112.1079"),
                new Park("Yosemite", "37.8855, -119.5360")
        };
        Layer<Park> parksLayer = new Layer<>(nationalParks);
        parksLayer.renderLayer();


        River[] rivers = new River[]{
                new River("Mississippi", "34.4234, -24.4353", "43.3254, -26.3454", "32.3455, -28.4566"),
                new River("Missouri", "54.7896, -25.2424", "76.3787, -26.3454", "90.4353, -60.6575")
        };
        Layer<River> riversLayer = new Layer<>(rivers);
        riversLayer.addElements(new River[]{
                new River("Colorado", "17.4234, -70.4353", "19.3254, -60.3454", "20.3455, -50.4566"),
                new River("Delaware", "11.4234, -20.4353", "12.3254, -30.3454", "13.3455, -40.4566")
        });
        riversLayer.addElement(new River("Dyson", "23.1231, -54.1233", "32.4564, -98.4353", "12.5354, -80.3243"));
        riversLayer.renderLayer();
    }
}
