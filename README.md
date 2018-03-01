# Assumption
Has MYSQL, MVN and NPM installed.

# Step 1, Login to MySQL with administrator and execute commands below.
CREATE USER 'moodtracker'@'localhost' IDENTIFIED BY 'moodtracker';
CREATE DATABASE moodtracker CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON moodtracker.* TO moodtracker@localhost WITH GRANT OPTION;
FLUSH PRIVILEGES;

# Step 2, Unzip project file and navigate to 'spring-moodtracker' folder in command window and execute:
mvn clean install tomcat7:run

# Step 3, Navigate to 'angular-moodtracker' folder in command window and execute:
npm install
npm start <your-local-ip-address>


# Step 4, Open Chrome browser and enter url "<your-local-ip-address>:8000" and press ENTER.
http://<your-local-ip-address>:8000
