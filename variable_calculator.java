import java.util.Hashtable;
import java.util.Scanner;

public class variable_calculator{
    private static Hashtable<String, Integer> variables = new Hashtable<>();
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine().trim();
            
            if (line.equals("QUIT"))
            {
                // Quit the program
                System.exit(0);
            }
            
            if (!processInstruction(line))
            {
                // If there was an error in the instruction, print ERROR and exit the program
                System.out.println("ERROR");
                System.exit(0);
            }
        }
        
        scanner.close();
    }

    private static boolean processInstruction(String instruction) {
        // Split the instruction into parts
        String[] parts = instruction.split("\\s+");
        
        if (parts.length != 3 && parts.length != 5) {
            return false;
        }
        
        // Handle the assignment instruction
        String varnameL = parts[0];
        
        if (variables.containsKey(varnameL)) {
            // Variable on the left already assigned a value
            return false;
        }
        
        // If the instruction is of the form varnameL = intValue
        if (parts.length == 3 && parts[1].equals("=")) {
                int intValue = Integer.parseInt(parts[2]);
                // Assign the intValue to varnameL
                variables.put(varnameL, intValue);
                System.out.println(intValue);
                return true;
        }
        // If the instruction is of the form varnameL = varnameR1 operation varnameR2
        else if (parts.length == 5 && parts[1].equals("=")){
            String varnameR1 = parts[2];
            String operation = parts[3];
            String varnameR2 = parts[4];
            
            // Check if varnameR1 and varnameR2 have been assigned values
            if (!variables.containsKey(varnameR1) || !variables.containsKey(varnameR2)) {
                // Variables on the right not assigned values
                return false;
            }
            
            // Get the values of varnameR1 and varnameR2
            int valueR1 = variables.get(varnameR1);
            int valueR2 = variables.get(varnameR2);
            
            // Perform the operation and assign the result to varnameL
            int result;
            switch (operation) {
                case "+":
                    result = valueR1 + valueR2;
                    break;
                case "-":
                    result = valueR1 - valueR2;
                    break;
                case "*":
                    result = valueR1 * valueR2;
                    break;
                case "/":
                    result = valueR1 / valueR2;
                default:
                    // Invalid operation
                    return false;
            }
            
            variables.put(varnameL, result);
            System.out.println(result);
            return true;
        } else {
            // Invalid instruction format
            return false;
        }
    }
}
