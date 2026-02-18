import java.util.Random;

public class Shuffle {
    public static void main(String[] args) {
        ArrayList<Integer> arr0 = new ArrayList<Integer>();

        Random randomGenerator = new Random();

        for (int index=0; index<=10;index++){
            int randomNumber = randomGenerator.nextInt(0, 99);

            // System.out.println(randomNumber);

            arr0.add(randomNumber);
        }

        ArrayList<Integer> oldArr = arr0.clone();

        for (int index = 0; index < arr0.size(); index++) {
            int randomIndex = randomGenerator.nextInt(0, arr0.size());

            int removedItem = arr0.remove(randomIndex);
            arr0.add(removedItem);

        }

        System.out.println("Old array: %s".formatted(oldArr.toString()));
        System.out.println("New array: %s".formatted(arr0.toString()));
    }
}