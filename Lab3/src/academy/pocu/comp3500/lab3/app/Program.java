package academy.pocu.comp3500.lab3.app;

import academy.pocu.comp3500.lab3.MissionControl;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        {
            final int[] altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 2 };

            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);

            //assert (maxAltitudeTime == 6);
        }

//        {
//            final int[] altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 2 };
//
//            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
//
//            assert (bounds.size() == 2);
//
//            assert (bounds.get(0) == 1);
//            assert (bounds.get(1) == 9);
//
//            bounds = MissionControl.findAltitudeTimes(altitudes, 5);
//
//            assert (bounds.size() == 1);
//            assert (bounds.get(0) == 4);
//        }
        testFindMax();
        testFindTimes();
        pocuTest();
        otherTest2();
        otherTest3();
        otherTest4();
    }

    private static void testFindMax() {
        int[] altitudes = new int[] { 1, 2, 5, 7, 9, 12, 14, 16, 19, 21 };
        int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 9);

        altitudes = new int[] { 91, 82, 75, 67, 59, 42, 34, 26, 19, 9 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 0);

        altitudes = new int[] { 1, 2, 5, 7, 9, 12, 14, 16, 19, 21 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 9);

        altitudes = new int[] { 91, 82, 75, 67, 59, 42, 34, 26, 19, 9 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 0);

        altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 6);

        altitudes = new int[] { 1, 7, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 1);

        altitudes = new int[] { 1, 9, 4, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 1);

        altitudes = new int[] { 1, 7, 9, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 2);

        altitudes = new int[] { 9 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 0);

        altitudes = new int[] { 1, 7, 9, 11, 13, 16, 18, 21, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 7);

        altitudes = new int[] { 1, 7, 9, 11, 13, 16, 18, 21, 34, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 8);

        altitudes = new int[] { 6, 89, 74, 54, 43, 33, 28, 13, 7, 3 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 1);

        altitudes = new int[] { 6, 89, 74, 54, 43, 33, 28, 13, 7, 3, 2 };
        maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
        assert (maxAltitudeTime == 1);
    }

    private static void testFindTimes() {
        int[] altitudes = new int[] { 1, 2, 5, 7, 9, 12, 14, 16, 19, 21 };
        ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 7);
        assert (bounds.size() == 1);
        assert (bounds.contains(3));
        bounds = MissionControl.findAltitudeTimes(altitudes, 16);
        assert (bounds.size() == 1);
        assert (bounds.contains(7));
        bounds = MissionControl.findAltitudeTimes(altitudes, 19);
        assert (bounds.size() == 1);
        assert (bounds.contains(8));
        bounds = MissionControl.findAltitudeTimes(altitudes, 21);
        assert (bounds.size() == 1);
        assert (bounds.contains(9));
        bounds = MissionControl.findAltitudeTimes(altitudes, 1);
        assert (bounds.size() == 1);
        assert (bounds.contains(0));
        bounds = MissionControl.findAltitudeTimes(altitudes, 2);
        assert (bounds.size() == 1);
        assert (bounds.contains(1));
        bounds = MissionControl.findAltitudeTimes(altitudes, 15);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 3);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 999);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 0);
        assert (bounds.size() == 0);

        altitudes = new int[] { 1, 2, 5, 7, 9, 12, 14, 16, 19, 21, 32 };
        bounds = MissionControl.findAltitudeTimes(altitudes, 1);
        assert (bounds.size() == 1);
        assert (bounds.contains(0));
        bounds = MissionControl.findAltitudeTimes(altitudes, 2);
        assert (bounds.size() == 1);
        assert (bounds.contains(1));
        bounds = MissionControl.findAltitudeTimes(altitudes, 5);
        assert (bounds.size() == 1);
        assert (bounds.contains(2));
        bounds = MissionControl.findAltitudeTimes(altitudes, 32);
        assert (bounds.size() == 1);
        assert (bounds.contains(10));
        bounds = MissionControl.findAltitudeTimes(altitudes, 21);
        assert (bounds.size() == 1);
        assert (bounds.contains(9));
        bounds = MissionControl.findAltitudeTimes(altitudes, 19);
        assert (bounds.size() == 1);
        assert (bounds.contains(8));

        altitudes = new int[] { 91, 82, 75, 67, 59, 42, 34, 26, 19, 9 };
        bounds = MissionControl.findAltitudeTimes(altitudes, 91);
        assert (bounds.size() == 1);
        assert (bounds.contains(0));
        bounds = MissionControl.findAltitudeTimes(altitudes, 9);
        assert (bounds.size() == 1);
        assert (bounds.contains(9));
        bounds = MissionControl.findAltitudeTimes(altitudes, 10);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 90);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 7);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 100);
        assert (bounds.size() == 0);

        altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 2 };
        bounds = MissionControl.findAltitudeTimes(altitudes, 2);
        assert (bounds.size() == 2);
        assert (bounds.contains(1));
        assert (bounds.contains(9));
        bounds = MissionControl.findAltitudeTimes(altitudes, 5);
        assert (bounds.size() == 1);
        assert (bounds.contains(4));

        altitudes = new int[] { 6, 18 };
        bounds = MissionControl.findAltitudeTimes(altitudes, 6);
        assert (bounds.size() == 1);
        assert (bounds.contains(0));
        bounds = MissionControl.findAltitudeTimes(altitudes, 18);
        assert (bounds.size() == 1);
        assert (bounds.contains(1));
        bounds = MissionControl.findAltitudeTimes(altitudes, 1);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 29);
        assert (bounds.size() == 0);

        altitudes = new int[] { 33, 18 };
        bounds = MissionControl.findAltitudeTimes(altitudes, 33);
        assert (bounds.size() == 1);
        assert (bounds.contains(0));
        bounds = MissionControl.findAltitudeTimes(altitudes, 18);
        assert (bounds.size() == 1);
        assert (bounds.contains(1));
        bounds = MissionControl.findAltitudeTimes(altitudes, 49);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 9);
        assert (bounds.size() == 0);

        altitudes = new int[] { 6 };
        bounds = MissionControl.findAltitudeTimes(altitudes, 6);
        assert (bounds.size() == 1);
        assert (bounds.contains(0));
        bounds = MissionControl.findAltitudeTimes(altitudes, 1);
        assert (bounds.size() == 0);
        bounds = MissionControl.findAltitudeTimes(altitudes, 9);
        assert (bounds.size() == 0);
    }

    private static void pocuTest() {
        {
            final int[] altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 2 };

            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);

            assert (maxAltitudeTime == 6);
        }

        {
            final int[] altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 2 };

            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);

            assert (bounds.size() == 2);

            assert (bounds.get(0) == 1);
            assert (bounds.get(1) == 9);

            bounds = MissionControl.findAltitudeTimes(altitudes, 5);

            assert (bounds.size() == 1);
            assert (bounds.get(0) == 4);
        }
    }

    private static void otherTest2() {
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 6);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 6);
        }
        {
            final int[] altitudes = new int[]{7, 6, 5, 4, 3, 2, 1};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 0);
        }
        {
            final int[] altitudes = new int[]{1};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 1);
        }
        {
            final int[] altitudes = new int[]{2, 1};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
            final int maxAltitudeTime = MissionControl.findMaxAltitudeTime(altitudes);
            assert (maxAltitudeTime == 6);
            final int[] altitudes2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            final int maxAltitudeTime2 = MissionControl.findMaxAltitudeTime(altitudes2);
            assert (maxAltitudeTime2 == 9);
            final int[] altitudes3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            final int maxAltitudeTime3 = MissionControl.findMaxAltitudeTime(altitudes3);
            assert (maxAltitudeTime3 == 0);
            final int[] altitudes4 = new int[]{3, 5, 9, 8, 7, 5, 5, 4, 3, 1};
            final int maxAltitudeTime4 = MissionControl.findMaxAltitudeTime(altitudes4);
            assert (maxAltitudeTime4 == 2);
            final int[] altitudes5 = new int[]{3, 5, 9};
            final int maxAltitudeTime5 = MissionControl.findMaxAltitudeTime(altitudes5);
            assert (maxAltitudeTime5 == 2);
            final int[] altitudes6 = new int[]{9, 7, 3};
            final int maxAltitudeTime6 = MissionControl.findMaxAltitudeTime(altitudes6);
            assert (maxAltitudeTime6 == 0);
            final int[] altitudes7 = new int[]{3, 5};
            final int maxAltitudeTime7 = MissionControl.findMaxAltitudeTime(altitudes7);
            assert (maxAltitudeTime7 == 1);
            final int[] altitudes8 = new int[]{5, 3};
            final int maxAltitudeTime8 = MissionControl.findMaxAltitudeTime(altitudes8);
            assert (maxAltitudeTime8 == 0);
            final int[] altitudes9 = new int[]{5};
            final int maxAltitudeTime9 = MissionControl.findMaxAltitudeTime(altitudes9);
            assert (maxAltitudeTime9 == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
            assert (bounds.size() == 2);
            assert (bounds.get(0) == 1);
            assert (bounds.get(1) == 9);
            bounds = MissionControl.findAltitudeTimes(altitudes, 5);
            assert (bounds.size() == 1);
            assert (bounds.get(0) == 4);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
            assert (bounds.size() == 1);
            assert (bounds.get(0) == 1);
        }
        {
            final int[] altitudes = new int[]{1, 3, 4, 5, 6, 7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{7, 6, 5, 4, 3, 2, 1};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
            assert (bounds.size() == 1);
            assert (bounds.get(0) == 5);
        }
        {
            final int[] altitudes = new int[]{7, 6, 5, 4, 3, 1};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 7);
            assert (bounds.size() == 1);
            assert (bounds.get(0) == 6);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 5, 6, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 4);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 8);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{2, 3, 4, 5, 6, 7, 4, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 1);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 8);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{2, 3, 4, 5, 6, 7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 1);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{7, 6, 5, 4, 3, 2, 1};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 8);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{7, 6, 5, 4, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 1);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 7);
            assert (bounds.size() == 1);
            assert (bounds.get(0) == 0);
        }
        {
            final int[] altitudes = new int[]{7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 6);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{7};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 8);
            assert (bounds.size() == 0);
        }
        {
            final int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
            ArrayList<Integer> bounds = MissionControl.findAltitudeTimes(altitudes, 2);
            assert (bounds.size() == 2);
            assert (bounds.get(0) == 1);
            assert (bounds.get(1) == 9);
            bounds = MissionControl.findAltitudeTimes(altitudes, 5);
            assert (bounds.size() == 1);
            assert (bounds.get(0) == 4);
            final int[] altitudes2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            ArrayList<Integer> bounds2 = MissionControl.findAltitudeTimes(altitudes2, 3);
            assert (bounds2.size() == 1);
            assert (bounds2.get(0) == 2);
            bounds2 = MissionControl.findAltitudeTimes(altitudes2, 10);
            assert (bounds2.size() == 1);
            assert (bounds2.get(0) == 9);
            bounds2 = MissionControl.findAltitudeTimes(altitudes2, 1);
            assert (bounds2.size() == 1);
            assert (bounds2.get(0) == 0);
            bounds2 = MissionControl.findAltitudeTimes(altitudes2, 11);
            assert (bounds2.size() == 0);
            bounds2 = MissionControl.findAltitudeTimes(altitudes2, 0);
            assert (bounds2.size() == 0);
            final int[] altitudes3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            ArrayList<Integer> bounds3 = MissionControl.findAltitudeTimes(altitudes3, 3);
            assert (bounds3.size() == 1);
            assert (bounds3.get(0) == 7);
            bounds3 = MissionControl.findAltitudeTimes(altitudes3, 10);
            assert (bounds3.size() == 1);
            assert (bounds3.get(0) == 0);
            bounds3 = MissionControl.findAltitudeTimes(altitudes3, 1);
            assert (bounds3.size() == 1);
            assert (bounds3.get(0) == 9);
            bounds3 = MissionControl.findAltitudeTimes(altitudes3, 11);
            assert (bounds3.size() == 0);
            bounds3 = MissionControl.findAltitudeTimes(altitudes3, 0);
            assert (bounds3.size() == 0);
            bounds3 = MissionControl.findAltitudeTimes(altitudes3, 8);
            assert (bounds3.size() == 1);
            assert (bounds3.get(0) == 2);
            final int[] altitudes4 = new int[]{3, 5, 3};
            ArrayList<Integer> bounds4 = MissionControl.findAltitudeTimes(altitudes4, 5);
            assert (bounds4.size() == 1);
            assert (bounds4.get(0) == 1);
            bounds4 = MissionControl.findAltitudeTimes(altitudes4, 3);
            assert (bounds4.size() == 2);
            assert (bounds4.get(0) == 0);
            assert (bounds4.get(1) == 2);
            final int[] altitudes5 = new int[]{3, 5};
            ArrayList<Integer> bounds5 = MissionControl.findAltitudeTimes(altitudes5, 5);
            assert (bounds5.size() == 1);
            assert (bounds5.get(0) == 1);
            bounds5 = MissionControl.findAltitudeTimes(altitudes5, 4);
            assert (bounds5.size() == 0);
            final int[] altitudes6 = new int[]{3};
            ArrayList<Integer> bounds6 = MissionControl.findAltitudeTimes(altitudes6, 5);
            assert (bounds6.size() == 0);
            bounds6 = MissionControl.findAltitudeTimes(altitudes6, 3);
            assert (bounds6.size() == 1);
            final int[] altitudes7 = new int[]{1, 2, 3, 4, 5, 4, 3, 2};
            ArrayList<Integer> bounds7 = MissionControl.findAltitudeTimes(altitudes7, 2);
            assert (bounds7.size() == 2);
            assert (bounds7.get(0) == 1);
            assert (bounds7.get(1) == 7);
            bounds7 = MissionControl.findAltitudeTimes(altitudes7, 1);
            assert (bounds7.size() == 1);
            assert (bounds7.get(0) == 0);
            bounds7 = MissionControl.findAltitudeTimes(altitudes7, 5);
            assert (bounds7.size() == 1);
            assert (bounds7.get(0) == 4);
            bounds7 = MissionControl.findAltitudeTimes(altitudes7, 4);
            assert (bounds7.size() == 2);
            assert (bounds7.get(0) == 3);
            assert (bounds7.get(1) == 5);
            final int[] altitudes8 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5};
            ArrayList<Integer> bounds8 = MissionControl.findAltitudeTimes(altitudes8, 7);
            assert (bounds8.size() == 2);
            assert (bounds8.get(0) == 6);
            assert (bounds8.get(1) == 8);
            bounds8 = MissionControl.findAltitudeTimes(altitudes8, 5);
            assert (bounds8.size() == 2);
            assert (bounds8.get(0) == 4);
            assert (bounds8.get(1) == 10);
        }
    }

    private static void otherTest3() {
        final int[] altitudes10 = new int[]{2, 9 ,6, 4, 3, 2 ,1 };
        final int maxAltitudeTime9 = MissionControl.findMaxAltitudeTime(altitudes10);
        assert (maxAltitudeTime9 == 1);
    }

    private static void otherTest4() {
        final int[] altitudes10 = new int[]{2, 9, 6, 4, 3, 2 ,1 };
        final int maxAltitudeTime9 = MissionControl.findMaxAltitudeTime(altitudes10);
        assert (maxAltitudeTime9 == 1);
        final int[] altitudes11 = new int[]{2, 3, 4, 5, 6, 20, 1};
        final int maxAltitudeTime10 = MissionControl.findMaxAltitudeTime(altitudes11);
        assert (maxAltitudeTime10 == 5);
        final int[] altitudes12 = new int[]{1, 3, 5, 3, 1};
        final int maxAltitudeTime12 = MissionControl.findMaxAltitudeTime(altitudes12);
        assert (maxAltitudeTime12 == 2);
        final int[] altitudes13 = new int[]{1, 3, 5, 6, 3, 1};
        final int maxAltitudeTime13 = MissionControl.findMaxAltitudeTime(altitudes13);
        assert (maxAltitudeTime13 == 3);
        final int[] altitudes14 = new int[]{1, 3, 5, 4, 3, 1};
        final int maxAltitudeTime14 = MissionControl.findMaxAltitudeTime(altitudes14);
        assert (maxAltitudeTime14 == 2);
    }
}