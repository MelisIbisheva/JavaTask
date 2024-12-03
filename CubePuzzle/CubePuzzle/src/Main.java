import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Входна конфигурация на куба
        Scanner scanner = new Scanner(System.in);
        //Въвеждане на конфигурациите на кубчетата на един ред
        System.out.println("Въведете страните на кубчетата, разделени със запетаи (например: RBGYBY,RGGYBB,YBRGYR,YGBRRR):");
        String inputLine = scanner.nextLine().trim();

        // Разделяне на входа по запетаи
        String[] inputs = inputLine.split(",");

        // Проверка дали всяка конфигурация е валидна
        for (String input : inputs) {
            if (input.length() != 6) {
                System.out.println("Данните за кубчето трябва да съдържат точно 6 символа. Невалиден вход: " + input);
                return; // Прекратява изпълнението, ако има невалиден вход
            }
        }

        List<Cube> allCubes = new ArrayList<>();
        List<List<String>> allRotations = new ArrayList<>();
        // Обработка на всяка конфигурация
        for (String input : inputs) {
            // Създаване на масив за страните на текущото кубче
            String[] cubeArray = new String[6];
            for (int i = 0; i < 6; i++) {
                cubeArray[i] = String.valueOf(input.charAt(i));
            }

            // Създаване на обект от клас MyCube
            Cube cube = new Cube(cubeArray);

            // Генериране на всички уникални ротации за текущото кубче
            Set<String> uniqueRotation = cube.generateAllRotations();
            allCubes.add(cube);
            allRotations.add(new ArrayList<>(uniqueRotation));

//            // Извеждане на резултатите за текущото кубче
//            System.out.println("Уникални ротации за кубчето " + input + ":");
//            for (String combination : uniqueRotation) {
//                System.out.println(combination);
//            }
//            System.out.println("--------------------------------------------");
        }


        CubesCombination cubesCombination = new CubesCombination(allRotations);
        List<List<String>> allSolutions = cubesCombination.findAllCubesCombination();

        if (!allSolutions.isEmpty()) {
            System.out.println("Намерени комбинации от кубчета:");
            for (List<String> solution : allSolutions) {
                System.out.println("Комбинация:");
                for (String config : solution) {
                    System.out.println(config);
                }
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Няма намерени комбинации.");
        }


        scanner.close();

    }


}