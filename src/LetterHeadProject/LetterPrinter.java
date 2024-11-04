
package LetterHeadProject;

/**
 *
 * @author rayray
 */
import java.util.Scanner;

public class LetterPrinter {
    
    public static Letterhead askForLetterheadData(Scanner input) {
        System.out.println("Enter business name:");
        String name = input.nextLine();
        
        System.out.println("Enter boundary character:");
        char boundaryChar = input.nextLine().charAt(0);
        
        String[] sloganLines = new String[4];
        System.out.println("Enter slogan (max 4 lines):");
        for (int i = 0; i < 4; i++) {
            sloganLines[i] = input.nextLine();
        }
        
        return new Letterhead(name, sloganLines, boundaryChar);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Letterhead header = askForLetterheadData(scanner);
        
        System.out.println("Your new letterhead:");
        System.out.println(header);
        
        scanner.close();
    }
}
