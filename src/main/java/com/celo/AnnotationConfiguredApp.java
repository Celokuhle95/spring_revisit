package com.celo;

import com.celo.annotations_based_wiring.model.Customer;
import com.celo.annotations_based_wiring.model.Payment;
import com.celo.annotations_based_wiring.model.Product;
import com.celo.annotations_based_wiring.service.CustomerService;
import com.celo.annotations_based_wiring.service.impl.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author  Clokuhle Myeza
 *
 * Needs to be abled via configurations to worked on a sping app context, not enanbvles by default
 */
public class AnnotationConfiguredApp {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = ac.getBean(CustomerService.class);

//        saveCustomer(customerService);

        getCustomer(3, customerService);
    }

    private static void saveCustomer(CustomerService customerService) {
        Customer cust = new Customer();
        cust.setName("Myeza");

        Product product = new Product();
        product.setName("Perfume");
        product.setPrice(100);
        cust.setProduct(product);

        Payment payment = new Payment();
        payment.setName("Debit Card");
        payment.setImmediate(true);
        cust.setPayment(payment);

        customerService.save(cust);
    }

    private static void getCustomer(int id, CustomerService customerService) {
        Customer customer = customerService.get(id);
        System.out.println(customer);
    }
}
