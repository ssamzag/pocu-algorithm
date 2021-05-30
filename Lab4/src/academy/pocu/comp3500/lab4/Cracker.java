package academy.pocu.comp3500.lab4;

import academy.pocu.comp3500.lab4.pocuhacker.RainbowTable;
import academy.pocu.comp3500.lab4.pocuhacker.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

            if (passwordHash.length() > 0 && passwordHash.length() < 10) {
                result[i] = rainbowTables[0].get(passwordHash);
            } else if (passwordHash.length() == 24) {
                User me = Arrays.stream(users).filter((p) -> p.getEmail().equals(email)).collect(Collectors.toList()).get(0);

                int hashIndex = getHashIndex(me);

                if (hashIndex == -1) {
                    return result;
                }

                result[i] = rainbowTables[hashIndex].get(passwordHash);
            } else if (passwordHash.length() == 28) {
                result[i] = rainbowTables[3].get(passwordHash);
            } else if (passwordHash.length() == 44) {
                result[i] = rainbowTables[4].get(passwordHash);
            }
        }

        return result;
    }


    private int getHashIndex(User myInfo) {

        String md2Hash = encryptThisString("MD2");
        if (md2Hash.equals(myInfo.getPasswordHash())) {
            return 1;
        }

        String md3Hash = encryptThisString("MD5");
        if (md3Hash.equals(myInfo.getPasswordHash())) {
            return 2;
        }

        return -1;
    }

    public String encryptThisString(String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);

            byte[] messageDigest = md.digest(password.getBytes());

            Base64.Encoder encoder = Base64.getEncoder();

            return new String(encoder.encode(messageDigest));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}