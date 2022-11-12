pipeline {
    agent any

    stages {
        stage('Compile Code') {
            steps {
                sh "./mvnw clean compile -e"
            }
        }
        stage('Test Code') {
            steps {
                sh "./mvnw clean test -e"
            }
        }
        stage('Jar Code') {
            steps {
                sh "./mvnw clean package -e"
            }
        }
        stage('Run Jar') {
            steps {
                //sh "./mvnw spring-boot:run"
                //sh "nohup bash ./mvnw spring-boot:run &"
                sh "./mvnw spring-boot:run &"
            }
        }
        stage('Testing Application') {
            steps {
                 sh "curl -X GET 'http://ec2-3-84-199-151.compute-1.amazonaws.com:8080/rest/mscovid/test?msg=testing'"
            }
        }
        stage('Good Bye') {
            steps {
                echo 'Profe un 7'
            }
        }
    }
}
