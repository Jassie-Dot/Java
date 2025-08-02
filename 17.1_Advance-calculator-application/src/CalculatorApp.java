import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame {
    private JTextField number1Field, number2Field;
    private JComboBox<String> operationBox;
    private JTextArea resultArea;

    public CalculatorApp() {
        setTitle("🔮 Futuristic Calculator");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30)); // Dark mode background

        Font font = new Font("Segoe UI", Font.PLAIN, 16);
        Font titleFont = new Font("Segoe UI Emoji", Font.BOLD, 20);

        // 🔷 Title Panel
        JLabel title = new JLabel("🤖 Smart Calculator - GUI Edition", SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(Color.CYAN);
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // 🔸 Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 12, 12));
        inputPanel.setBackground(new Color(45, 45, 45));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label1 = new JLabel("🔢 Enter Number 1:");
        label1.setForeground(Color.WHITE);
        number1Field = new JTextField();

        JLabel label2 = new JLabel("🔢 Enter Number 2:");
        label2.setForeground(Color.WHITE);
        number2Field = new JTextField();

        JLabel label3 = new JLabel("🛠️ Choose Operation:");
        label3.setForeground(Color.WHITE);
        operationBox = new JComboBox<>(new String[]{
                "+", "-", "*", "/", "max", "min", "sqrt", "round", "pow"
        });

        JButton calculateBtn = createButton("🔍 Calculate");
        JButton exitBtn = createButton("❌ Exit");

        inputPanel.add(label1); inputPanel.add(number1Field);
        inputPanel.add(label2); inputPanel.add(number2Field);
        inputPanel.add(label3); inputPanel.add(operationBox);
        inputPanel.add(calculateBtn); inputPanel.add(exitBtn);

        add(inputPanel, BorderLayout.CENTER);

        // 🔹 Result Area
        resultArea = new JTextArea(6, 30);
        resultArea.setFont(new Font("Consolas", Font.BOLD, 14));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBackground(new Color(20, 20, 20));
        resultArea.setForeground(Color.GREEN);
        resultArea.setBorder(BorderFactory.createTitledBorder("📊 Result"));

        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        // 🔘 Button Actions
        calculateBtn.addActionListener(e -> calculate());
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2, true));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void calculate() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            String op = (String) operationBox.getSelectedItem();
            StringBuilder result = new StringBuilder("📊 Result:\n");

            switch (op) {
                case "+" -> result.append("✅ Sum: ").append(num1 + num2);
                case "-" -> result.append("✅ Difference: ").append(num1 - num2);
                case "*" -> result.append("✅ Product: ").append(num1 * num2);
                case "/" -> {
                    if (num2 != 0)
                        result.append("✅ Quotient: ").append(num1 / num2);
                    else
                        result.append("❌ Error: Division by zero");
                }
                case "max" -> result.append("🔼 Max: ").append(Math.max(num1, num2));
                case "min" -> result.append("🔽 Min: ").append(Math.min(num1, num2));
                case "sqrt" -> {
                    result.append("📐 Sqrt of ").append(num1).append(": ").append(Math.sqrt(num1)).append("\n");
                    result.append("📐 Sqrt of ").append(num2).append(": ").append(Math.sqrt(num2));
                }
                case "round" -> {
                    result.append("🔁 Rounded ").append(num1).append(": ").append(Math.round(num1)).append("\n");
                    result.append("🔁 Rounded ").append(num2).append(": ").append(Math.round(num2));
                }
                case "pow" -> {
                    int p1 = Integer.parseInt(JOptionPane.showInputDialog(this, "⚡ Enter power for number 1:"));
                    int p2 = Integer.parseInt(JOptionPane.showInputDialog(this, "⚡ Enter power for number 2:"));
                    result.append("⚡ ").append(num1).append("^").append(p1).append(" = ").append(Math.pow(num1, p1)).append("\n");
                    result.append("⚡ ").append(num2).append("^").append(p2).append(" = ").append(Math.pow(num2, p2));
                }
                default -> result.append("❌ Invalid operation.");
            }

            resultArea.setText(result.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "❌ Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp().setVisible(true));
    }
}
