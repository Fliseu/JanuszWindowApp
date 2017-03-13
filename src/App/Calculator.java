package App;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Pawel on 2017-03-07.
 */
public class Calculator extends JFrame {

    private JPanel calcPanel;
    private JPanel scrnPanel;
    private JPanel btnsPanel;
    private JTextField screenDown;
    private JTextField screenUp;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnTimes;
    private JButton btnBy;
    private JButton btnEquals;
    private JButton btnClr;
    private JButton btnDel;
    private JButton btnComma;
    private int enteredNumber;
    private int value1;
    private int value2;
    private int result;
    private boolean started = false;
    private String operator = null;
    private int lastResult = 0;
    private String lastClicked = null;

    public Calculator(){

        initCalculator();

    }

    private void initCalculator(){
        myFrameSettings();

        scrnPanel = new JPanel();
        scrnPanel.setBackground(Color.WHITE);
        scrnPanel.setVisible(true);
        scrnPanel.setLayout(new GridLayout(2,1));

        btnsPanel = new JPanel();
        btnsPanel.setBackground(Color.cyan);
        btnsPanel.setVisible(true);
        btnsPanel.setLayout(new GridBagLayout());

        screenDown = new JTextField(15);
        screenDown.setEditable(false);
        screenDown.setVisible(true);
        screenDown.setFont(new Font("Arial",Font.BOLD,30));
        screenDown.setHorizontalAlignment(SwingConstants.RIGHT);

        screenUp = new JTextField(15);
        screenUp.setEditable(false);
        screenUp.setVisible(true);
        screenUp.setFont(new Font("Arial",Font.PLAIN,20));
        screenUp.setHorizontalAlignment(SwingConstants.RIGHT);


        Dimension d = new Dimension(25,25);
        Dimension dWide = new Dimension(100,25);

        btn0 = new JButton("0");
        btn0.setPreferredSize(dWide);
        btn1 = new JButton("1");
        btn1.setPreferredSize(d);
        btn2 = new JButton("2");
        btn2.setPreferredSize(d);
        btn3 = new JButton("3");
        btn3.setPreferredSize(d);
        btn4 = new JButton("4");
        btn4.setPreferredSize(d);
        btn5 = new JButton("5");
        btn5.setPreferredSize(d);
        btn6 = new JButton("6");
        btn6.setPreferredSize(d);
        btn7 = new JButton("7");
        btn7.setPreferredSize(d);
        btn8 = new JButton("8");
        btn8.setPreferredSize(d);
        btn9 = new JButton("9");
        btn9.setPreferredSize(d);
        btnPlus = new JButton("+");
        btnPlus.setPreferredSize(d);
        btnMinus = new JButton("-");
        btnMinus.setPreferredSize(d);
        btnTimes = new JButton("*");
        btnTimes.setPreferredSize(d);
        btnBy = new JButton("/");
        btnBy.setPreferredSize(d);
        btnEquals = new JButton("=");
        btnEquals.setPreferredSize(new Dimension(25,200));
        btnClr = new JButton("C");
        btnClr.setPreferredSize(dWide);
        btnDel = new JButton("<");
        btnDel.setPreferredSize(d);
        btnComma = new JButton(",");
        btnComma.setPreferredSize(d);

        setButtonsActListeners();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0; c.ipadx = c.ipady = 35;

        scrnPanel.add(screenUp);
        scrnPanel.add(screenDown);
        c.gridwidth = 2;
        btnsPanel.add(btn0,getGbc(c,0,5));
        c.gridwidth = 1;
        btnsPanel.add(btn1,getGbc(c,0,4));
        btnsPanel.add(btn2,getGbc(c,1,4));
        btnsPanel.add(btn3,getGbc(c,2,4));
        btnsPanel.add(btn4,getGbc(c,0,3));
        btnsPanel.add(btn5,getGbc(c,1,3));
        btnsPanel.add(btn6,getGbc(c,2,3));
        btnsPanel.add(btn7,getGbc(c,0,2));
        btnsPanel.add(btn8,getGbc(c,1,2));
        btnsPanel.add(btn9,getGbc(c,2,2));
        btnsPanel.add(btnPlus,getGbc(c,4,5));
        btnsPanel.add(btnMinus,getGbc(c,4,4));
        btnsPanel.add(btnTimes,getGbc(c,4,3));
        btnsPanel.add(btnBy,getGbc(c,4,2));
        c.gridheight = 5;
        btnsPanel.add(btnEquals,getGbc(c,5,1));
        c.gridheight = 1;
        c.gridwidth = 2;
        btnsPanel.add(btnClr,getGbc(c,0,0));
        c.gridwidth = 1;
        btnsPanel.add(btnDel,getGbc(c,2,0));
        btnsPanel.add(btnComma,getGbc(c,2,5));

        this.add(scrnPanel,BorderLayout.NORTH);
        this.add(btnsPanel, BorderLayout.CENTER);
    }

    private void setButtonsActListeners(){
        btn0.addActionListener(e -> {
            prepareNumButton("0");
        });
        btn1.addActionListener(e -> {
            prepareNumButton("1");
        });
        btn2.addActionListener(e -> {
            prepareNumButton("2");
        });
        btn3.addActionListener(e -> {
            prepareNumButton("3");
        });
        btn4.addActionListener(e -> {
            prepareNumButton("4");
        });
        btn5.addActionListener(e -> {
            prepareNumButton("5");
        });
        btn6.addActionListener(e -> {
            prepareNumButton("6");
        });
        btn7.addActionListener(e -> {
            prepareNumButton("7");
        });
        btn8.addActionListener(e -> {
            prepareNumButton("8");
        });
        btn9.addActionListener(e -> {
            prepareNumButton("9");
        });
        btnPlus.addActionListener(e -> {
            prepareOperationButton("+");
        });
        btnMinus.addActionListener(e -> {
            prepareOperationButton("-");
        });
        btnTimes.addActionListener(e -> {
            prepareOperationButton("*");
        });
        btnBy.addActionListener(e -> {
            prepareOperationButton("/");
        });
        btnEquals.addActionListener(e -> {
            screenUp.setText(screenUp.getText() + enteredNumber);
            calculate();
        });
        btnClr.addActionListener(e -> {
            screenDown.setText(null);
            screenUp.setText(null);
        });
        btnDel.addActionListener(e -> {
            prepareDeleteButton();
        });
    }

    private void pushOperator(){
        screenUp.setText(screenUp.getText() + screenDown.getText() + operator);
    }

    /** Method to be executed in declaration of button's action listener
     * It declares which digit will be added to the lower screen after pushing the button.
     * It also updates the enteredNumber value with added digit.
     * This method updates the value of lastClicked with value "number".
     *
     *  @param number
     *  @return nothing
    */
    private void prepareNumButton(String number){
        if(lastClicked=="operator" || lastClicked == null){
            screenDown.setText(null);
        }
        String screenValue = screenDown.getText() + number;
        enteredNumber = Integer.parseInt(screenValue);
        if(screenUp.getText().isEmpty()){
            result = enteredNumber;
        }
        screenDown.setText(screenValue);
        lastClicked = "number";
    }

    private void prepareOperationButton(String typeOfCalc){
        if(lastClicked=="number"){
            if(screenDown.getText().isEmpty()){
                //TODO wyswietlic komunikat zeby wprowadzic liczbe
            }else if(screenUp.getText().isEmpty()){
                operator = typeOfCalc;
                pushOperator();
                screenDown.setText(null);
            }else{
                pushOperator();
                calculate();
                operator = typeOfCalc;
            }
        }
        lastClicked = "operator";
    }

    private void prepareDeleteButton(){
        screenDown.setText( screenDown.getText().substring(0, screenDown.getText().length()-1));
    }

    private GridBagConstraints getGbc(GridBagConstraints c, int x, int y){
        c.gridx = x;
        c.gridy = y;

        return c;
    }

    private int calculate(){
//        StringBuffer op = new StringBuffer(screenUp.getText()).reverse();
//        operator = Character.toString(op.charAt(1));


        switch(operator){
            case "+":
                result = result + enteredNumber;
                break;
            case "*":
                result = result * enteredNumber;
                break;
            case "-":
                result = result - enteredNumber;
                break;
            case "/":
                result = result / enteredNumber;
                break;
        }
        screenDown.setText(String.valueOf(result));
        return result;
    }

    private void myFrameSettings(){
        this.setTitle("Bulbulator");
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.setSize(400,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        EventQueue.invokeLater( () -> {
            Calculator abacus = new Calculator();
        });

    }
}
