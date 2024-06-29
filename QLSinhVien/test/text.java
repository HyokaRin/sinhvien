/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class text {
    private final JTextField mssvField;
    private final JTextArea responseArea;
    private final JButton submitButton;

    public text() {
        JFrame frame = new JFrame("Student Score Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create MSSV input field
        mssvField = new JTextField(20);
        panel.add(mssvField, BorderLayout.NORTH);

        // Create response area
        responseArea = new JTextArea(10, 20);
        responseArea.setEditable(false);
        panel.add(new JScrollPane(responseArea), BorderLayout.CENTER);

        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String mssv = mssvField.getText();
            if (mssv.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid MSSV");
                return;
            }

            try {
                Socket socket = new Socket("localhost", 8000);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                writer.println(mssv);

                String response;
                while ((response = reader.readLine()) != null) {
                    responseArea.append(response + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error connecting to server: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(text::new);
    }
}