package App;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pawel on 2017-02-20.
 */
public class Test extends JFrame{

    public Test(){

        initUI();
    }

    private void initUI(){
        setVisible(true);
        setTitle("okno z ikonką");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon windowIcon = new ImageIcon("derpwolf.png");
        setIconImage(windowIcon.getImage());
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Test window = new Test();
        });
    }

}
