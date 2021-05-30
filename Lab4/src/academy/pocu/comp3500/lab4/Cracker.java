package academy.pocu.comp3500.lab4;

import academy.pocu.comp3500.lab4.pocuhacker.RainbowTable;
import academy.pocu.comp3500.lab4.pocuhacker.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.zip.CRC32;

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

        int hashIndex = getHashIndex();

        if (hashIndex == -1) {
            return result;
        }

        for (int i = 0; i < users.length; i++) {
            String passwordHash = users[i].getPasswordHash();

            result[i] = rainbowTables[hashIndex].get(passwordHash);
        }

        return result;
    }


    private int getHashIndex() {
        User myInfo = Arrays.stream(users).filter((p) -> p.getEmail().equals(email)).collect(Collectors.toList()).get(0);
        String myPasswordHash = myInfo.getPasswordHash();

        if (getMyCrc32().equals(myPasswordHash)) {
            return 0;
        }

        if (encryptMyPassword("MD2").equals(myPasswordHash)) {
            return 1;
        }

        if (encryptMyPassword("MD5").equals(myPasswordHash)) {
            return 2;
        }

        if (encryptMyPassword("SHA1").equals(myPasswordHash)) {
            return 3;
        }

        if (encryptMyPassword("SHA256").equals(myPasswordHash)) {
            return 4;
        }

        return -1;
    }

    private String encryptMyPassword(String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);

            byte[] messageDigest = md.digest(password.getBytes(StandardCharsets.UTF_8));

            return new String(Base64.getEncoder().encode(messageDigest));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String getMyCrc32() {
        CRC32 crc32 = new CRC32();
        byte[] crc32Bytes = password.getBytes(StandardCharsets.UTF_8);

        crc32.update(crc32Bytes, 0, password.length());

        return String.valueOf(crc32.getValue());
    }


}