package io.daobab.performance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
@Slf4j
public class RootPage {

    @GetMapping
    public String welcome() {
        return """
                                
                <!DOCTYPE html>
                <html>
                <style>
                table, th, td {
                  border:1px solid black;
                }
                </style>
                <body>
                                
                <h2>DAO Performance Comparator</h2>
                <h3>Call a service using particular ORM</h3>
                <h4>Remember, each technology needs some warm-out - please ignore few first invokes after the startup</h4>
                         
                <table style="width:100%">
                  <tr>
                    <th>Daobab</th>
                    <th>Hibernate</th>
                    <th>JPA</th>
                  </tr>
                  <tr>
                    <td><a href=daobab/getActors>getActors</a></td>
                    <td><a href=hibernate/getActors>getActors</a></td>
                    <td><a href=jpa/getActors>getActors</a></td>
                  </tr>
                  <tr>
                    <td><a href=daobab/getActorById/1>getActorById</a></td>
                    <td><a href=hibernate/getActorById/1>getActorById</a></td>
                    <td><a href=jpa/getActorById/1>getActorById</a></td>
                  </tr>
                  <tr>
                    <td><a href=daobab/getCustomerPaymentSum/1>getCustomerPaymentSum</a></td>
                    <td><a href=hibernate/getCustomerPaymentSum/1>getCustomerPaymentSum</a></td>
                    <td><a href=jpa/getCustomerPaymentSum/1>getCustomerPaymentSum</a></td>
                  </tr>
                  <tr>
                    <td><a href=daobab/getCustomerAddresses>getCustomerAddresses</a></td>
                    <td><a href=hibernate/getCustomerAddresses>getCustomerAddresses</a></td>
                    <td><a href=jpa/getCustomerAddresses>getCustomerAddresses</a></td>
                  </tr>

                </table>
                                
                                
                <h3>Click to call endpoints massively</h3>
                                
                <table style="width:100%">
                  <tr>
                    <th>10x</th>
                    <th>100x</th>
                    <th>1000x</th>
                  </tr>
                  <tr>
                    <td><a href=invoker/testGetActors/10>Test getActors x10</a></td>
                    <td><a href=invoker/testGetActors/100>Test getActors x100</a></td>
                    <td><a href=invoker/testGetActors/1000>Test getActors x1000</a></td>
                  </tr>
                  <tr>
                    <td><a href=invoker/testGetActorById/1/10>Test getActorById x10</a></td>
                    <td><a href=invoker/testGetActorById/1/100>Test getActorById x100</a></td>
                    <td><a href=invoker/testGetActorById/1/1000>Test getActorById x1000</a></td>
                  </tr>
                  <tr>
                    <td><a href=invoker/testGetCustomerPaymentSum/10>Test getCustomerPaymentSum x10</a></td>
                    <td><a href=invoker/testGetCustomerPaymentSum/100>Test getCustomerPaymentSum x100</a></td>
                    <td><a href=invoker/testGetCustomerPaymentSum/1000>Test getCustomerPaymentSum x1000</a></td>
                  </tr>
                  <tr>
                    <td><a href=invoker/testGetCustomerAddresses/10>Test getCustomerAddresses x10</a></td>
                    <td><a href=invoker/testGetCustomerAddresses/100>Test getCustomerAddresses x100</a></td>
                    <td><a href=invoker/testGetCustomerAddresses/1000>Test getCustomerAddresses x1000</a></td>
                  </tr>

                </table>
                                
                                
                </body>
                </html>
                                
                                
                """;
    }
}
