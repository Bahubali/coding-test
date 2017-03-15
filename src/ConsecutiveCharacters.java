/**
 * Created by bahubali.n on 06/03/17.
 */
public class ConsecutiveCharacters {

    public static void main(String[] args) {
        String inputString = "BCZYXABCCD";
        consCharacters(inputString);
    }

    public static void consCharacters(String word) {

        int currentIndex = 0;
        while (currentIndex < word.length()) {
            if (currentIndex == 0) {
                System.out.print(word.charAt(currentIndex));
            } else {
                char prevCharacter = word.charAt(currentIndex - 1);
                int prevCharacterVal = Character.getNumericValue(prevCharacter);
                int characterVal = Character.getNumericValue(word.charAt(currentIndex));
                if ((prevCharacterVal + 1 == characterVal) || (characterVal + 1 == prevCharacterVal)) {
                    System.out.print(word.charAt(currentIndex));
                } else {
                    System.out.println();
                    System.out.print(word.charAt(currentIndex));
                }
            }
            currentIndex++;
        }
    }
}
