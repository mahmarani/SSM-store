import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Profile extends  JFrame{
    private JPanel mainProfile;
    private JLabel fName;
    private JLabel lastName;
    private JLabel Email;


    void setDetails(){
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * from users where email = ?")) {

            //to get the current user:
            FileReader fr = new FileReader("current.txt");
            BufferedReader br = new BufferedReader(fr);

            String email = br.readLine();
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                this.fName.setText(rs.getString(1));
                this.lastName.setText(rs.getString(2));
                this.Email.setText(rs.getString(3));
            }


           fr.close();
            br.close();

        }catch (Exception ex){

        }
    }




    public static void main(String[] args) {
        Profile pr = new Profile();
        pr.setContentPane(pr.mainProfile);
        pr.setSize(350,400);
        pr.setResizable(false);
        pr.setTitle("User Profile");
        pr.setDetails();
        pr.setVisible(true);




    }
}
