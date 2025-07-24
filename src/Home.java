import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Home extends  JFrame{
    private JPanel MainPanel;
    private JButton PCsButton;
    private JButton laptopsbutton;
    private JButton camerasbutton;
    private JButton homeButton;
    private JButton cartButton;
    private JButton profileButton;
    private JButton logoutButton;
    private JPanel TopMenu;
    private JButton buyNowButton1;
    private JButton addToCartButton1;
    private JPanel Hp1;
    private JPanel Hp2;
    private JPanel Hp3;
    private JPanel Hp4;
    private JPanel Hp5;
    private JPanel Hp6;
    private JPanel Hp7;
    private JPanel Hp8;
    private JPanel Hp9;
    private JPanel Hp10;
    private JPanel Hp11;
    private JPanel Hp12;
    private JPanel Hp13;
    private JPanel Hp14;
    private JPanel H10;
    private JPanel Hp16;
    private JPanel Hp17;
    private JPanel Hp18;
    private JPanel Hp19;

    ;
    private JButton mobilesbutton;
    private JButton headsetsbutton;
    private JButton buyNowButton2;
    private JButton addToCartButton2;
    private JButton addToCartButton3;
    private JButton addToCartButton4;
    private JButton addToCartButton5;
    private JLabel h1;
    private JLabel h2;
    private JLabel h3;
    private JLabel h4;
    private JLabel h5;
    private JLabel h6;
    private JLabel h7;
    private JLabel h8;
    private JLabel h9;
    private JLabel h10;
    private JLabel h11;
    private JLabel h12;
    private JLabel h13;
    private JLabel h14;
    private JLabel h15;
    private JLabel h16;
    private JLabel h17;
    private JLabel h18;
    private JLabel h19;
    private JLabel h20;
    private JButton addToCartButton6;
    private JButton addToCartButton7;
    private JButton addToCartButton8;
    private JButton addToCartButton9;
    private JButton addToCartButton10;
    private JButton addToCartButton11;
    private JButton addToCartButton12;
    private JButton addToCartButton13;
    private JButton addToCartButton14;
    private JButton addToCartButton15;
    private JButton addToCartButton16;
    private JButton addToCartButton17;
    private JButton addToCartButton18;
    private JButton addToCartButton19;
    private JButton addToCartButton20;
    private JButton buyNowButton3;
    private JButton buyNowButton4;
    private JButton buyNowButton5;
    private JButton buyNowButton6;
    private JButton buyNowButton7;
    private JButton buyNowButton8;
    private JButton buyNowButton9;
    private JButton buyNowButton10;
    private JButton buyNowButton11;
    private JButton buyNowButton12;
    private JButton buyNowButton13;
    private JButton buyNowButton14;
    private JButton buyNowButton15;
    private JButton buyNowButton16;
    private JButton buyNowButton17;
    private JButton buyNowButton18;
    private JButton buyNowButton19;
    private JButton buyNowButton20;
    private JButton profileBTN;

    public Home() {

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


        homeButton.addActionListener(e -> {
            Home home=new Home();
            home.main(new String[0]);
            dispose();
        });


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


        addToCartButton2.addActionListener(e -> {

            CartItem newItem = new CartItem(h2.getText(), 1, 100000);
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





        addToCartButton11.addActionListener(e -> {

            CartItem newItem = new CartItem(h11.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        addToCartButton12.addActionListener(e -> {

            CartItem newItem = new CartItem(h12.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton13.addActionListener(e -> {

            CartItem newItem = new CartItem(h13.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        addToCartButton14.addActionListener(e -> {

            CartItem newItem = new CartItem(h14.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton15.addActionListener(e -> {

            CartItem newItem = new CartItem(h15.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton16.addActionListener(e -> {

            CartItem newItem = new CartItem(h16.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCartButton17.addActionListener(e -> {

            CartItem newItem = new CartItem(h17.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        addToCartButton18.addActionListener(e -> {

            CartItem newItem = new CartItem(h18.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        addToCartButton19.addActionListener(e -> {
            // Example: Adding a new item to the cart (You can modify this based on your product selection)
            CartItem newItem = new CartItem(h19.getText(), 1, 100000);
            addCart(newItem);
            JOptionPane.showMessageDialog(this, "Item added to cart", "Cart", JOptionPane.INFORMATION_MESSAGE);
        });
        addToCartButton20.addActionListener(e -> {

            CartItem newItem = new CartItem(h20.getText(), 1, 100000);
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


        buyNowButton11.addActionListener(e -> {

            CartItem newItem = new CartItem(h11.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });
        buyNowButton12.addActionListener(e -> {

            CartItem newItem = new CartItem(h12.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton13.addActionListener(e -> {

            CartItem newItem = new CartItem(h13.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });


        buyNowButton14.addActionListener(e -> {

            CartItem newItem = new CartItem(h14.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton15.addActionListener(e -> {

            CartItem newItem = new CartItem(h15.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton16.addActionListener(e -> {

            CartItem newItem = new CartItem(h16.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

        buyNowButton17.addActionListener(e -> {

            CartItem newItem = new CartItem(h17.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });
        buyNowButton18.addActionListener(e -> {

            CartItem newItem = new CartItem(h18.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });


        buyNowButton19.addActionListener(e -> {

            CartItem newItem = new CartItem(h19.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });


        buyNowButton20.addActionListener(e -> {

            CartItem newItem = new CartItem(h20.getText(), 1, 100000);
            addCart(newItem);
            new cart2().setVisible(true);
        });

    }


    public static void main( String[] args ) {
        SwingUtilities.invokeLater(() -> {
            Home home = new Home();
            home.setContentPane(home.MainPanel);
            home.setTitle("SSM Stores");
            home.setExtendedState(JFrame.MAXIMIZED_BOTH);

            try {
                ImageIcon logo = new ImageIcon("logo.png");
                home.setIconImage(logo.getImage());
            } catch (Exception e) {
                System.out.println("Logo image not found");
            }

            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            home.setVisible(true);
        });
    }

    class Cart extends JFrame{

        public Cart() {
            setTitle("SSM Stores - Cart");
            setSize(600, 400);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout());

            JTextArea cartItems = new JTextArea();
            cartItems.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(cartItems);

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            bottomPanel.add(new JLabel("Total: $0.00"));
            JButton checkoutBtn = new JButton("Checkout");

            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(bottomPanel, BorderLayout.SOUTH);

            setContentPane(panel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            loadCartItems(cartItems);
        }}

    private void loadCartItems(JTextArea cartItems) {
    }




}