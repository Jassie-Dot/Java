ṇimport javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

public class DarkModeCalculator extends JFrame implements ActionListener, KeyListener {

    private JTextField display;
    private StringBuilder input;
    private Clip keySound;

    public DarkModeCalculator() {
        setTitle("Futuristic Dark Calculator");
        setSize(420, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.BLACK);

        input = new StringBuilder();
        loadKeySound();

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(Color.BLACK);
        displayPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Consolas", Font.BOLD, 38));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(Color.DARK_GRAY);
        display.setForeground(Color.GREEN);
        display.setCaretColor(Color.WHITE);
        display.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        display.addKeyListener(this);
        displayPanel.add(display, BorderLayout.CENTER);

        add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        String[] buttons = {
                "C", "/", "*", "<-",
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                "0", ".", " ", " "
        };

        for (String text : buttons) {
            if (text.equals(" ")) {
                buttonPanel.add(new JLabel());
                continue;
            }
            JButton button = new JButton(text);
            button.setFont(new Font("Segoe UI", Font.BOLD, 22));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.GREEN);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.addActionListener(this);

            button.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    button.setBackground(Color.GRAY);
                }
                public void mouseExited(MouseEvent e) {
                    button.setBackground(Color.DARK_GRAY);
                }
            });

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setFocusable(true);
        addKeyListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        display.requestFocusInWindow();
        playKeySound();
        processInput(e.getActionCommand());
    }

    private void processInput(String command) {
        switch (command) {
            case "C":
                input.setLength(0);
                break;
            case "<-":
                if (input.length() > 0) input.setLength(input.length() - 1);
                break;
            case "=":
                try {
                    input = new StringBuilder("" + eval(input.toString()));
                } catch (Exception ex) {
                    input = new StringBuilder("Error");
                }
                break;
            default:
                input.append(command);
                break;
        }
        display.setText(input.toString());
    }

    public double eval(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                while (true) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                return x;
            }
        }.parse();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (Character.isDigit(keyChar) || ".+-*/".indexOf(keyChar) >= 0) {
            input.append(keyChar);
            display.setText(input.toString());
            playKeySound();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_BACK_SPACE && input.length() > 0) {
            input.setLength(input.length() - 1);
            playKeySound();
        } else if (keyCode == KeyEvent.VK_ENTER) {
            try {
                input = new StringBuilder("" + eval(input.toString()));
            } catch (Exception ex) {
                input = new StringBuilder("Error");
            }
            playKeySound();
        } else if (keyCode == KeyEvent.VK_ESCAPE) {
            input.setLength(0);
            playKeySound();
        }
        display.setText(input.toString());
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void loadKeySound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("key.wav"));
            keySound = AudioSystem.getClip();
            keySound.open(audioInputStream);
        } catch (Exception e) {
            System.out.println("Sound error: " + e.getMessage());
        }
    }

    private void playKeySound() {
        if (keySound != null) {
            if (keySound.isRunning()) keySound.stop();
            keySound.setFramePosition(0);
            keySound.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DarkModeCalculator::new);
    }
}
