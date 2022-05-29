import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Item {
    private String category;
    private String type;
    private String id;
    private String brand;
    private String cpuFamily;
    private int price;

    private static ArrayList<Item> items = new ArrayList<>();

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

    public static void addTestItems(){
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("computers.txt"), StandardCharsets.UTF_8))){
            String line;
            while((line=br.readLine())!=null){
                String[] split=line.split(",");
                char itemCategory = split[0].charAt(0);
                if(itemCategory == 68){
                    items.add(new Desktop(split[0],split[1],split[2],split[3],split[4],Integer.parseInt(split[5]),Integer.parseInt(split[6]),Integer.parseInt(split[7])));
                }
                if(itemCategory == 76){
                    items.add(new Laptop(split[0],split[1],split[2],split[3],split[4],Integer.parseInt(split[5]),Integer.parseInt(split[6]),Double.parseDouble(split[7]),Integer.parseInt(split[8])));
                }
                if(itemCategory == 84){
                    items.add(new Tablet(split[0],split[1],split[2],split[3],split[4],Double.parseDouble(split[5]),Integer.parseInt(split[6])));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] itemToTableFormat(){
        String data[][] = new String[items.size()][6];
        for (int i = 0; i < items.size(); i++) {
            data[i][0] = items.get(i).getCategory();
            data[i][1] = items.get(i).getType();
            data[i][2] = items.get(i).getId();
            data[i][3] = items.get(i).getBrand();
            data[i][4] = items.get(i).getCpuFamily();
            data[i][5] = String.valueOf(items.get(i).getPrice());
        }
        return data;
    }

    public static void main(String[] args) {
        addTestItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
}
