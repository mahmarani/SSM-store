import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;

public class Login extends JFrame{
    private JPanel MainLogin;
    private JLabel SideImage;
    private JLabel LoginText;
    private JTextField nameTxt;
    private JLabel nameLabel;
    private JButton loginBtn;
    private JButton signUpButton;
    private JPasswordField passwordField1;
    public  String email;

    public Login(){
        loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String password = new String(passwordField1.getPassword());
                email=new String(nameTxt.getText());

                //store current user details:
                try{
                    FileWriter fw = new FileWriter("current.txt");
                    PrintWriter pw = new PrintWriter(fw);

                    pw.println(email);


                    fw.close();
                    pw.close();
                }catch (Exception ex){

                }


                try (Connection conn = DBConnection.getConnection()) {
                    try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {

                        ps.setString(1, email);
                        ps.setString(2, password);

                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(Login.this, "Login Successful!");

                            Home home = new Home();
                            home.main(new String[0]);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(Login.this, "Invalid Credentials!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Login.this, "Database Error!");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp();
                signUp.main(new String[0]);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Login l = new Login();
        l.setContentPane(l.MainLogin);
        l.setTitle("SSM Stores - Login");

        l.setResizable(false);
        l.setExtendedState(JFrame.MAXIMIZED_BOTH);
        l.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            ImageIcon logo = new ImageIcon("logo.png");
            l.setIconImage(logo.getImage());
        } catch (Exception e) {
            System.out.println("Logo image not found");
        }

        l.setVisible(true);
    }
}