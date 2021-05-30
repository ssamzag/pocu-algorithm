package academy.pocu.comp3500.lab4;

import academy.pocu.comp3500.lab4.pocuhacker.RainbowTable;
import academy.pocu.comp3500.lab4.pocuhacker.User;

public class Cracker {

    private final User[] users;
    private final String email;
    private final String password;

    public Cracker(User[] users, String email, String password) {
        this.users = users;
        this.email = email;
        this.password = password;
    }

    public String[] run(RainbowTable[] rainbowTables) {
        String[] result = new String[users.length];

        for (int i = 0; i < users.length; i++) {
            String passwordHash = users[i].getPasswordHash();

            if (passwordHash.length() < 10) {
                result[i] = rainbowTables[0].get(passwordHash);
            } else if (passwordHash.length() == 24) {
                result[i] = rainbowTables[1].get(passwordHash);
                if (result[i] == null) {
                    result[i] = rainbowTables[2].get(passwordHash);
                }
            } else if (passwordHash.length() == 28) {
                result[i] = rainbowTables[3].get(passwordHash);
            } else if (passwordHash.length() == 44) {
                result[i] = rainbowTables[4].get(passwordHash);
            }
        }
        

        return result;
    }

}