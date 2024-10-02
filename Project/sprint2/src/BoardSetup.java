import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardSetup extends JPanel implements ActionListener {

    public JPanel chitCardPanel;
    public JPanel volcanoCardPanelTop = new JPanel();
    public JPanel volcanoCardPanelRight = new JPanel();
    public JPanel volcanoCardPanelBottom = new JPanel();
    public JPanel volcanoCardPanelLeft = new JPanel();
    public JPanel cave1Panel = new JPanel();
    public JPanel cave2Panel = new JPanel();
    public JPanel cave3Panel = new JPanel();
    public JPanel cave4Panel = new JPanel();

    public JPanel token1 = new JPanel();
    public JPanel token2 = new JPanel();
    public JPanel token3 = new JPanel();
    public JPanel token4 = new JPanel();

    public JButton b = new JButton("Did You Win?");
    Popup popup;

    PopupFactory popupFactory = new PopupFactory();

    WinningPopupPanel winningPopupPanel = new WinningPopupPanel();

    public BoardSetup(){
        this.setBackground(Color.ORANGE);
        this.setLayout(null);

        setupWinningPanel();
        setupChitCardPanel();
        setupToken();
        setupCavePanel();
        setupVolcanoCardPanel();

    }

    public JPanel getChitCardPanel() {
        return chitCardPanel;
    }

    public void setupChitCardPanel(){
        chitCardPanel = new JPanel();
        chitCardPanel.setLayout(new GridLayout(4, 4,5,2));
        chitCardPanel.setBounds(310,230,300,300);
        chitCardPanel.setBackground(new Color(92, 64, 51));
        chitCardPanel.setOpaque(true);
        this.add(chitCardPanel);
    }

    public JPanel getVolcanoCardPanelTop() {
        return volcanoCardPanelTop;
    }

    public JPanel getVolcanoCardPanelRight() {
        return volcanoCardPanelRight;
    }

    public JPanel getVolcanoCardPanelBottom() {
        return volcanoCardPanelBottom;
    }

    public JPanel getVolcanoCardPanelLeft() {
        return volcanoCardPanelLeft;
    }


    public void setupVolcanoCardPanel(){

        //volcanoCardPanelRight = new JPanel();
        volcanoCardPanelRight.setLayout(new GridLayout(6,1));
        volcanoCardPanelRight.setBounds(655,180,60,420);
        volcanoCardPanelRight.setOpaque(false);
        this.add(volcanoCardPanelRight);

        //volcanoCardPanelLeft = new JPanel();
        volcanoCardPanelLeft.setLayout(new GridLayout(6,1));
        volcanoCardPanelLeft.setBounds(200,180,60,420);
        volcanoCardPanelLeft.setOpaque(false);
        this.add(volcanoCardPanelLeft);

        //volcanoCardPanelTop = new JPanel();
        volcanoCardPanelTop.setLayout(new GridLayout(1,6,0,0));
        volcanoCardPanelTop.setBounds(248,130,430,60);
        volcanoCardPanelTop.setOpaque(false);

        this.add(volcanoCardPanelTop);

        //volcanoCardPanelBottom = new JPanel();
        volcanoCardPanelBottom.setLayout(new GridLayout(1,6));
        volcanoCardPanelBottom.setBounds(248,578,430,60);
        volcanoCardPanelBottom.setOpaque(false);
        this.add(volcanoCardPanelBottom);
    }

    public JPanel getCavePanel(int number) {
        if (number == 0){
            return cave1Panel;
        } else if (number == 1) {
            return cave2Panel;
        } else if (number == 2) {
            return cave3Panel;
        } else {
            return cave4Panel;
        }
    }


    public void setupCavePanel(){
        //cave1Panel = new JPanel();
        cave1Panel.setBounds(440,18,101,105);
        cave1Panel.setBackground(new Color(92, 64, 51));
        this.add(token1, BorderLayout.CENTER);
        this.add(cave1Panel);

        //cave2Panel = new JPanel();
        cave2Panel.setBounds(730,370,105,105);
        cave2Panel.setBackground(new Color(92, 64, 51));
        this.add(token2, BorderLayout.CENTER);
        this.add(cave2Panel);

        //cave3Panel = new JPanel();
        cave3Panel.setBounds(440,660,105,105);
        cave3Panel.setBackground(new Color(92, 64, 51));
        this.add(token3, BorderLayout.CENTER);
        this.add(cave3Panel);

        cave4Panel.add(token4, BorderLayout.CENTER);
        cave4Panel.setBounds(85,300,105,105);
        cave4Panel.setBackground(new Color(92, 64, 51));
        this.add(token4, BorderLayout.CENTER);
        this.add(cave4Panel);

    }

    public JPanel getToken(int number) {
        if (number == 0){
            return token1;
        } else if (number == 1) {
            return token2;
        } else if (number == 2) {
            return token3;
        } else {
            return token4;
        }
    }

    public void setupToken(){
        //token1 = new JPanel();

        token1.setBounds(440,60,820,820);
        //token1.setLocation(440,60);

        token1.setOpaque(false);
        //token2 = new JPanel();
        token2.setBounds(720,370,45,65);
        token2.setOpaque(false);
        //token3 = new JPanel();
        token3.setBounds(510,640,45,65);
        token3.setOpaque(false);
        //token4 = new JPanel();
        token4.setBounds(155,0,820,820);
        token4.setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(780, 780);
        int width = 780;
        int height = 780;
        //int angle = 360/24;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(92, 64, 51));
        g2d.fillRoundRect(70,5,width-5,height-5, arcs.width, arcs.height);
        g2d.setColor(new Color(92, 64, 51));
    }

    public void setupWinningPanel(){
        //this.add(winningPopupPanel);
        //b = new JButton("You Win!");
        b.addActionListener(this);
        b.setFocusable(false);
        JPanel panel = new JPanel();
        //b.setVisible(false);
        panel.add(b);
        panel.setBounds(750,50,80,50);
        panel.setOpaque(false);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String d = e.getActionCommand();
        if(Game.checkWin()) {
            popup = popupFactory.getPopup(this, winningPopupPanel, 450, 80);
            if (d.equals("Start a new game")) {
                popup.hide();
            } else {
                popup.show();
            }
        }
        this.revalidate();
        validate();


    }
}
