package utilities;
import java.util.Scanner;

public class PageObjectGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean continueGenerating = true;

        while (continueGenerating) {
            // Prompt the user to input the Xpath
            System.out.print("Enter the Xpath: ");
            String Xpath = scanner.nextLine();

            // Prompt the user to input the object name
            System.out.print("Enter the object name: ");
            String objectName = scanner.nextLine();

            String Object_Name1 = objectName.replaceAll(" ", "_");
            String Object_Name2 = objectName.replaceAll("\\s", "");

            // Format the @FindBy annotation string with the provided xpath
            String findByAnnotation = "@FindBy(xpath = \"" + Xpath + "\")";

            // Print the formatted code with the user-provided object name
            System.out.println(findByAnnotation);
            System.out.println("\tprivate WebElement " + Object_Name1 + ";");
            System.out.println();
            System.out.println("\tpublic WebElement " + Object_Name2 + "() {");
            System.out.println("\t\treturn " + Object_Name1 + ";");
            System.out.println("\t}");

            // Ask user if they want to continue
            System.out.print("\n\n Do you want to generate another Page Object? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();

            // Check the user's response
            if (!response.equals("yes")) {
                continueGenerating = false; // Exit the loop if the user does not want to continue
            }
        }

        // Close the scanner
        scanner.close();
    }
}
