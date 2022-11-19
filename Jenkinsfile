pipeline {
    agent any

    stages {
        stage('Compile Code') {
            steps {
                sh "./mvnw clean compile -e -DskipTest"
            }
        }
        stage('Test Code') {
            steps {
                sh "./mvnw clean test -e"
            }
        }
        stage('Jar Code') {
            steps {
                sh "./mvnw clean package -e -DskipTest"
            }
        }
        stage('Run Jar') {
            steps {
                //sh "./mvnw spring-boot:run"
                //sh "nohup bash ./mvnw spring-boot:run &"
                sh "./mvnw spring-boot:run &"
            }
        }
        stage('sonar') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "echo 'Calling sonar Service in another docker container!'"
                    sh 'mvn clean verify sonar:sonar'
                }
        }
        stage('Good Bye') {
            steps {
                echo 'Profe un 7 plssss'

            }
        }
    }
    post {
            success {
                    slackSend message: "[Grupo 3][Pipeline CI/CD][Rama: ${env.JOB_NAME}][Stage: ${env.BUILD_NUMBER}][Resultado: Success]- (<${env.BUILD_URL}|Open>)"
                }
            failure {
                    slackSend message:"[Grupo 3][Pipeline CI/CD][Rama: ${env.JOB_NAME}][Stage: ${env.BUILD_NUMBER}][Resultado: Failed]- (<${env.BUILD_URL}|Open>)"
                }
    }
}