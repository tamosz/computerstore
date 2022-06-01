import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Products extends JFrame implements ActionListener {
    //UI STUFF
    Container container = getContentPane();

    //tab container
    static JTabbedPane tabs = new JTabbedPane();

    //tabs
    JPanel browseTab = new JPanel(new BorderLayout());
    JPanel detailTab = new JPanel(new BorderLayout());

    //things that go inside the browse tab
    JPanel sortPanel = new JPanel();
    JPanel tablePanel = new JPanel(new BorderLayout());

    //things that go inside the sort panel
    JPanel categoryPanel = new JPanel();
    JPanel typePanel = new JPanel();

    //things that go inside the category panel (sub panel of sort panel)
    JLabel categoryLabel = new JLabel("Computer Category");
    String[] categoryOptions = {"All", "Desktop PC", "Laptop", "Tablet"};
    JComboBox<String> categoryChooser = new JComboBox<>(categoryOptions);

    //things that go inside the type panel (sub panel of sort panel)
    JLabel typeLabel = new JLabel("Computer Type");
    String[] typeOptions = {"All", "Gaming", "Apple", "Business", "Home & Study", "Compact", "Thin & Light", "Android", "Windows"};
    JComboBox<String> typeChooser = new JComboBox<>(typeOptions);

    //things that go inside the table panel
    String[][] data = Item.itemToTableFormat();
    String[] column = {"Category", "Type", "ID", "Brand", "CPU Family", "Price($)"};
    JTable table = new JTable(data, column);


    //DETAIL TAB
    JPanel detailPanel = new JPanel(new GridLayout(11, 2));

    //modelPanel
    JLabel modelLabel = new JLabel("Model ID:", SwingConstants.RIGHT);
    JTextField modelField = new JTextField();

    //category panel
    JLabel detailCategoryLabel = new JLabel("Category:", SwingConstants.RIGHT);
    JComboBox<String> detailCategoryChooser = new JComboBox<>(categoryOptions);

    //type panel
    JLabel detailTypeLabel = new JLabel("Type:", SwingConstants.RIGHT);
    JComboBox<String> detailTypeChooser = new JComboBox<>(typeOptions);

    //brand panel
    JLabel brandLabel = new JLabel("Brand:", SwingConstants.RIGHT);
    JTextField brandField = new JTextField();

    //cpu panel
    JLabel cpuLabel = new JLabel("CPU:", SwingConstants.RIGHT);
    JTextField cpuField = new JTextField();

    //memory panel
    JLabel memoryLabel = new JLabel("Memory Size:", SwingConstants.RIGHT);
    JTextField memoryField = new JTextField();

    //ssd panel
    JLabel ssdLabel = new JLabel("SSD Capacity:", SwingConstants.RIGHT);
    JTextField ssdField = new JTextField();

    //screen size panel
    JLabel screenSizeLabel = new JLabel("Screen Size:", SwingConstants.RIGHT);
    JTextField screenSizeField = new JTextField();

    //price panel
    JLabel priceLabel = new JLabel("Price:", SwingConstants.RIGHT);
    JTextField priceField = new JTextField();

    //button panel
    static JButton addButton = new JButton("Add");
    static JButton updateButton = new JButton("Update");
    static JButton deleteButton = new JButton("Delete");
    static JButton clearButton = new JButton("Clear");


    //logout panel
    JPanel logoutPanel = new JPanel(new BorderLayout());

    //things that go inside the logout panel
    JButton logoutButton = new JButton("Click to logout");
    JLabel logo = new JLabel(new ImageIcon("logo.png"));


    public void setLayoutManager() {
        container.setLayout(new BorderLayout());
    }

    public void addActionEvent() {
        //adding Action listener to components
        logoutButton.addActionListener(this);
        categoryChooser.addActionListener(this);
        typeChooser.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    String selectedID = table.getValueAt(row, 2).toString();
                    Item currentItem = Item.getItemByID(selectedID);
                    modelField.setText(currentItem.getId());
                    //setting the category chooser
                    if (Objects.equals(currentItem.getCategory(), "Desktop PC")) {
                        detailCategoryChooser.setSelectedIndex(1);
                    }
                    if (Objects.equals(currentItem.getCategory(), "Laptop")) {
                        detailCategoryChooser.setSelectedIndex(2);
                    }
                    if (Objects.equals(currentItem.getCategory(), "Tablet")) {
                        detailCategoryChooser.setSelectedIndex(3);
                    }
                    //setting the type chooser
                    if (Objects.equals(currentItem.getType(), "Gaming")) {
                        detailTypeChooser.setSelectedIndex(1);
                    }
                    if (Objects.equals(currentItem.getType(), "Apple")) {
                        detailTypeChooser.setSelectedIndex(2);
                    }
                    if (Objects.equals(currentItem.getType(), "Business")) {
                        detailTypeChooser.setSelectedIndex(3);
                    }
                    if (Objects.equals(currentItem.getType(), "Home & Study")) {
                        detailTypeChooser.setSelectedIndex(4);
                    }
                    if (Objects.equals(currentItem.getType(), "Compact")) {
                        detailTypeChooser.setSelectedIndex(5);
                    }
                    if (Objects.equals(currentItem.getType(), "Thin & Light")) {
                        detailTypeChooser.setSelectedIndex(6);
                    }
                    if (Objects.equals(currentItem.getType(), "Android")) {
                        detailTypeChooser.setSelectedIndex(7);
                    }
                    if (Objects.equals(currentItem.getType(), "Windows")) {
                        detailTypeChooser.setSelectedIndex(8);
                    }
                    brandField.setText(currentItem.getBrand());
                    cpuField.setText(currentItem.getCpuFamily());
                    memoryField.setText(Integer.toString(currentItem.getMemorySize()));
                    ssdField.setText(Integer.toString(currentItem.getSsdCapacity()));
                    screenSizeField.setText(Double.toString(currentItem.getScreenSize()));
                    priceField.setText(Integer.toString(currentItem.getPrice()));

                    tabs.setSelectedIndex(1);
                }
            }
        });

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    public void refreshTableActionEvent() {
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    String selectedID = table.getValueAt(row, 2).toString();
                    Item currentItem = Item.getItemByID(selectedID);
                    modelField.setText(currentItem.getId());
                    //setting the category chooser
                    if (Objects.equals(currentItem.getCategory(), "Desktop PC")) {
                        detailCategoryChooser.setSelectedIndex(1);
                    }
                    if (Objects.equals(currentItem.getCategory(), "Laptop")) {
                        detailCategoryChooser.setSelectedIndex(2);
                    }
                    if (Objects.equals(currentItem.getCategory(), "Tablet")) {
                        detailCategoryChooser.setSelectedIndex(3);
                    }
                    //setting the type chooser
                    if (Objects.equals(currentItem.getType(), "Gaming")) {
                        detailTypeChooser.setSelectedIndex(1);
                    }
                    if (Objects.equals(currentItem.getType(), "Apple")) {
                        detailTypeChooser.setSelectedIndex(2);
                    }
                    if (Objects.equals(currentItem.getType(), "Business")) {
                        detailTypeChooser.setSelectedIndex(3);
                    }
                    if (Objects.equals(currentItem.getType(), "Home & Study")) {
                        detailTypeChooser.setSelectedIndex(4);
                    }
                    if (Objects.equals(currentItem.getType(), "Compact")) {
                        detailTypeChooser.setSelectedIndex(5);
                    }
                    if (Objects.equals(currentItem.getType(), "Thin & Light")) {
                        detailTypeChooser.setSelectedIndex(6);
                    }
                    if (Objects.equals(currentItem.getType(), "Android")) {
                        detailTypeChooser.setSelectedIndex(7);
                    }
                    if (Objects.equals(currentItem.getType(), "Windows")) {
                        detailTypeChooser.setSelectedIndex(8);
                    }
                    brandField.setText(currentItem.getBrand());
                    cpuField.setText(currentItem.getCpuFamily());
                    memoryField.setText(Integer.toString(currentItem.getMemorySize()));
                    ssdField.setText(Integer.toString(currentItem.getSsdCapacity()));
                    screenSizeField.setText(Double.toString(currentItem.getScreenSize()));
                    priceField.setText(Integer.toString(currentItem.getPrice()));

                    tabs.setSelectedIndex(1);
                }
            }
        });
    }

    Products() {
        setLayoutManager();
        addComponentsToContainer();
        addActionEvent();
    }

    public static void generatePage(boolean isManager) {
        Products frame = new Products();
        frame.setTitle("Computer Products Management System");
        frame.setVisible(true);
        frame.setBounds(10, 10, 480, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton.setEnabled(isManager);
        deleteButton.setEnabled(isManager);
        updateButton.setEnabled(isManager);
        clearButton.setEnabled(isManager);
        tabs.setEnabledAt(1, isManager);
        //frame.setResizable(false); uncomment once size are good and nice
    }

    public void addComponentsToContainer() {
        //first add tab panel and logout panel
        container.add(tabs, BorderLayout.NORTH);
        container.add(logoutPanel, BorderLayout.SOUTH);

        //then add tabs to tab panel
        tabs.add("Browse Products", browseTab);
        tabs.add("Check/Update Product Details", detailTab);

        //then add components to browse tab
        browseTab.add(sortPanel, BorderLayout.NORTH);
        browseTab.add(tablePanel, BorderLayout.SOUTH);

        //then add components to sort panel
        sortPanel.add(categoryPanel);
        sortPanel.add(typePanel);

        //then add components to category panel
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryChooser);

        //then add components to type panel
        typePanel.add(typeLabel);
        typePanel.add(typeChooser);

        //then add components to table panel
        tablePanel.add(table, BorderLayout.CENTER);
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        table.setDefaultEditor(Object.class, null); //disables editing within the table

        //adding components to detail tab
        detailTab.add(detailPanel);
        detailPanel.add(modelLabel);
        detailPanel.add(modelField);
        detailPanel.add(detailCategoryLabel);
        detailPanel.add(detailCategoryChooser);
        detailPanel.add(detailTypeLabel);
        detailPanel.add(detailTypeChooser);
        detailPanel.add(brandLabel);
        detailPanel.add(brandField);
        detailPanel.add(cpuLabel);
        detailPanel.add(cpuField);
        detailPanel.add(memoryLabel);
        detailPanel.add(memoryField);
        detailPanel.add(ssdLabel);
        detailPanel.add(ssdField);
        detailPanel.add(screenSizeLabel);
        detailPanel.add(screenSizeField);
        detailPanel.add(priceLabel);
        detailPanel.add(priceField);
        detailPanel.add(addButton);
        detailPanel.add(updateButton);
        detailPanel.add(deleteButton);
        detailPanel.add(clearButton);

        //then add components to logout panel
        logoutPanel.add(logoutButton, BorderLayout.EAST);
        logoutPanel.add(logo, BorderLayout.WEST);
    }


    public JTable filter(String category, String type) {
        String[][] filteredData;
        if (Objects.equals(category, "All") && Objects.equals(type, "All")) {
            return new JTable(Item.itemToTableFormat(), column);
        } else {
            filteredData = Item.filterTable(category, type);
        }
        return new JTable(filteredData, column);
    }

    public void updateTable(String category, String type) {
        tablePanel.remove(table);
        table = filter(category, type);
        table.setDefaultEditor(Object.class, null);
        tablePanel.add(table);
        refreshTableActionEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            Login.generatePage();
            tabs.removeAll();
            detailPanel.remove(addButton);
            detailPanel.remove(updateButton);
            detailPanel.remove(deleteButton);
            detailPanel.remove(clearButton);
            this.dispose();
        }
        if (e.getSource() == categoryChooser || e.getSource() == typeChooser) {
            updateTable(Objects.requireNonNull(categoryChooser.getSelectedItem()).toString(), Objects.requireNonNull(typeChooser.getSelectedItem()).toString());
        }
        if (e.getSource() == addButton) {
            if (Item.addItem(modelField.getText(), Objects.requireNonNull(detailCategoryChooser.getSelectedItem()).toString(), Objects.requireNonNull(detailTypeChooser.getSelectedItem()).toString(), brandField.getText(), cpuField.getText(), Integer.parseInt(memoryField.getText()), Integer.parseInt(ssdField.getText()), Double.parseDouble(screenSizeField.getText()), Integer.parseInt(priceField.getText()))) {
                JOptionPane.showMessageDialog(this, "The new item was added successfully.");
                updateTable("All", "All");
            } else {
                JOptionPane.showMessageDialog(this, "The ID " + modelField.getText() + " already exists, please enter a unique ID to add an item.");
            }
        }
        if (e.getSource() == updateButton) {
            if (Item.updateItem(modelField.getText(), Objects.requireNonNull(detailCategoryChooser.getSelectedItem()).toString(), Objects.requireNonNull(detailTypeChooser.getSelectedItem()).toString(), brandField.getText(), cpuField.getText(), Integer.parseInt(memoryField.getText()), Integer.parseInt(ssdField.getText()), Double.parseDouble(screenSizeField.getText()), Integer.parseInt(priceField.getText()))) {
                updateTable("All", "All");
                JOptionPane.showMessageDialog(this, "The record for the computer is updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "The ID " + modelField.getText() + " doesn't exist, update unsuccessful.");
            }
        }
        if (e.getSource() == deleteButton) {
            if (Item.removeItem(modelField.getText())) {
                modelField.setText("");
                brandField.setText("");
                cpuField.setText("");
                memoryField.setText("");
                ssdField.setText("");
                screenSizeField.setText("");
                priceField.setText("");
                updateTable("All", "All");
                JOptionPane.showMessageDialog(this, "The record for the computer is deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "There is no item with the id " + modelField.getText());
            }
        }
        if (e.getSource() == clearButton) {
            modelField.setText("");
            brandField.setText("");
            cpuField.setText("");
            memoryField.setText("");
            ssdField.setText("");
            screenSizeField.setText("");
            priceField.setText("");
        }
    }
}
