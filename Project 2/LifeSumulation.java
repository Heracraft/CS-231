
public class LifeSumulation {

    public static String arrayToString(String[] arr) {
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(arr[i]);
            output += String.format("%5s ", arr[i]);
        }
        output += "\n";
        return output;
    }

    public static String arrayToString(String[][] arr) {
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            String[] item = arr[i];
            // System.out.println(item);
            output += arrayToString(item);

        }
        return output;
    }

    private static void takeRequiredPictures(Landscape landscape, LandscapeDisplay display) {
        display.saveImage("assets/initial state.png");

        landscape.advance();

        display.repaint();

        display.saveImage("assets/n+1 state.png");
    }

    private static void generateGif(Landscape landscape, LandscapeDisplay display) {
        for (int i = 0; i < 100; i++) {
            landscape.advance();
            display.repaint();

            display.saveImage("assets/frames/frame-%s.png".formatted(i + 1));
            try {

                Thread.sleep(250);
            } catch (Exception e) {
                // ignore InterruptedException thrown by thread.sleep, but catch all else
                if (!(e instanceof InterruptedException)) {
                    System.err.println(e);
                }

            }
        }
    }

    public static String[][] experiment(double step, double lowerChance, double maxChance) {
        int experimentCount = (int) Math.round((maxChance - lowerChance) / step);
        String[][] results = new String[experimentCount][2];

        double chance = lowerChance;
        int interations = 1000;

        for (int i = 0; i < experimentCount; i++) {
            Landscape landscape = new Landscape(100, 100, chance);

            for (int j = 0; j < interations; j++) {
                landscape.advance();
            }

            int noOfLivingCells = 0;

            for (int rowIndex = 0; rowIndex < landscape.getRows(); rowIndex++) {
                for (int colIndex = 0; colIndex < landscape.getCols(); colIndex++) {
                    if (landscape.getCell(rowIndex, colIndex).getAlive()) {
                        noOfLivingCells++;
                    }
                }
            }

            String[] newResult = new String[] { String.valueOf(chance), String.valueOf(noOfLivingCells) };

            results[i] = newResult;

            chance += step;
        }

        return results;
    }

    public static void main(String[] args) {
        int rows = 100;
        int cols = 100;
        double chance = 0.2;

        int[] iterations = { 10, 100, 1000, 10000 };

        double maxChance = 1;
        double lowerChance = 0;
        double step = 0.1;
        // int[] iterations = { 10};

        if (args.length == 2) {
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);
        }

        Landscape landscape = new Landscape(rows, cols, chance);

        // LandscapeDisplay display = `new LandscapeDisplay(landscape, 15);

        // takeRequiredPictures(landscape, display); // uncomment to take flics

        // generateGif(landscape, display); // uncomment to generate new gif

        String[][] results = experiment(step, lowerChance, maxChance);

        // arrayToString(results);

        System.out.println(arrayToString(results));
    }

}