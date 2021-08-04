package com.example.imperative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class ImperativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImperativeApplication.class, args);
    }

}

@RequiredArgsConstructor
@RestController
class CustomerRestController {
    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}

interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
    @Id
    private Integer id;
    private String name;
}
