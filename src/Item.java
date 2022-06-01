import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class Item {
    private String category;
    private String type;
    private String id;
    private String brand;
    private String cpuFamily;
    private int price;

    private static HashMap<String, Item> items = new HashMap<>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpuFamily() {
        return cpuFamily;
    }

    public void setCpuFamily(String cpuFamily) {
        this.cpuFamily = cpuFamily;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract int getMemorySize();

    public abstract int getSsdCapacity();

    public abstract double getScreenSize();


    public static void addTestItems() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("computers.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                char itemCategory = split[0].charAt(0);
                if (itemCategory == 68) {
                    items.put(split[2], new Desktop(split[0], split[1], split[2], split[3], split[4], Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7])));
                }
                if (itemCategory == 76) {
                    items.put(split[2], new Laptop(split[0], split[1], split[2], split[3], split[4], Integer.parseInt(split[5]), Integer.parseInt(split[6]), Double.parseDouble(split[7]), Integer.parseInt(split[8])));
                }
                if (itemCategory == 84) {
                    items.put(split[2], new Tablet(split[0], split[1], split[2], split[3], split[4], Double.parseDouble(split[5]), Integer.parseInt(split[6])));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addItem(String id, String category, String type, String brand, String cpuFamily, int memorySize, int ssdCapacity, double screenSize, int price) {
        if (items.containsKey(id)) {
            return false;
        } else {
            char itemCategory = category.charAt(0);
            if (itemCategory == 68) {
                items.put(id, new Desktop(category, type, id, brand, cpuFamily, memorySize, ssdCapacity, price));
            }
            if (itemCategory == 76) {
                items.put(id, new Laptop(category, type, id, brand, cpuFamily, memorySize, ssdCapacity, screenSize, price));
            }
            if (itemCategory == 84) {
                items.put(id, new Tablet(category, type, id, brand, cpuFamily, screenSize, price));
            }
            return true;
        }
    }

    public static boolean updateItem(String id, String category, String type, String brand, String cpuFamily, int memorySize, int ssdCapacity, double screenSize, int price) {
        if (items.containsKey(id)) {
            char itemCategory = category.charAt(0);
            if (itemCategory == 68) {
                items.remove(id);
                items.put(id, new Desktop(category, type, id, brand, cpuFamily, memorySize, ssdCapacity, price));
            }
            if (itemCategory == 76) {
                items.remove(id);
                items.put(id, new Laptop(category, type, id, brand, cpuFamily, memorySize, ssdCapacity, screenSize, price));
            }
            if (itemCategory == 84) {
                items.remove(id);
                items.put(id, new Tablet(category, type, id, brand, cpuFamily, screenSize, price));
            }
            return true;
        } else return false;
    }

    public static boolean removeItem(String id) {
        if (items.containsKey(id)) {
            items.remove(id);
            return true;
        } else return false;
    }

    public static String[][] itemToTableFormat() {
        String[][] data = new String[items.size()][6];
        Iterator<Map.Entry<String, Item>> it = items.entrySet().iterator();
        int counter = 0;
        Item currentItem;
        while (it.hasNext()) {
            Map.Entry<String, Item> i = it.next();
            currentItem = i.getValue();
            data[counter][0] = currentItem.getCategory();
            data[counter][1] = currentItem.getType();
            data[counter][2] = currentItem.getId();
            data[counter][3] = currentItem.getBrand();
            data[counter][4] = currentItem.getCpuFamily();
            data[counter][5] = Integer.toString(currentItem.getPrice());
            counter++;
        }

        return data;
    }

    //this method returns a 2d array of data based on filters to display in the table
    public static String[][] filterTable(String category, String type) {
        String[][] data = new String[items.size()][6];
        Iterator<Map.Entry<String, Item>> it = items.entrySet().iterator();
        int counter = 0;
        Item currentItem;

        if (!Objects.equals(category, "All") && Objects.equals(type, "All")) {
            while (it.hasNext()) {
                Map.Entry<String, Item> i = it.next();
                currentItem = i.getValue();
                if (Objects.equals(currentItem.getCategory(), category)) {
                    data[counter][0] = currentItem.getCategory();
                    data[counter][1] = currentItem.getType();
                    data[counter][2] = currentItem.getId();
                    data[counter][3] = currentItem.getBrand();
                    data[counter][4] = currentItem.getCpuFamily();
                    data[counter][5] = Integer.toString(currentItem.getPrice());
                    counter++;
                }
            }
        }
        if (Objects.equals(category, "All") && !Objects.equals(type, "All")) {
            while (it.hasNext()) {
                Map.Entry<String, Item> i = it.next();
                currentItem = i.getValue();//type casting to item to access getter methods
                if (Objects.equals(currentItem.getType(), type)) {
                    data[counter][0] = currentItem.getCategory();
                    data[counter][1] = currentItem.getType();
                    data[counter][2] = currentItem.getId();
                    data[counter][3] = currentItem.getBrand();
                    data[counter][4] = currentItem.getCpuFamily();
                    data[counter][5] = Integer.toString(currentItem.getPrice());
                    counter++;
                }
            }
        }
        if (!Objects.equals(category, "All") && !Objects.equals(type, "All")) {
            while (it.hasNext()) {
                Map.Entry<String, Item> i = it.next();
                currentItem = i.getValue();//type casting to item to access getter methods
                System.out.println("hi");
                if (Objects.equals(currentItem.getType(), type) && Objects.equals(currentItem.getCategory(), category)) {
                    data[counter][0] = currentItem.getCategory();
                    data[counter][1] = currentItem.getType();
                    data[counter][2] = currentItem.getId();
                    data[counter][3] = currentItem.getBrand();
                    data[counter][4] = currentItem.getCpuFamily();
                    data[counter][5] = Integer.toString(currentItem.getPrice());
                    counter++;
                }
            }
        }
        return data;
    }

    public static Item getItemByID(String id) {
        Iterator<Map.Entry<String, Item>> it = items.entrySet().iterator();
        String currentKey;
        Item currentItem;
        while (it.hasNext()) {
            Map.Entry<String, Item> i = it.next();
            currentKey = i.getKey();
            currentItem = i.getValue();
            if (Objects.equals(currentKey, id)) {
                return currentItem;
            }
        }
        //this line is only to make the method valid, should never reach this point
        return new Desktop("1", "2", "3", "4", "5", 6, 7, 8);
    }

    public static void main(String[] args) {
        addTestItems();
        itemToTableFormat();
    }
}
