package config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
class JasyptConfigTest {
    @Test
    @DisplayName("정보 암호화 테스트")
    void testEncryptor() {
        String url = "test";

        System.out.println(jasyptEncoding(url));
    }

    public String jasyptEncoding(String value) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        String key = System.getenv("jasypt.encryptor.password");

        encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        encryptor.setPassword(key);
        encryptor.setIvGenerator(new RandomIvGenerator());

        return encryptor.encrypt(value);
    }
}