package utilities;

import java.util.Scanner;

public class StepDefinitionGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the steps (type 'exit' on a new line to finish):");

            StringBuilder inputSteps = new StringBuilder();
            String line;

            while (true) {
                line = scanner.nextLine();

                if (line.isEmpty()) {
                    // When the user hits enter (blank input), generate step definitions
                    if (inputSteps.length() > 0) {
                        break;
                    }
                } else if (line.equalsIgnoreCase("exit")) {
                    // Exit the program
                    break;
                } else {
                    inputSteps.append(line).append("\n");
                }
            }

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            generateStepDefinitions(inputSteps.toString());
        }

        scanner.close();
    }

    public static void generateStepDefinitions(String inputSteps) {
        String[] steps = inputSteps.split("\n");

        for (String step : steps) {
            String[] words = step.trim().split(" ", 2);
            if (words.length < 2) {
                System.out.println("Invalid step: " + step);
                continue;
            }

            String stepType = words[0];
            String stepDescription = words[1];

            // Construct the step definition
            String stepDefinition = String.format("@%s(\"%s\")%npublic void " + stepDescription.replaceAll(" ", "_") + "() {%n    // Implement your logic here%n}%n",
                    stepType, stepDescription);

            System.out.println(stepDefinition);
            System.out.println();
        }
    }
}
