import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeadSets extends JFrame{
    private JPanel mainHeadSets;
    private JButton PCsButton;
    private JPanel TopMenu;
    private JButton homeButton;
    private JButton cartButton;
    private JButton logoutButton;
    private JPanel Hp1;
    private JButton buyNowButton1;
    private JButton addToCartButton1;
    private JPanel Hp5;
    private JPanel Hp2;
    private JPanel Hp10;
    private JPanel Hp3;
    private JPanel Hp9;
    private JPanel Hp4;
    private JPanel Hp8;
    private JPanel Hp7;
    private JPanel Hp6;
    private JButton buyNowButton2;
    private JButton buyNowButton3;
    private JButton buyNowButton4;
    private JButton buyNowButton5;
    private JButton buyNowButton6;
    private JButton buyNowButton7;
    private JButton buyNowButton8;
    private JButton buyNowButton9;
    private JButton buyNowButton10;
    private JLabel h1;
    private JLabel h2;
    private JLabel h3;
    private JLabel h4;
    private JLabel h5;
    private JLabel h10;
    private JLabel h9;
    private JLabel h8;
    private JLabel h7;
    private JLabel h6;
    private JButton addToCartButton2;
    private JButton addToCartButton3;
    private JButton addToCartButton4;
    private JButton addToCartButton5;
    private JButton addToCartButton10;
    private JButton addToCartButton9;
    private JButton addToCartButton8;
    private JButton addToCartButton7;
    private JButton addToCartButton6;
    private JButton mobilesbutton;
    private JButton headsetsbutton;
    private JButton camerasbutton;
    private JButton laptopsbutton;
    private JButton profileBTN;


    public HeadSets() {

        initActionListeners();
        profileBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Profile().main(new String[0]);
            }
        });
    }

    void addCart(CartItem ci){
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO cart(name,quantity, price,user_email) VALUES (?, ?, ?,?)")) {

            ps.setString(1, ci.getName());
            ps.setInt(2, ci.getQuantity());
            ps.setDouble(3, ci.getPrice());

            FileReader fr = new FileReader("current.txt");
            BufferedReader br = new BufferedReader(fr);

            String email = br.readLine();
            ps.setString(4, email);

            fr.close();
            br.close();

            ps.executeUpdate();

        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Error"+ex.getMessage());
        }
    }

    boolean isCartEmpty(){
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * from cart where user_email = ?")) {

            //to get the current user:
            FileReader fr = new FileReader("current.txt");
            BufferedReader br = new BufferedReader(fr);

            String email = br.readLine();
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return false;
            } else
                return true;


        } catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Error"+ex.getMessage());
        }

        return false;


    }
    private void initActionListeners() {
        addToCartButton1.addActionListener(e -> {

            CartItem newItem = new CartItem(h1.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        cartButton.addActionListener(e -> {
            if (isCartEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Your cart is empty!",
                        "Cart",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                new cart2().setVisible(true);
            }
        });

        logoutButton.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(this,"Do you want to Logout?", "Confirmation",JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION) {
                new Login().main(new String[0]);
                dispose();
            }
        });
        homeButton.addActionListener(e -> {
            Home home=new Home();
            home.main(new String[0]);
            dispose();
        });

        // PCs button - show PCs category
        PCsButton.addActionListener(e -> {
            PCs pc = new PCs();
            pc.main(new String [0]);
            dispose();

        });

        laptopsbutton.addActionListener(e -> {
            Laptops laptop=new Laptops();
            laptop.main(new String [0]);
            dispose();

        });

        mobilesbutton.addActionListener(e -> {
            Mobiles mobiles=new Mobiles();
            mobiles.main(new String [0]);
            dispose();

        });

        headsetsbutton.addActionListener(e -> {
            HeadSets headsets=new HeadSets();
            headsets.main(new String [0]);
            dispose();

        });

        camerasbutton.addActionListener(e -> {
            Cameras camera=new Cameras();
            camera.main(new String [0]);
            dispose();

        });
        addToCartButton2.addActionListener(e -> {

            CartItem newItem = new CartItem(h2.getText(), 1, 100000); // Replace with actual item
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton3.addActionListener(e -> {

            CartItem newItem = new CartItem(h3.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton4.addActionListener(e -> {

            CartItem newItem = new CartItem(h4.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton5.addActionListener(e -> {

            CartItem newItem = new CartItem(h5.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton6.addActionListener(e -> {

            CartItem newItem = new CartItem(h6.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton7.addActionListener(e -> {

            CartItem newItem = new CartItem(h7.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        addToCartButton8.addActionListener(e -> {

            CartItem newItem = new CartItem(h8.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });


        addToCartButton9.addActionListener(e -> {

            CartItem newItem = new CartItem(h9.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });


        addToCartButton10.addActionListener(e -> {

            CartItem newItem = new CartItem(h10.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        buyNowButton3.addActionListener(e -> {

            CartItem newItem = new CartItem(h3.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton4.addActionListener(e -> {

            CartItem newItem = new CartItem(h4.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });
        buyNowButton5.addActionListener(e -> {

            CartItem newItem = new CartItem(h5.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton6.addActionListener(e -> {

            CartItem newItem = new CartItem(h6.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton7.addActionListener(e -> {

            CartItem newItem = new CartItem(h7.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton8.addActionListener(e -> {

            CartItem newItem = new CartItem(h8.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton9.addActionListener(e -> {

            CartItem newItem = new CartItem(h9.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton10.addActionListener(e -> {

            CartItem newItem = new CartItem(h10.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton1.addActionListener(e -> {

            CartItem newItem = new CartItem(h1.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton2.addActionListener(e -> {

            CartItem newItem = new CartItem(h2.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });
    }

    public static void main(String[] args) {
        HeadSets hd = new HeadSets();
        hd.setContentPane(hd.mainHeadSets);
        hd.setExtendedState(JFrame.MAXIMIZED_BOTH);
        hd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hd.setTitle("Headsets Category");
        hd.setSize(300,400);
        hd.setVisible(true);
    }
}
