import javax.swing.*;
import java.awt.*;

public class Products {
    Products()
    {
        //Create the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create browsing panel
        JPanel browseTab = new JPanel();

        //create table panel
        JPanel tablePanel = new JPanel(new BorderLayout());

        //add data to the table
        String data[][] = Item.itemToTableFormat();
        String column[] = {"Category", "Type", "ID", "Brand", "CPU Family", "Price($)"};
        JTable table = new JTable(data,column);
        tablePanel.add(table, BorderLayout.CENTER);
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        table.setDefaultEditor(Object.class, null); //disables editing within the table


        //create the sorting panel
        JPanel sortPanel = new JPanel();
        JPanel categoryPanel = new JPanel();
        JPanel typePanel = new JPanel();
        //labels for sorting dropdown menus
        JLabel categoryLabel = new JLabel("Computer Category");
        JLabel typeLabel = new JLabel("Computer Type");
        //options for categories
        String[] categoryOptions = {"All","Desktop PC", "Laptop", "Tablet"};
        JComboBox<String> categoryChooser = new JComboBox<>(categoryOptions);
        //options for types
        String[] typeOptions = {"","Gaming","Apple","Business","Home & Study","Compact","Thin & Light","Android","Windows"};
        JComboBox<String> typeChooser = new JComboBox<>(typeOptions);
        //adding everything to the sort panel
        categoryPanel.add(categoryLabel);
        typePanel.add(typeLabel);
        categoryPanel.add(categoryChooser);
        typePanel.add(typeChooser);

        //add the category and type panels to the sort panel
        sortPanel.add(categoryPanel);
        sortPanel.add(typePanel);

        //add the sort panel to the browse panel
        browseTab.add(sortPanel);
        //add the table panel to the browse panel table
        browseTab.add(tablePanel);

        //Create panel 2
        JPanel detailTab = new JPanel();

        //Create the tab container
        JTabbedPane tabs = new JTabbedPane();
        //Set tab container position
        tabs.setBounds(10,0,500,1500);
        //Associate each panel with the corresponding tab
        tabs.add("Browse Products", browseTab);
        tabs.add("Check/Update Product Details", detailTab);

        //Add tabs to the frame
        frame.add(tabs);

        frame.setSize(400,800);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        Item.addTestItems();
        new Products();
    }
}
