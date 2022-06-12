package dev.java.javaexchangerate;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaExchangeRateApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(JavaExchangeRateApplication.class, args);
    }

}
