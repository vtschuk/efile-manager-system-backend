# Compile and Start
mvn clean package spring-boot:run

# Compile and Start without Tests:
mvn clean package spring-boot:run -DskipTests

# Precondition
empty Empty MYSQL Database on Port 3306

# Build a Docker Image
docker build -t my-java-app .

# Start Docker
docker run -d ...