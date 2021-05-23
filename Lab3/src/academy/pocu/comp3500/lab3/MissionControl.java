package academy.pocu.comp3500.lab3;

import java.util.ArrayList;

public final class MissionControl {
    private MissionControl() {
    }

    public static int findMaxAltitudeTime(final int[] altitudes) {
        int length = altitudes.length;

        if (length == 1) {
            return 0;
        }

        if (length == 0) {
            return -1;
        }

        if (altitudes[0] < altitudes[1] && altitudes[length - 2] < altitudes[length - 1]) {
            return length - 1;
        }

        if (altitudes[0] > altitudes[1] && altitudes[length - 2] > altitudes[length - 1]) {
            return 0;
        }

        int high = length - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (altitudes[mid] > altitudes[mid + 1] && altitudes[mid] > altitudes[mid - 1]) {
                return mid;
            } else if (mid == 0) {
                if (altitudes[0] > altitudes[1]) {
                    return 0;
                }
                return 1;
            }
            if (altitudes[mid] > altitudes[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return -1;
    }

    public static ArrayList<Integer> findAltitudeTimes(final int[] altitudes, final int targetAltitude) {

        ArrayList<Integer> result = new ArrayList<>();

        int length = altitudes.length;

        if (length == 0) {
            return result;
        }

        if (length == 1 || altitudes[0] < altitudes[1] && altitudes[length - 2] < altitudes[length - 1]
                || altitudes[0] > altitudes[1] && altitudes[length - 2] > altitudes[length - 1]) {
            return findAltitudeTimesRecur(altitudes, targetAltitude, 0, result);
        }

        for (int i = 0; i < altitudes.length; i++) {
            if (altitudes[i] == targetAltitude) {
                result.add(i);
                break;
            }
        }

        if (result.size() == 0){
            return result;
        }

        for (int i = altitudes.length - 1; i > result.get(0); i--) {
            if (altitudes[i] == targetAltitude) {
                result.add(i);
                break;
            }
        }

        return findAltitudeTimesRecur(altitudes, targetAltitude, 0, new ArrayList<>());
    }


    private static ArrayList<Integer> findAltitudeTimesRecur(final int[] altitudes, final int targetAltitude, int index, ArrayList<Integer> result) {
        if (index == altitudes.length || result.size() == 2) {
            return result;
        }

        if (altitudes[index] == targetAltitude) {
            result.add(index);
        }

        return findAltitudeTimesRecur(altitudes, targetAltitude, index + 1, result);
    }
}