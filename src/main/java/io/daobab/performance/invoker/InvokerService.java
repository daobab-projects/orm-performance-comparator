package io.daobab.performance.invoker;

import io.daobab.performance.daobab.SakilaDataBase;
import io.daobab.performance.daobab.SakilaTables;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.String.format;

@Component
@Slf4j
@RequiredArgsConstructor
public class InvokerService implements SakilaTables {

    private final SakilaDataBase db;
    private final String daobabPrefix = "daobab";
    private final String hibernatePrefix = "hibernate";
    private final String jpaPrefix = "jpa";
    @Value("${server.port}")
    private Integer port;

    public String testGetActors(Integer repeats) throws IOException {
        return testGenericService(repeats, "getActors");
    }

    public String testGetActorById(Integer id, Integer repeats) throws IOException {
        return testGenericService(repeats, "getActorById/" + id);
    }

    public String testGetCustomerPaymentSum(Integer repeats) throws IOException {
        return testGenericService(repeats, "getCustomerPaymentSum");
    }

    public String testGetCustomerAddresses(Integer repeats) throws IOException {
        return testGenericService(repeats, "getCustomerAddresses");
    }

    private String testGenericService(Integer repeats, String service) throws IOException {

        long jpaTime = callService(5, repeats, jpaPrefix, service);
        long hibernateTime = callService(5, repeats, hibernatePrefix, service);
        long daobabTime = callService(5, repeats, daobabPrefix, service);

        long avgJpaTime = jpaTime / repeats;
        long avgHibernateTime = hibernateTime / repeats;
        long avgDaobabTime = daobabTime / repeats;

        String daobabSummary = (format("daobab time %s * %s is %s. Average execution time is: %s", repeats, service, daobabTime, avgDaobabTime));
        String hibernateSummary = (format("hibernate time %s * %s is %s. Average execution time is: %s", repeats, service, hibernateTime, avgHibernateTime));
        String jpaSummary = (format("jpa time %s * %s is %s. Average execution time is: %s", repeats, service, jpaTime, avgJpaTime));

        log.info(daobabSummary);
        log.info(hibernateSummary);
        log.info(jpaSummary);

        return format("""
                <!DOCTYPE html>
                <html>
                <style>
                table, th, td {
                  border:1px solid black;
                }
                </style>
                <body>
                                
                %s <br>
                %s <br>
                %s <br>
                                
                </body>
                </html>
                """, daobabSummary, hibernateSummary, jpaSummary);

    }

    private long callService(int warmautTimes, int times, String orm, String service) throws IOException {

        URL url = new URL("http://localhost:" + port + "/" + orm + "/" + service);

        long totalExecutionTime = 0;

        for (int i = 0; i < warmautTimes; i++) {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            String str = con.getResponseMessage();
        }

        for (int i = 0; i < times; i++) {
            long start = System.nanoTime();

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            String str = con.getResponseMessage();
            long stop = System.nanoTime();

            long executionTimeMicroseconds = (stop - start) / 1000;

            totalExecutionTime = totalExecutionTime + executionTimeMicroseconds;
        }
        return totalExecutionTime;

    }
}
