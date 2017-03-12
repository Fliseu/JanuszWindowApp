package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Pawel on 2017-02-20.
 */
public class JanuszMainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel secondPanel;
    private JPanel puzzlePanel;

    public JanuszMainWindow(){
        initUI();       //sets visibility, size etc.
        //addButtonsToJanusz();   //adds layout and buttons to the window
    }

    private void initUI(){
        setLayout(new FlowLayout());
        setVisible(true);
        setTitle("Microsoft Janusz 2000");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon windowIcon = new ImageIcon("derpwolf.png");
        ImageIcon wiesiekImgIcon = new ImageIcon("wiesiek.png");
        ImageIcon puzzle1 = new ImageIcon("1.png");
        ImageIcon puzzle2 = new ImageIcon("2.png");
        ImageIcon puzzle3 = new ImageIcon("3.png");
        ImageIcon puzzle4 = new ImageIcon("4.png");
        ImageIcon puzzleEmpty = new ImageIcon("empty.png");

        JLabel puzzleLabel1 = new JLabel(puzzle1);
        JLabel puzzleLabel2 = new JLabel(puzzle2);
        JLabel puzzleLabel3 = new JLabel(puzzle3);
        JLabel puzzleLabel4 = new JLabel(puzzle4);
        JLabel puzzleEmptyLabel = new JLabel(puzzleEmpty);



        setIconImage(windowIcon.getImage());

        JButton quitButton = createButton1("Wyjście");
        quitButton.addActionListener( (ActionEvent event) -> {System.exit(0);});

        //JPanel pane = createLayout();

        mainPanel = new JPanel();
        secondPanel = new JPanel();
        puzzlePanel = new JPanel();
        FlowLayout fl = new FlowLayout();
        GridLayout puzzleLayout = new GridLayout(2,2);

        mainPanel.setLayout(fl);
        mainPanel.setVisible(true);
        mainPanel.setBackground(Color.CYAN);
        mainPanel.add(quitButton);
        mainPanel.setToolTipText("main panel");
        mainPanel.setPreferredSize(new Dimension(412,50));

        secondPanel.setLayout(fl);
        secondPanel.setVisible(true);
        secondPanel.setBackground(Color.BLUE);
        secondPanel.setToolTipText("second panel");
        secondPanel.add(puzzlePanel);

        puzzlePanel.setVisible(true);
        puzzlePanel.setLayout(puzzleLayout);
        puzzlePanel.setBackground(Color.white);
        puzzlePanel.add(puzzleLabel1);
        puzzlePanel.add(puzzleLabel2);
        puzzlePanel.add(puzzleLabel3);
        puzzlePanel.add(puzzleEmptyLabel);
        //puzzlePanel.setPreferredSize(new Dimension(412,360) );






        add(mainPanel);
        add(secondPanel);
        createMenuBar();
    }

    private JButton createButton1(String name){
        JButton button = new JButton(name);
        button.setToolTipText("Kliknij aby zakonczyc program");

        return button;
    }

    private JPanel createLayout(){
        JPanel pane = (JPanel) getContentPane();
        FlowLayout flt = new FlowLayout();
        pane.setLayout(flt);

        pane.setToolTipText("content pane");

        return pane;
    }

    private void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu saveMenu = new JMenu("Save...");
        ImageIcon exitIcon = new ImageIcon("javaicons\\exit.png");
        ImageIcon openIcon = new ImageIcon("javaicons\\03\\16\\10.png");
        ImageIcon saveIcon = new ImageIcon("javaicons\\02\\16\\46.png");

        JMenuItem openMenuItem = new JMenuItem("Open",openIcon);
        JMenuItem saveMenuItem = new JMenuItem("Save",saveIcon);
        JMenuItem exitMenuItem = new JMenuItem("Exit",exitIcon);
        exitMenuItem.setToolTipText("Wyjście z programu");


        exitMenuItem.addActionListener(new ExitActionListener());

        saveMenu.add(saveMenuItem);

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args){
        EventQueue.invokeLater( () -> {
            JanuszMainWindow mainWindow = new JanuszMainWindow();
        });
    }

}
