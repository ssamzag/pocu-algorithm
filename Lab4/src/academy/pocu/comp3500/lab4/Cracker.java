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
        if (crc32().equals(myInfo.getPasswordHash())) {
            return 0;
        }

        String md2Hash = encryptThisString("MD2");
        if (md2Hash.equals(myInfo.getPasswordHash())) {
            return 1;
        }

        String md3Hash = encryptThisString("MD5");
        if (md3Hash.equals(myInfo.getPasswordHash())) {
            return 2;
        }

        String sha1Hash = encryptThisString("SHA1");
        if (sha1Hash.equals(myInfo.getPasswordHash())) {
            return 3;
        }

        String sha256Hash = encryptThisString("SHA256");
        if (sha256Hash.equals(myInfo.getPasswordHash())) {
            return 4;
        }

        return -1;
    }

    private String encryptThisString(String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);

            byte[] messageDigest = md.digest(password.getBytes());

            Base64.Encoder encoder = Base64.getEncoder();

            return new String(encoder.encode(messageDigest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String crc32() {
        CRC32 crc32 = new CRC32();
        byte[] crc32Bytes = password.getBytes(StandardCharsets.UTF_8);

        crc32.update(crc32Bytes, 0, password.length());

        return String.valueOf(crc32.getValue());
    }


}