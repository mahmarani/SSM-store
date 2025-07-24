import javax.swing.*;

public class Cart extends JFrame{
    private JPanel mainCart;
    private JPanel TopMenu;
    private JButton homeButton;
    private JButton cartButton;
    private JButton profileButton;
    private JButton logoutButton;
    private JButton buyNowButton;

    public static void main(String[] args) {
        Cart cr = new Cart();

        cr.setContentPane(cr.mainCart);
        cr.setSize(300,400);
        cr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cr.setTitle("Cart");

        ImageIcon img  = new ImageIcon("/logo.png");
        cr.setIconImage(img.getImage());

        cr.setVisible(true);
    }


}
