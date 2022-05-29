public class Laptop extends Desktop{
    private double screenSize;

    public Laptop(String category, String type, String id, String brand, String cpuFamily, int memorySize, int ssdCapacity, double screenSize, int price) {
        super(category, type, id, brand, cpuFamily, memorySize, ssdCapacity, price);
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
}
