package org.sid.customerservice;

import org.apache.catalina.Store;
import org.sid.customerservice.entites.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
        CommandLineRunner start(CustomerRepository customerRepository , RepositoryRestConfiguration restConfiguration){
         restConfiguration.exposeIdsFor(Customer.class);
        return args -> {

            customerRepository.save(new Customer(null,"Mohamed amine","Mohamedamine@gmail.com")) ;
            customerRepository.save(new Customer(null,"Abdelhamid","Abdelhamid@gmail.com")) ;
            customerRepository.save(new Customer(null,"Ayman","Ayman@gmail.com")) ;
            customerRepository.save(new Customer(null,"Chaymae","Chaymae@gmail.com")) ;
            customerRepository.save(new Customer(null,"Wissal","Wissal@gmail.com")) ;
            System.out.println(c.toString());
        };
        }
}
