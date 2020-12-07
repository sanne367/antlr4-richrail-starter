package richrail.domain;

import java.util.*;

public class Train implements Iterable<Wagon> {
    private String name;
    private Map<Integer, Wagon> wagons = new HashMap<>();

    public Train(String name) {
        this.name = name;
    }

    public Train(String name, Map<Integer, Wagon> wagons) {
        this.name = name;
        this.wagons = wagons;
    }

    public void add(Wagon wagon) {
        this.wagons.put(wagon.getId(), wagon);
    }

    public void remove(int index) {
        this.wagons.remove(index);
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Wagon> iterator() {
        return this.wagons.values().iterator();
    }
}
