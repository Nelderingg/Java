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
        
        // Handle the assignment instruction
        String varnameL = parts[0];
        
        
        // If the instruction is of the form varnameL = intValue
        if (parts.length == 3 && parts[1].equals("=")) 
        {
                int intValue = Integer.parseInt(parts[2]);
                // Assign the intValue to varnameL
                variables.put(varnameL, intValue);
                System.out.println(intValue);
                return true;
        }

        else if (parts.length == 1)
        {
            String varname = parts[0];

            if (variables.containsKey(varname))
            {
                System.out.println(variables.get(varname));
                return true;
            }
            else
            {
                System.out.println("No value stored in the variable" + varname);
                return true;
            }
        }

        // If the instruction is of the form varnameL = varnameR1 operation varnameR2
        else if (parts.length == 5 && parts[1].equals("="))
        {
            String varnameR1 = parts[2];
            String operation = parts[3];
            String varnameR2 = parts[4];
            int valueR1;
            int valueR2;
            
            // // Check if varnameR1 and varnameR2 have been assigned values
            // if (!variables.containsKey(varnameR1) || !variables.containsKey(varnameR2)) {
            //     // Variables on the right not assigned values
            //     return false;
            // }

            if (variables.containsKey(varnameR1))
            {
                valueR1 = variables.get(varnameR1);
            }

            else
            {
                valueR1 = Integer.parseInt(varnameR1);
            }

            if (variables.containsKey(varnameR2))
            {
                valueR2 = variables.get(varnameR2);
            }

            else
            {
                valueR2 = Integer.parseInt(varnameR2);
            }

            
            // Get the values of varnameR1 and varnameR2
            // int valueR1 = variables.get(varnameR1);
            // int valueR2 = variables.get(varnameR2);
            
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
        }
        else
        {
            // Invalid instruction format
            return false;
        }
    }
}
