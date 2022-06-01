public class Tablet extends Item{
    private double screenSize;

    public double getScreenSize() {
        return screenSize;
    }

    public Tablet(String category, String type, String id, String brand, String cpuFamily, double screenSize, int price) {
        this.setCategory(category);
        this.setType(type);
        this.setId(id);
        this.setBrand(brand);
        this.setCpuFamily(cpuFamily);
        this.screenSize = screenSize;
        this.setPrice(price);
    }

    @Override
    public int getMemorySize() {
        return 0;
    }

    @Override
    public int getSsdCapacity() {
        return 0;
    }
}
