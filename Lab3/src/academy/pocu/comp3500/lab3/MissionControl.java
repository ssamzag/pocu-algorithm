package academy.pocu.comp3500.lab3;

import java.util.ArrayList;

public final class MissionControl {
    private MissionControl() {
    }

    public static int findMaxAltitudeTime(final int[] altitudes) {
        return findMaxAltitudeTimeRecur(altitudes, 0, 0);
    }

    private static int findMaxAltitudeTimeRecur(final int[] altitudes, int maxIndex, int index) {
        if (altitudes.length <= index) {
            return maxIndex;
        }

        int foundMaxIndex = maxIndex;

        if (altitudes[index] >= altitudes[maxIndex]) {
            foundMaxIndex = index;
        }

        return findMaxAltitudeTimeRecur(altitudes, foundMaxIndex, index + 1);
    }

    public static ArrayList<Integer> findAltitudeTimes(final int[] altitudes, final int targetAltitude) {
        return findAltitudeTimesRecur(altitudes, targetAltitude, 0,  new ArrayList<>());
    }

    private static ArrayList<Integer> findAltitudeTimesRecur(final int[] altitudes, final int targetAltitude, int index, ArrayList<Integer> result) {
        if (index == altitudes.length) {
            return result;
        }

        if (altitudes[index] == targetAltitude) {
            result.add(index);
        }

        return findAltitudeTimesRecur(altitudes, targetAltitude, index + 1, result);
    }
}