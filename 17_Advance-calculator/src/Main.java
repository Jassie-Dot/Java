import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         WELCOME TO CALCULATOR        ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        System.out.print("👉 Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("\n👋 Hello, " + name + "! Nice to meet you.\n");

        System.out.print("🤖 Do you want to continue? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("\n🔢 Enter number 1: ");
            double num1 = scanner.nextDouble();

            System.out.print("🔢 Enter number 2: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.println("\n🛠️  Choose an operation from below:");
            System.out.println("    ➕  +     ➖  -     ✖️  *     ➗  /");
            System.out.println("    🔼  max   🔽  min   📐  sqrt   🔁  round   ⚡ pow\n");

            System.out.print("👉 Enter your operation: ");
            String op = scanner.nextLine();

            System.out.println("\n═══════════ 📊 RESULT 📊 ═══════════=");

            switch (op.toLowerCase()) {
                case "+" -> System.out.println("✅ Sum: " + (num1 + num2));
                case "-" -> System.out.println("✅ Difference: " + (num1 - num2));
                case "*" -> System.out.println("✅ Product: " + (num1 * num2));
                case "/" -> {
                    if (num2 != 0)
                        System.out.println("✅ Quotient: " + (num1 / num2));
                    else
                        System.out.println("❌ Error: Division by zero");
                }
                case "max" -> System.out.println("🔼 Maximum: " + Math.max(num1, num2));
                case "min" -> System.out.println("🔽 Minimum: " + Math.min(num1, num2));
                case "sqrt" -> {
                    System.out.println("📐 Sqrt of " + num1 + ": " + Math.sqrt(num1));
                    System.out.println("📐 Sqrt of " + num2 + ": " + Math.sqrt(num2));
                }
                case "round" -> {
                    System.out.println("🔁 Rounded " + num1 + ": " + Math.round(num1));
                    System.out.println("🔁 Rounded " + num2 + ": " + Math.round(num2));
                }
                case "pow" -> {
                    System.out.print("⚡ Enter power for number 1: ");
                    int p1 = scanner.nextInt();
                    System.out.print("⚡ Enter power for number 2: ");
                    int p2 = scanner.nextInt();
                    System.out.println("⚡ " + num1 + " ^ " + p1 + " = " + Math.pow(num1, p1));
                    System.out.println("⚡ " + num2 + " ^ " + p2 + " = " + Math.pow(num2, p2));
                }
                default -> System.out.println("❌ Invalid operation. Please try again.");
            }

            System.out.println("══════════════════════════════════════");
            System.out.println("🙏 Thanks for using the calculator, " + name + "!");
        } else {
            System.out.println("\n👋 Goodbye, " + name + "! Have a great day!");
        }

        scanner.close();
    }
}
