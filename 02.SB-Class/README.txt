
# swagger url 

http://localhost:9092/swagger-ui/index.html 

Database user 
-- Create a user
CREATE USER user_course IDENTIFIED BY user_course;
--Grant permissions
GRANT CONNECT, RESOURCE, DBA TO user_course;