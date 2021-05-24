package academy.pocu.comp3500.assignment1;

import academy.pocu.comp3500.assignment1.pba.Player;
import academy.pocu.comp3500.assignment1.pba.GameStat;

public final class PocuBasketballAssociation {
    private PocuBasketballAssociation() {
    }

    public static void processGameStats(final GameStat[] gameStats, final Player[] outPlayers) {
        heapsort(gameStats);

        String playerName = "";
        int gamePlay = 0;
        int index = 0;
        int goals = 0;
        int goalAttempts = 0;
        int points = 0;
        int assists = 0;
        int numPasses = 0;

        for (int i = 0; i < gameStats.length; i++) {
            gamePlay++;

            if (playerName.isEmpty()) {
                playerName = gameStats[i].getPlayerName();
            }

            goalAttempts += gameStats[i].getGoalAttempts();
            goals += gameStats[i].getGoals();
            points += gameStats[i].getPoints();
            assists += gameStats[i].getAssists();
            numPasses += gameStats[i].getNumPasses();

            if (gameStats.length - 1 == i || i + 1 < gameStats.length && !gameStats[i + 1].getPlayerName().equals(playerName)) {
                outPlayers[index].setName(playerName);
                outPlayers[index].setPointsPerGame(points / gamePlay);
                outPlayers[index].setAssistsPerGame(assists / gamePlay);
                outPlayers[index].setPassesPerGame(numPasses / gamePlay);
                outPlayers[index].setShootingPercentage(100 * goals / goalAttempts);

                playerName = "";
                index++;
                gamePlay = 0;
                goals = 0;
                goalAttempts = 0;
                points = 0;
                assists = 0;
                numPasses = 0;
            }
        }
    }

    public static void heapsort(GameStat[] arr) {
        int size = arr.length;

        int parentIdx = (size - 2) / 2;

        for (int i = parentIdx; i >= 0; i--) {
            heapify(arr, i, size - 1);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    private static void swap(GameStat[] gameStats, int i, int j) {
        GameStat temp = gameStats[i];
        gameStats[i] = gameStats[j];
        gameStats[j] = temp;
    }

    private static void heapify(GameStat[] gameStats, int parentIdx, int lastIdx) {

        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;
        int largestIdx = parentIdx;

        if (leftChildIdx < lastIdx && gameStats[largestIdx].getPlayerName().hashCode() < gameStats[leftChildIdx].getPlayerName().hashCode()) {
            largestIdx = leftChildIdx;
        }

        if (rightChildIdx < lastIdx && gameStats[largestIdx].getPlayerName().hashCode() < gameStats[rightChildIdx].getPlayerName().hashCode()) {
            largestIdx = rightChildIdx;
        }

        if (parentIdx != largestIdx) {
            swap(gameStats, largestIdx, parentIdx);
            heapify(gameStats, largestIdx, lastIdx);
        }
    }

    public static Player findPlayerPointsPerGame(final Player[] players, int targetPoints) {
        int low = 0;
        int high = players.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (players[mid].getPointsPerGame() < targetPoints) {
                low = mid + 1;
            } else if (players[mid].getPointsPerGame() > targetPoints) {
                high = mid - 1;
            } else {
                return players[mid];
            }
        }

        int lowAbs = Math.abs(targetPoints - players[low].getPointsPerGame());
        int highAbs = Math.abs(players[high].getPointsPerGame() - targetPoints);

        return lowAbs <= highAbs ? players[low] : players[high];
    }

    public static Player findPlayerShootingPercentage(final Player[] players, int targetShootingPercentage) {
        int low = 0;
        int high = players.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (players[mid].getShootingPercentage() < targetShootingPercentage) {
                low = mid + 1;
            } else if (players[mid].getShootingPercentage() > targetShootingPercentage) {
                high = mid - 1;
            } else {
                return players[mid];
            }
        }

        int lowAbs = Math.abs(targetShootingPercentage - players[low].getShootingPercentage());
        int highAbs = Math.abs(players[high].getShootingPercentage() - targetShootingPercentage);

        return lowAbs <= highAbs ? players[low] : players[high];
    }

    public static long find3ManDreamTeam(final Player[] players, final Player[] outPlayers, final Player[] scratch) {
        heapsort2(players);
        int result = 0;
        int minAssist = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            outPlayers[i] = players[i];
            result += outPlayers[i].getPassesPerGame();
            minAssist = Math.min(outPlayers[i].getAssistsPerGame(), minAssist);
        }

        return (long) result * minAssist;
    }

    public static long findDreamTeam(final Player[] players, int k, final Player[] outPlayers, final Player[] scratch) {
        heapsort2(players);
        int result = 0;
        int minAssist = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            outPlayers[i] = players[i];
            result += outPlayers[i].getPassesPerGame();
            minAssist = Math.min(outPlayers[i].getAssistsPerGame(), minAssist);
        }

        return (long) result * minAssist;
    }

    public static int findDreamTeamSize(final Player[] players, final Player[] scratch) {
        return -1;
    }

    public static void heapsort2(Player[] arr) {
        int size = arr.length;

        int parentIdx = (size - 2) / 2;

        for (int i = parentIdx; i >= 0; i--) {
            heapify2(arr, i, size - 1);
        }

        for (int i = size - 1; i > 0; i--) {
            swap2(arr, 0, i);
            heapify2(arr, 0, i - 1);
        }
    }

    private static void swap2(Player[] players, int i, int j) {
        Player temp = players[i];
        players[i] = players[j];
        players[j] = temp;
    }

    private static void heapify2(Player[] players, int parentIdx, int lastIdx) {
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;
        int largestIdx = parentIdx;

        if (leftChildIdx < lastIdx && players[largestIdx].getAssistsPerGame() * players[largestIdx].getPassesPerGame() > players[leftChildIdx].getAssistsPerGame() * players[leftChildIdx].getPassesPerGame()) {
            largestIdx = leftChildIdx;
        }

        if (rightChildIdx < lastIdx && players[largestIdx].getAssistsPerGame() * players[largestIdx].getPassesPerGame() > players[rightChildIdx].getAssistsPerGame() * players[rightChildIdx].getPassesPerGame()) {
            largestIdx = rightChildIdx;
        }

        if (parentIdx != largestIdx) {
            swap2(players, largestIdx, parentIdx);
            heapify2(players, largestIdx, lastIdx);
        }
    }
}