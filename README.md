# GHA-Project

## GitHub Actions CI/CD with Java, Maven, Docker and AWS EC2

This project demonstrates a GitHub Actions CI/CD workflow for a Java Spring Boot application. The application is built with Maven, packaged as a JAR, containerized with Docker, pushed to Docker Hub, and deployed to an AWS EC2 instance.

## Technologies

- Java 17
- Spring Boot 3.3.4
- Maven
- Docker
- Docker Hub
- GitHub Actions
- AWS EC2
- Ubuntu

## Application

```text
Group ID:    com.example
Artifact ID: java-docker-app
Version:     1.0.0
Packaging:   jar
Java:        17
Port:        8080
```

Docker image:

```text
rahmanuddinmd17/java-docker-app:latest
```

## 1. EC2 Setup

Check Java:

```bash
java -version
javac -version
```

Select Java 17 if multiple versions are installed:

```bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
```

Set JAVA_HOME:

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

Check Maven:

```bash
mvn -version
```

Build the application:

```bash
mvn clean package
```

## 2. Docker Setup

Install Docker on Ubuntu if required:

```bash
sudo apt update
sudo apt install -y docker.io
sudo systemctl enable --now docker
```

Verify:

```bash
docker --version
```

Test Docker:

```bash
sudo docker run hello-world
```

Add the Ubuntu user to Docker group:

```bash
sudo usermod -aG docker ubuntu
```

## 3. Clone the GitHub Repository

```bash
git clone https://github.com/rahmanuddinmd/GHA-Project.git
cd GHA-Project
```

Check status:

```bash
git status
```

## 4. Dockerfile

```dockerfile
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/java-docker-app-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 5. Docker Build and Test

Build the image:

```bash
docker build -t rahmanuddinmd17/java-docker-app:latest .
```

Check images:

```bash
docker images
```

Run the application:

```bash
docker run -d   --name java-docker-app   -p 8080:8080   rahmanuddinmd17/java-docker-app:latest
```

Check the container:

```bash
docker ps
```

Check logs:

```bash
docker logs java-docker-app
```

Test locally:

```bash
curl http://localhost:8080
```

## 6. Docker Cleanup

If a container is using the image:

```bash
docker rm -f java-docker-app
```

Then remove the image:

```bash
docker rmi rahmanuddinmd17/java-docker-app:latest
```

Verify:

```bash
docker images
```

The setup was cleaned so that the application image/container was removed. The `hello-world` test image can also be removed:

```bash
docker rmi hello-world:latest
```

## 7. GitHub Actions Secrets

Configure these repository secrets in:

```text
GitHub
→ Repository
→ Settings
→ Secrets and variables
→ Actions
```

Required secrets:

```text
DOCKERHUB_TOKEN
DOCKERHUB_USERNAME
EC2_HOST
EC2_SSH_KEY
EC2_USER
```

Never put tokens or private SSH keys directly in the workflow.

## 8. GitHub Actions Workflow

Create:

```text
.github/workflows/deploy.yml
```

Use:

```yaml
name: Java Docker CI/CD

on:
  push:
    branches:
      - main

jobs:
  build-and-deploy:

    runs-on: ubuntu-latest

    steps:

      - name: Checkout Code
        uses: actions/checkout@v4

      - name: Setup Java 17
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'
          cache: maven

      - name: Build Application
        run: mvn clean package

      - name: Login to Docker Hub
        uses: docker/login-action@v3
        with:
          username: ${{ secrets.DOCKERHUB_USERNAME }}
          password: ${{ secrets.DOCKERHUB_TOKEN }}

      - name: Build Docker Image
        run: |
          docker build             -t rahmanuddinmd17/java-docker-app:latest .

      - name: Push Docker Image
        run: |
          docker push             rahmanuddinmd17/java-docker-app:latest

      - name: Deploy to EC2
        uses: appleboy/ssh-action@v1.2.0
        with:
          host: ${{ secrets.EC2_HOST }}
          username: ${{ secrets.EC2_USER }}
          key: ${{ secrets.EC2_SSH_KEY }}
          script: |

            docker pull rahmanuddinmd17/java-docker-app:latest

            docker rm -f java-docker-app || true

            docker run -d               --name java-docker-app               -p 8080:8080               rahmanuddinmd17/java-docker-app:latest

            docker ps
```

## 9. Commit and Push the Workflow

```bash
cd ~/GHA-Project
mkdir -p .github/workflows
nano .github/workflows/deploy.yml
```

After saving the file:

```bash
git add .
git commit -m "Add GitHub Actions CI/CD pipeline"
git push origin main
```

## 10. CI/CD Process

```text
Developer
   |
   | git push origin main
   v
GitHub Repository
   |
   v
GitHub Actions
   |
   +--> Checkout Code
   +--> Setup Java 17
   +--> Maven Build
   +--> Docker Login
   +--> Docker Build
   +--> Docker Push
   |
   v
Docker Hub
   |
   v
AWS EC2
   |
   +--> Docker Pull
   +--> Remove Old Container
   +--> Run New Container
   |
   v
Application :8080
```

## 11. Verify Deployment

On EC2:

```bash
docker ps
```

Check logs:

```bash
docker logs java-docker-app
```

Test:

```bash
curl http://localhost:8080
```

Actuator health, if enabled:

```bash
curl http://localhost:8080/actuator/health
```

## 12. Useful Docker Commands

```bash
docker ps
docker ps -a
docker images
docker logs java-docker-app
docker logs -f java-docker-app
docker stop java-docker-app
docker rm -f java-docker-app
docker rmi rahmanuddinmd17/java-docker-app:latest
```

## Final CI/CD Flow

```text
Code Change
    ↓
git push origin main
    ↓
GitHub Actions
    ↓
Maven Build
    ↓
Docker Build
    ↓
Docker Hub Push
    ↓
EC2 SSH Deployment
    ↓
Docker Pull
    ↓
New Container
    ↓
Application Running on Port 8080
```

The goal is to use GitHub Actions for the actual CI/CD process instead of manually building and deploying the application on every change.
