A pessimistic lock is a concurrency control mechanism used in database systems. We can use a pessimistic lock to ensure that no other transactions can modify or delete reserved data.

JPA specification defines three pessimistic lock modes but here we’re going to discuss PESSIMISTIC_WRITE lock:

PESSIMISTIC_WRITE : Any transaction that needs to acquire a lock on data and make changes to it should obtain the PESSIMISTIC_WRITE lock. According to the JPA specification, holding PESSIMISTIC_WRITE lock will prevent other transactions from reading, updating or deleting the data..

What are the benefits of using pessimistic locks ?

Rollbacks can be costly for the database system as it needs to revert all current pending changes which might involve both table rows and index records. For this reason, pessimistic locking might be more suitable when conflicts happen frequently, as it reduces the chance of rolling back transactions.


In service class updateEmployee method, I have added 5 seconds stop to send parallel requests to test pessimistic locking. When first request will take 5+ seconds to complete in mean while I will second request and verify if pessimistic lock is working fine or not ? I have opened two tab of postman with different request body to call same endpoint.

http://localhost:8080/employee/sumit

In DB we can see employee name sumit have salary 500.

![image](https://github.com/vinosubi/PessimisticLock/assets/133937082/faa4ff7a-67ca-456a-854b-456bd7243a83)

Tab — 1
![image](https://github.com/vinosubi/PessimisticLock/assets/133937082/5e3ef4ae-4ad5-4209-807b-3873f2f9ffd7)

Tab — 2
![image](https://github.com/vinosubi/PessimisticLock/assets/133937082/33378ce8-5e6c-4f95-81b2-c7aad3b54e26)

Trying to update same record with two parallel request. If we have applied pessimistic lock then it will update record with correct data. Here, in below image we can see salary is 3700. ==> 500(initial balance)+200(1st request Balance)+3000(2nd request Balance) = 3700.

![image](https://github.com/vinosubi/PessimisticLock/assets/133937082/6be2d68f-ed6b-4753-9f48-3dc3f63fc0cc)

If we are not using pessimistic lock then it will add balance of only last executed request. Here, in below salary is 3500 after executing both request parallelly.

![image](https://github.com/vinosubi/PessimisticLock/assets/133937082/8e27ef77-1167-4450-a2d1-eb2b75edd8d6)




