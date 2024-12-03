import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CubesCombination {
    private final List<List<String>> allRotations;

    public CubesCombination(List<List<String>> allRotations) {
        this.allRotations = allRotations;

    }
    public List<List<String>> findAllCubesCombination() {
        List<List<String>> allSolutions = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, allSolutions);
        return allSolutions;
    }

    public void backtrack(List<String> currentSolution, int index, List<List<String>> allSolutions) {
        if (index == allRotations.size()) {
            if (isValidCubesCombination(currentSolution)) {
                allSolutions.add(new ArrayList<>(currentSolution)); // Добавяне на валидното решение
            }
            return;
        }

        for (String rotation : allRotations.get(index)) {
            currentSolution.add(rotation);
            backtrack(currentSolution, index + 1, allSolutions);
            currentSolution.remove(currentSolution.size() - 1); // Връщане назад
        }
    }


    public boolean isValidCubesCombination(List<String> currentSolution) {
        int n = currentSolution.size();
        for (int side = 0; side < 4; side++) {
            Set<Character> colors = new HashSet<>();
            for (String config : currentSolution) {
                colors.add(config.charAt(side));
            }
            if (colors.size() != n) {
                return false;
            }
        }
        return true;
    }

}
