package mre.gs.aws.lambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class LambdaApp {
    public static void main(String[] args) {
        SpringApplication.run(LambdaApp.class, args);
    }

    @Bean
    public Function<String, String> uppercase() {
        return v -> v.toUpperCase();
    }

    @Bean
    public Function<String, String> reverse() {
        return v -> new StringBuilder(v).reverse().toString();
    }

    @Bean
    public Function<String, String> twice() {
        return v -> v.repeat(2);
    }

    @Bean
    public Supplier<String> uuid() {
        return () -> UUID.randomUUID().toString();
    }


    @Bean
    public Function<Integer, Long> fibonacci() {
        return n -> {
            if (n == 0) return 0L;
            if (n < 3) return 1L;

            long fibMinus1 = 1L;
            long fib = 2L;
            for (int i = 3; i < n; i++) {
                long f = fib;
                fib += fibMinus1;
                fibMinus1 = f;
            }

            return fib;
        };
    }
}
