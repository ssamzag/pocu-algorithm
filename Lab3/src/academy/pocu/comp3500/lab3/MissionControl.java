package academy.pocu.comp3500.lab3;

import java.util.ArrayList;

public final class MissionControl {
    private MissionControl() {
    }

    public static int findMaxAltitudeTime(final int[] altitudes) {
        int length = altitudes.length;
        if (length == 1) {
            return 0;
        } else if (length == 0) {
            return -1;
        }

        if (altitudes[0] < altitudes[1] && altitudes[length - 2] < altitudes[length - 1]) {
            return length - 1;
        } else if (altitudes[0] > altitudes[1] && altitudes[length - 2] > altitudes[length - 1]) {
            return 0;
        } else {
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
        }

        return -1;
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
        return findAltitudeTimesRecur(altitudes, targetAltitude, 0, new ArrayList<>());
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