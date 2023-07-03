import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReconstructedStringFromArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        // примерен вход:
        //###Z, 6$$W, A456, W#$$$, e5555
        String[] array= scanner.nextLine().split(", ");
        String result = reconstructedMethod(array);
        System.out.println(result);
    }

    private static String reconstructedMethod(String[] array) {
        StringBuilder reconstructedString = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        String firstString = "";
        String lastString = "";
        for (int i = 0; i < array.length; i++) {
            String currentString = array[i];
            char firstChar = currentString.charAt(0);
            char lastChar = currentString.charAt(currentString.length()-1);
            if(firstChar=='A'){
                firstString=currentString;
                reconstructedString.append(firstString);
            } else if (lastChar=='Z') {
                lastString = currentString;
            }else {
                stringList.add(currentString);
            }

        }
        String firsElementInList = stringList.get(0);
        if(firstString.charAt(firstString.length()-1) !=firsElementInList.charAt(0)){
            reconstructedString.append(firsElementInList);
        }else {
            String stringForAdd=firsElementInList.substring(1);
            reconstructedString.append(stringForAdd);
        }
        for (int i = 0; i < stringList.size()-1; i++) {
            String currentString = stringList.get(i);
            char lastChar = currentString.charAt(currentString.length()-1);
            String nextString = stringList.get(i+1);
            char firstChar = nextString.charAt(0);
            if(lastChar==firstChar){
                String stringForAdd = nextString.substring(1);
                reconstructedString.append(stringForAdd);

            } else {
                reconstructedString.append(nextString);
            }

        }
        reconstructedString.append(lastString);
        return reconstructedString.toString();
    }
}
