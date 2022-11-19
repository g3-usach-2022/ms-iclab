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
        stage('Testing Application') {
            steps {
                sleep time: 10000, unit: 'MILLISECONDS'

                sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"

            }
        }
        stage('Good Bye') {
            steps {
                echo 'Profe un 7 plssss'

            }
        }
    }
    post {
        always {
            sh "echo "${env.JOB_NAME} - ${env.BUILD_NUMBER} - ${env.BUILD_URL}"
            sh "echo '[Grupo3][Pipeline CI/CD][Rama: release/estado-pais][Stage: build][Resultado:Always]'"
            //slackSend "Build Always - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
        success {
            sh "echo '[Grupo3][Pipeline CI/CD][Rama: release/estado-pais][Stage: build][Resultado:Success]'"
            //slackSend "Build Success - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }

        failure {
            sh "echo '[Grupo3][Pipeline CI/CD][Rama: release/estado-pais][Stage: build][Resultado:Failure]'"
            //slackSend "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
    }
}
