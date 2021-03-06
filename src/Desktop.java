public class Desktop extends Item {
    private int memorySize;
    private int ssdCapacity;

    public Desktop(String category, String type, String id, String brand, String cpuFamily, int memorySize, int ssdCapacity, int price){
        this.setCategory(category);
        this.setType(type);
        this.setId(id);
        this.setBrand(brand);
        this.setCpuFamily(cpuFamily);
        this.memorySize = memorySize;
        this.ssdCapacity = ssdCapacity;
        this.setPrice(price);
    }

    public int getMemorySize() {
        return memorySize;
    }

    @Override
    public double getScreenSize() {
        return 0;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }
}
