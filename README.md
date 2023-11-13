# orm-performance-comparator
Performance comparator between Daobab, Hibernate and JPA

# About the project

Daobab contains build-in internal Json converters, which brings significant improvements.

The idea of this project is to compare the Daobab performance to various popular ORMs including the time needed to Json
conversion.

The project contains an 'InternalInterceptor' - this interceptor measures the execution time contains json conversion.

However, massive invokes from InvokerService measures also an additional time needed by http protocol to establish
connection and retrieve the data.
That's why those time may be slightly greater that noted by InternalInterceptor.

# How to run

Use Application class to run the Spring Boot application.
Go to http://localhost:9001 to show the application root page.
Click some links. You can refresh the page to re-run the service.
Check the console logs.

The second table executes massive tests.
For those tests, summary will be printed also at the web page.
Every ORM need some warm-out. Because of that, each massive invoke executes the service few times before.

# url parameters

Some services accept url parameters for example: getCustomerPaymentSum - you can change the customer id (1 by default)
at the end

http://localhost:9001/daobab/getCustomerPaymentSum/1

Also, for massive test you can change the number of invokes as below:

http://localhost:9001/invoker/testGetCustomerAddresses/100

# services

getActors - get the complete list of actors entities
getActorById - get single actor entity
getCustomerPaymentSum - get the customer payment sum
getCustomerAddresses - get 4 parameters from 3 tables related to customer data.
