import java.util.*;

public class CarInventory <T extends Car> {
    private int capacity;
    private List<T> inventory = new ArrayList<>(capacity);;

    public CarInventory(int capacity) {
    this.capacity = capacity;
    }

    public void add(T car){
        inventory.add(car);
    }
    public void remove(T car) {
        inventory.remove(car);
    }
    public List<T> getInventory() {
        return inventory;
    }
    public int getCapacity() {return capacity;}

}
