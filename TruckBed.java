public class TruckBed {
    private boolean isTruckBedDown;
    private int maxWeight;

    public TruckBed(boolean isTruckBedDown, int maxWeight) {
        this.isTruckBedDown = isTruckBedDown;
        this.maxWeight = maxWeight;
    }

    public int getmaxWeight() {
        return maxWeight;
    }

    public boolean isTruckBedDown() {
        return isTruckBedDown;
    }

    public void setTruckBed(boolean t){
        isTruckBedDown=t;
    }
}
