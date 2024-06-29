/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sinhvien;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginEvent {
    private JFrame mainFrame;
    private JButton loginButton;

    public LoginEvent() {
        createGUI();
    }

    private void createGUI() {
        mainFrame = new JFrame("Main Frame");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        mainFrame.add(loginButton);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog loginDialog = new JDialog(mainFrame, "Login", true);
            loginDialog.setLayout(new FlowLayout());

            JLabel usernameLabel = new JLabel("Username:");
            loginDialog.add(usernameLabel);

            JTextField usernameField = new JTextField(20);
            loginDialog.add(usernameField);

            JLabel passwordLabel = new JLabel("Password:");
            loginDialog.add(passwordLabel);

            JPasswordField passwordField = new JPasswordField(20);
            loginDialog.add(passwordField);

            JButton okButton = new JButton("OK");
            okButton.addActionListener(new OkButtonListener(usernameField, passwordField, loginDialog));
            loginDialog.add(okButton);

            loginDialog.pack();
            loginDialog.setVisible(true);
        }
    }

    private class OkButtonListener implements ActionListener {
        private final JTextField usernameField;
        private final JPasswordField passwordField;
        private final JDialog loginDialog;

        public OkButtonListener(JTextField usernameField, JPasswordField passwordField, JDialog loginDialog) {
            this.usernameField = usernameField;
            this.passwordField = passwordField;
            this.loginDialog = loginDialog;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Validate username and password
            if (validateLogin(username, password)) {
                // Login successful, close login dialog and redirect to another page
                loginDialog.dispose();
                new AnotherPage(); // Create an instance of AnotherPage class
            } else {
                // Login failed, show error message
                JOptionPane.showMessageDialog(loginDialog, "Invalid username or password");
            }
        }

        private boolean validateLogin(String username, String password) {
            // Implement your login validation logic here
            // For demonstration purposes, return true if username and password are not empty
            return!username.isEmpty() &&!password.isEmpty();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginEvent loginEvent = new LoginEvent();
            }
        });
    }
}

class AnotherPage {
    public AnotherPage() {
        JFrame frame = new JFrame("Another Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("Welcome to another page!"));
        frame.pack();
        frame.setVisible(true);
    }
}
