
package LetterHeadProject;

/**
 *
 * @author rayray
 */
public class Letterhead {
    private String name;
    private String[] sloganLines;
    private char boundaryChar;

    public Letterhead(String name, String[] sloganLines, char boundaryChar) {
        this.name = name;
        this.sloganLines = new String[4];
        System.arraycopy(sloganLines, 0, this.sloganLines, 0, Math.min(sloganLines.length, 4));
        this.boundaryChar = boundaryChar;
    }

    public String getName() {
        return name;
    }

    public char getBoundaryChar() {
        return boundaryChar;
    }

    public String getSlogan() {
        StringBuilder slogan = new StringBuilder();
        for (String line : sloganLines) {
            if (line != null) {
                slogan.append(line).append("\n");
            }
        }
        return slogan.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoundaryChar(char boundaryChar) {
        this.boundaryChar = boundaryChar;
    }

    public void setSlogan(String[] sloganLines) {
        this.sloganLines = new String[4];
        System.arraycopy(sloganLines, 0, this.sloganLines, 0, Math.min(sloganLines.length, 4));
    }

 
    @Override
    public String toString() {
        StringBuilder letterhead = new StringBuilder();
        int remainingLines = 9;

        //first boundary line
        letterhead.append(generateBoundaryLine()).append("\n");
        remainingLines--;

        //business name line
        letterhead.append(boundaryChar).append(" ").append(name).append(" ");
        int spacesAfterName = 40 - name.length() - 4;
        for (int i = 0; i < spacesAfterName; i++) {
            letterhead.append(" ");
        }
        letterhead.append(boundaryChar).append("\n");
        remainingLines--;
        
        //I had to brute force the spacing between the company name and slogan to make it look neater
        letterhead.append(boundaryChar).append("                                      ").append(boundaryChar).append("\n");
        remainingLines--;

        //slogan lines
        for (String line : sloganLines) {
            if (line != null && remainingLines > 0) {
                letterhead.append(boundaryChar).append(" ").append(line);
                int spacesAfterSlogan = 40 - line.length() - 3;
                for (int i = 0; i < spacesAfterSlogan; i++) {
                    letterhead.append(" ");
                }
                letterhead.append(boundaryChar).append("\n");
                remainingLines--;
            }
        }

        //remaining blank lines if applicable
        for (int i = 0; i < remainingLines - 1; i++) {
            letterhead.append(generateBoundaryLine()).append("\n");
        }


        return letterhead.toString();
    }



    private String generateBoundaryLine() {
        StringBuilder boundaryLine = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            boundaryLine.append(boundaryChar);
        }
        return boundaryLine.toString();
    }
}

