package academy.pocu.comp3500.lab4;

import academy.pocu.comp3500.lab4.pocuhacker.RainbowTable;
import academy.pocu.comp3500.lab4.pocuhacker.User;

import java.io.UnsupportedEncodingException;
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

        User me = Arrays.stream(users).filter((p) -> p.getEmail().equals(email)).collect(Collectors.toList()).get(0);

        int hashIndex = getHashIndex(me);

        for (int i = 0; i < users.length; i++) {
            String passwordHash = users[i].getPasswordHash();

            if (hashIndex == -1) {
                continue;
            }

            result[i] = rainbowTables[hashIndex].get(passwordHash);
        }

        return result;
    }


    private int getHashIndex(User myInfo) {
        String passwordHash = myInfo.getPasswordHash();

        if (getCrc32().equals(passwordHash)) {
            return 0;
        }

        if (encryptThisString("MD2").equals(passwordHash)) {
            return 1;
        }

        if (encryptThisString("MD5").equals(passwordHash)) {
            return 2;
        }

        if (encryptThisString("SHA1").equals(passwordHash)) {
            return 3;
        }

        if (encryptThisString("SHA256").equals(passwordHash)) {
            return 4;
        }

        return -1;
    }

    private String encryptThisString(String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);

            byte[] messageDigest = md.digest(password.getBytes(StandardCharsets.UTF_8));

            Base64.Encoder encoder = Base64.getEncoder();

            return new String(encoder.encode(messageDigest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCrc32() {
        CRC32 crc32 = new CRC32();
        byte[] crc32Bytes = password.getBytes(StandardCharsets.UTF_8);

        crc32.update(crc32Bytes, 0, password.length());

        return String.valueOf(crc32.getValue());
    }


}