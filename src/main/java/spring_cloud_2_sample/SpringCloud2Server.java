package spring_cloud_2_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@SpringBootApplication
@EnableDiscoveryClient
//@EnableReactiveMongoRepositories//
//@EnableWebFluxSecurity
public class SpringCloud2Server {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloud2Server.class, args);
    }
}
