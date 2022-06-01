import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    Container container = getContentPane();
    JButton openLoginPage = new JButton("Click to login");
    JLabel logo = new JLabel(new ImageIcon("logo.png"));

    Login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        logo.setBounds(10, 10, 294, 147);
        openLoginPage.setBounds(305, 10, 147, 147);
    }

    public void addComponentsToContainer() {
        container.add(openLoginPage);
        container.add(logo);
    }

    public void addActionEvent() {
        openLoginPage.addActionListener(this);
    }


    public static void generatePage() {
        Login frame = new Login();
        frame.setTitle("Computer Products Management System");
        frame.setVisible(true);
        frame.setBounds(10, 10, 480, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }


    public static void main(String[] args) {
        Item.addTestItems();
        User.generateTestUsers();
        generatePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openLoginPage) {
            LoginFrame.generateLoginPrompt();
            this.dispose();
        }
    }
}
