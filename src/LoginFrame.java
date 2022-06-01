import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton cancelButton = new JButton("Cancel");

    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(20, 10, 80, 30);
        passwordLabel.setBounds(20, 40, 80, 30);
        userTextField.setBounds(100, 10, 150, 30);
        passwordField.setBounds(100, 40, 150, 30);
        loginButton.setBounds(50, 90, 80, 30);
        cancelButton.setBounds(140, 90, 80, 30);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(cancelButton);
    }

    public void addActionEvent() {
        //adding Action listener to components
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    public static void generateLoginPrompt() {
        LoginFrame frame = new LoginFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("Sales Person Login");
        frame.setVisible(true);
        frame.setBounds(10, 10, 300, 180);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            if (User.checkValidUser(userTextField.getText(), String.valueOf(passwordField.getPassword()))) {
                Products.generatePage(userTextField.getText().charAt(0) == 109);
                this.dispose();
            } else {
                userTextField.setText("");
                passwordField.setText("");
            }
        }
        //Coding Part of CANCEL button
        if (e.getSource() == cancelButton) {
            userTextField.setText("");
            passwordField.setText("");
            Login.generatePage();
            this.dispose();
        }
    }
}
