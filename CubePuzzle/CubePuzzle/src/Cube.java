import java.util.HashSet;
import java.util.Set;

public class Cube {
    // Страните на куба (предна, задна, лява, дясна, горна, долна)
    private String[] sides;

    public Cube(String[] sides) {
        if (sides.length != 6) {
            throw new IllegalArgumentException("Кубчето трябва да има точно 6 страни.");
        }
        this.sides = sides.clone(); // Използваме копие, за да не променяме оригиналния масив
    }

    public String[] getSides() {
        return sides.clone();
    }

    public void rotateLeftRight(String[] cube) {
        String tempFront = cube[0];
        String tempBack = cube[1];
        String tempLeft = cube[2];
        String tempRight = cube[3];
        String tempTop = cube[4];
        String tempBottom = cube[5];

        cube[0] = tempLeft;
        cube[1] = tempRight;
        cube[2] = tempBack;
        cube[3] = tempFront;
        cube[4] = tempTop;
        cube[5] = tempBottom;
    }

    public void rotateFrontBack(String[] cube) {
        String tempFront = cube[0];
        String tempBack = cube[1];
        String tempLeft = cube[2];
        String tempRight = cube[3];
        String tempTop = cube[4];
        String tempBottom = cube[5];

        cube[0] = tempTop;
        cube[1] = tempBottom;
        cube[2] = tempLeft;
        cube[3] = tempRight;
        cube[4] = tempBack;
        cube[5] = tempFront;
    }

    public void rotateUpDown(String[] cube) {
        String tempFront = cube[0];
        String tempBack = cube[1];
        String tempLeft = cube[2];
        String tempRight = cube[3];
        String tempTop = cube[4];
        String tempBottom = cube[5];

        cube[0] = tempFront;
        cube[1] = tempBack;
        cube[2] = tempBottom;
        cube[3] = tempTop;
        cube[4] = tempLeft;
        cube[5] = tempRight;
    }

    public String getRotation() {
        return String.join("", sides);
    }

    public Set<String> generateAllRotations() {
        Set<String> uniqueCombinations = new HashSet<>();
        String[] currentSides = sides.clone();

        // Ротации по всички възможни оси
        for (int i = 0; i < 4; i++) { // 4 ротации около оста Y (горна и долна страна)
            for (int j = 0; j < 4; j++) { // 4 ротации около оста X (лява и дясна страна)
                for (int k = 0; k < 4; k++) { // 4 ротации около оста Z (предна и задна страна)
                    uniqueCombinations.add(String.join("", currentSides));
                    rotateUpDown(currentSides);
                }
                rotateFrontBack(currentSides);
            }
            rotateLeftRight(currentSides);
        }

        return uniqueCombinations;
    }
}
