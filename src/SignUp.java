import javax.swing.*;
import java.sql.*;

public class SignUp extends JFrame{
    private JPanel MainSignup;
    private JLabel SideImage;
    private JLabel signUpText;
    private JLabel nameLabel;
    private JTextField nameTxt;
    private JTextField lastName;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JButton SignupButton;
    private JTextField emailTxt;
    private JLabel Email;


    public SignUp() {

        setTitle("SSM Stores - SignUp");
        setContentPane(MainSignup);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            ImageIcon img = new ImageIcon("logo.png");
            setIconImage(img.getImage());
        } catch (Exception e) {
            System.out.println("Logo image not found");
        }

        initActions();
    }

    private void initActions() {

        if (loginButton != null) {
            loginButton.addActionListener(e -> {
                Login l = new Login();
                l.main(new String[0]);
                dispose();
            });
        }

        if (SignupButton != null){
            SignupButton.addActionListener(e -> registerNewUser());
        }
    }

    private void registerNewUser() {
        String first_name = nameTxt.getText();
        String last_name = lastName.getText();
        String email = emailTxt.getText();
        String password = new String(passwordField.getPassword());

        if (first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showMessage("All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@")) {
            showMessage("Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6) {
            showMessage("Password must be at least 6 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO users (first_name,last_name, email, password) VALUES (?, ?, ?,?)")) {

            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setString(4, password);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                showMessage("Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                Login login = new Login();
                login.main(new String[0]);
                this.dispose();

            } else {
                showMessage("Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicate entry")) {
                showMessage("Email already registered", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                showMessage("Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignUp signUp = new SignUp();
            signUp.setVisible(true);
        });
    }
}