package Frame;
import MyButton.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Objects;

public class MyFrame extends JFrame implements MouseListener {

    int a;

    JPanel screen;
    JPanel keys;
    MyButton button1;
    MyButton button2;
    MyButton button3;
    MyButton button4;
    MyButton button5;
    MyButton button6;
    MyButton button7;
    MyButton button8;
    MyButton button9;
    MyButton button0;
    MyButton add;
    MyButton subtract;
    MyButton division;
    MyButton multiply;
    MyButton equalTo;
    MyButton clear;
    JLabel screenLabel;
    List<Float> tempCalc;

    Float realCalc = 0f;
    Float calculatedValue = 0f;

    String[] arr;

    Float[] tempCalcValue = {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 0f};

    MyButton[] calcButton = {
            button1 = new MyButton("1"), button2 = new MyButton("2"),
            button3 = new MyButton("3"), button4 = new MyButton("4"),
            button5 = new MyButton("5"), button6 = new MyButton("6"),
            button7 = new MyButton("7"), button8 = new MyButton("8"),
            button9 = new MyButton("9"), button0 = new MyButton("0")
    };
    MyButton[] signButton = {
            add = new MyButton("+"), subtract = new MyButton("-"),
            division = new MyButton("/"), multiply = new MyButton("*"),
            equalTo = new MyButton("="), clear = new MyButton("C")
    };
    public MyFrame() {
        // Main Framework
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(360,450);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setResizable(false);

        for (int i = 0 ; i < 10 ; i++) {
            // Start of  Calculation Button
            calcButton[i].setFocusable(false);
            calcButton[i].addMouseListener(this);

            // Start of Sign/Mathematical Buttons
            if (i < 6) {
                signButton[i].setFocusable(false);
                signButton[i].addMouseListener(this);
            }
        }




        // Start of Label
        a = 0;
        screenLabel = new JLabel();
        screenLabel.setText(String.valueOf(a));
        screenLabel.setForeground(Color.BLACK);
        screenLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        screenLabel.setBounds(0, 50, 345, 49);
        screenLabel.setBackground(getBackground());
        screenLabel.setHorizontalAlignment(JLabel.LEFT);
        screenLabel.setOpaque(true);
        // End of Label

        // Start of Panel
        screen = new JPanel();
        screen.setLayout(null);
        screen.setBounds(0, 0, 350, 100);
        screen.setBackground(Color.LIGHT_GRAY);

        screen.add(screenLabel);

        keys = new JPanel();
        keys.setLayout(new GridLayout(4,4,2,2));
        keys.setBounds(1, 100, 342, 310);
        keys.setBackground(getBackground());

        for (int i = 0 ; i < 10 ; i++) {
            keys.add(calcButton[i]);
            if (i < 6) {
                keys.add(signButton[i]);
            }
        }

        // End of Panel

        this.add(screen);
        this.add(keys);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0 ; i < 10 ; i++) {
            if (e.getSource() == calcButton[i]) {
                tempCalc.add(tempCalcValue[i]);
                System.out.println("TempCalc : " + tempCalc);
            }
            if (i < 6) {
                if (e.getSource() == signButton[i]) {
                    if (Objects.equals(signButton[i].getText(), "+")) {
                        for (int j = 0 ; j < 2 ; j++) {
                            calculatedValue = tempCalc.get(i) + tempCalc.get(i + 1);
                        }
                        System.out.println(calculatedValue);
                    }
                    if (Objects.equals(signButton[i].getText(), "C")) {
                        calculatedValue = 0f;
                    }
                    if (Objects.equals(signButton[i].getText(), "=")) {
                        System.out.println("Calculated Value is " + calculatedValue);
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

//    public Float breakDownString(String s) {
//
//    }
}
