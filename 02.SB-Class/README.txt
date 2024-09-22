
# swagger url 

http://localhost:9092/swagger-ui/index.html 

Database user 

-- Create a user
CREATE USER user_class IDENTIFIED BY user_class;
--Grant permissions
GRANT CONNECT, RESOURCE, DBA TO user_class;