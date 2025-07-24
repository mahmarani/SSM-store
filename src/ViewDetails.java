import javax.swing.*;

public class ViewDetails extends JFrame{
    private JPanel MainVD;
    private JLabel productImage;
    private JTextArea a13InchLaptopWithTextArea;

    public static void main(String[] args) {
        ViewDetails vd = new ViewDetails();
        vd.setSize(400,500);
        vd.setResizable(false);
        vd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vd.setContentPane(vd.MainVD);
        vd.setTitle("Product Details");


        vd.setVisible(true);
    }

}
