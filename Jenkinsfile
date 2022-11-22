pipeline {
    agent any
    environment {
        pomVersion = readMavenPom().getVersion()
    }
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
                    sh './mvnw clean verify sonar:sonar -Dsonar.projectKey=grupo-3 -Dsonar.projectName=Grupo3-Lab4'
                }
            }
        }
        stage('Nexus'){        
            steps {
                nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: 'nexus:8081',
                    groupId: 'Grupo3',
                    version: '1.0.0',
                    repository: 'maven-releases-g3',
                    credentialsId: 'artefactos-admin',
                    artifacts: [
                        [artifactId: "archivo",
                        classifier: 'lab4',
                         file: '/build/DevOpsUsach2020-'+ "${pomVersion}" + '.jar',
                        type: 'jar']
                    ]
                )
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
