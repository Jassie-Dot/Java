import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ShoppingCartApp extends JFrame implements ActionListener {

    private JTextField nameField, phoneField, itemField, priceField, quantityField;
    private JTextArea receiptArea;
    private JTable cartTable;
    private DefaultTableModel tableModel;

    public ShoppingCartApp() {
        setTitle("🛒 Shopping Cart (Full Dark Mode)");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color bgDark = new Color(25, 25, 25);
        Color panelDark = new Color(35, 35, 35);
        Color textColor = Color.WHITE;
        Color borderColor = new Color(60, 60, 60);
        Color accentColor = new Color(0, 180, 255);

        Font font = new Font("Segoe UI", Font.BOLD, 13);

        JPanel panel = new JPanel();
        panel.setBackground(bgDark);
        panel.setLayout(null);

        // Customer Info
        JLabel nameLabel = new JLabel("Customer Name:");
        styleLabel(nameLabel, textColor, font);
        nameLabel.setBounds(30, 20, 130, 25);
        panel.add(nameLabel);

        nameField = createDarkField();
        nameField.setBounds(160, 20, 200, 25);
        panel.add(nameField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        styleLabel(phoneLabel, textColor, font);
        phoneLabel.setBounds(400, 20, 120, 25);
        panel.add(phoneLabel);

        phoneField = createDarkField();
        phoneField.setBounds(520, 20, 200, 25);
        panel.add(phoneField);

        // Item Inputs
        JLabel itemLabel = new JLabel("Item:");
        styleLabel(itemLabel, textColor, font);
        itemLabel.setBounds(30, 70, 50, 25);
        panel.add(itemLabel);

        itemField = createDarkField();
        itemField.setBounds(80, 70, 150, 25);
        panel.add(itemField);

        JLabel priceLabel = new JLabel("Price:");
        styleLabel(priceLabel, textColor, font);
        priceLabel.setBounds(250, 70, 50, 25);
        panel.add(priceLabel);

        priceField = createDarkField();
        priceField.setBounds(300, 70, 100, 25);
        panel.add(priceField);

        JLabel quantityLabel = new JLabel("Quantity:");
        styleLabel(quantityLabel, textColor, font);
        quantityLabel.setBounds(420, 70, 70, 25);
        panel.add(quantityLabel);

        quantityField = createDarkField();
        quantityField.setBounds(500, 70, 100, 25);
        panel.add(quantityField);

        JButton addButton = new JButton("➕ Add to Cart");
        addButton.setBounds(620, 70, 150, 30);
        styleButton(addButton, accentColor);
        addButton.addActionListener(this);
        panel.add(addButton);

        // Table
        String[] columns = {"Item", "Price", "Quantity", "Subtotal"};
        tableModel = new DefaultTableModel(columns, 0);
        cartTable = new JTable(tableModel);
        cartTable.setBackground(panelDark);
        cartTable.setForeground(textColor);
        cartTable.setGridColor(borderColor);
        cartTable.setRowHeight(24);
        cartTable.setFont(new Font("Consolas", Font.PLAIN, 13));

        JTableHeader header = cartTable.getTableHeader();
        header.setBackground(new Color(50, 50, 50));
        header.setForeground(Color.WHITE);
        header.setFont(font);
        header.setReorderingAllowed(false);

        JScrollPane tableScroll = new JScrollPane(cartTable);
        styleScrollBar(tableScroll);
        tableScroll.setBounds(30, 120, 800, 200);
        panel.add(tableScroll);

        // Receipt Area
        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        receiptArea.setBackground(panelDark);
        receiptArea.setForeground(textColor);
        receiptArea.setCaretColor(Color.WHITE);
        receiptArea.setBorder(new LineBorder(borderColor));

        JScrollPane receiptScroll = new JScrollPane(receiptArea);
        styleScrollBar(receiptScroll);
        receiptScroll.setBounds(30, 330, 800, 200);
        panel.add(receiptScroll);

        // Buttons
        JButton generateBtn = new JButton("🧾 Generate Receipt");
        generateBtn.setBounds(100, 550, 180, 40);
        styleButton(generateBtn, new Color(0, 150, 100));
        generateBtn.addActionListener(e -> generateReceipt());
        panel.add(generateBtn);

        JButton printBtn = new JButton("🖨️ Print");
        printBtn.setBounds(320, 550, 120, 40);
        styleButton(printBtn, new Color(100, 100, 250));
        printBtn.addActionListener(e -> printReceipt());
        panel.add(printBtn);

        JButton resetBtn = new JButton("🔄 Reset");
        resetBtn.setBounds(470, 550, 120, 40);
        styleButton(resetBtn, new Color(90, 90, 90));
        resetBtn.addActionListener(e -> resetForm());
        panel.add(resetBtn);

        JButton exitBtn = new JButton("❌ Exit");
        exitBtn.setBounds(620, 550, 120, 40);
        styleButton(exitBtn, new Color(180, 50, 50));
        exitBtn.addActionListener(e -> System.exit(0));
        panel.add(exitBtn);

        add(panel);
    }

    private JTextField createDarkField() {
        JTextField field = new JTextField();
        field.setBackground(new Color(40, 40, 40));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(new LineBorder(new Color(70, 70, 70)));
        return field;
    }

    private void styleScrollBar(JScrollPane scroll) {
        scroll.getViewport().setBackground(new Color(35, 35, 35));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60)));
    }

    private void styleLabel(JLabel label, Color color, Font font) {
        label.setForeground(color);
        label.setFont(font);
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String item = itemField.getText();
            double price = Double.parseDouble(priceField.getText());
            int qty = Integer.parseInt(quantityField.getText());
            double subtotal = price * qty;

            tableModel.addRow(new Object[]{item, format(price), qty, format(subtotal)});

            itemField.setText("");
            priceField.setText("");
            quantityField.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid item, price, and quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateReceipt() {
        String name = nameField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter customer name and phone number.", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("         🧾 SHOPPING RECEIPT\n");
        receipt.append("============================================\n");
        receipt.append("Customer: ").append(name).append("\n");
        receipt.append("Phone   : ").append(phone).append("\n");
        receipt.append("--------------------------------------------\n");
        receipt.append(String.format("%-20s %-8s %-8s %-10s\n", "Item", "Price", "Qty", "Subtotal"));

        double grandTotal = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String item = tableModel.getValueAt(i, 0).toString();
            double price = Double.parseDouble(tableModel.getValueAt(i, 1).toString().replace("$", ""));
            int qty = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            double subtotal = price * qty;
            grandTotal += subtotal;

            receipt.append(String.format("%-20s $%-7.2f %-8d $%-9.2f\n", item, price, qty, subtotal));
        }

        receipt.append("--------------------------------------------\n");
        receipt.append(String.format("TOTAL: $%.2f\n", grandTotal));
        receipt.append("============================================\n");
        receipt.append("Thank you for shopping with us!\n");

        receiptArea.setText(receipt.toString());
    }

    private void printReceipt() {
        try {
            receiptArea.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Print error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetForm() {
        nameField.setText("");
        phoneField.setText("");
        itemField.setText("");
        priceField.setText("");
        quantityField.setText("");
        receiptArea.setText("");
        tableModel.setRowCount(0);
    }

    private String format(double num) {
        return "$" + new DecimalFormat("0.00").format(num);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartApp().setVisible(true));
    }
}
