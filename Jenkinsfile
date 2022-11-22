pipeline {
    agent any
    environment {
        pomVersion = readMavenPom().getVersion()
    }
    stages {
        stage('Versioning and tag'){
            steps{
                sh "env"
                sh './mvnw -B build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit '
                
                script{
                    VERSION = readMavenPom().getVersion()
                }
                //sh './mvnw -B build-helper:parse-version versions:set -DnewVersion=\\${VERSION} versions:commit'
                withCredentials([usernamePassword(credentialsId: 'Github_acon_token_bfal', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
                sh 'git config --global user.name \"BryanArancibia\"'
                sh 'git config --global user.email \"b.arancibia.f.l@gmail.com\"'
                sh 'git add .'
                sh 'git commit -m \"pushing version \${VERSION}\"'
                sh "echo ${env.GIT_BRANCH}"
                sh "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/g3-usach-2022/ms-iclab.git HEAD:${env.GIT_BRANCH}"
                //borra tag remoto
                //sh 'git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/g3-usach-2022/ms-iclab.git --delete ${pomVersion}'
                //borra tag local
                //sh 'git tag -d ${pomVersion}'
                //crea tag
                sh 'git tag \${VERSION} -m \"Pusing tag \${VERSION}\"'
                //push tag a remoto
                sh "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/g3-usach-2022/ms-iclab.git ${VERSION}"
                }
            }
        }

/*
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
                    version: "${pomVersion}",
                    repository: 'maven-releases-g3',
                    credentialsId: 'artefactos-admin',
                    artifacts: [
                        [artifactId: "archivo",
                        classifier: 'lab4',
                         file: 'build/DevOpsUsach2020-'+ "${pomVersion}" + '.jar',
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
    */
    }
    /*
    post {
            success {
                    slackSend message: "[Grupo 3][Pipeline CI/CD][Rama: ${env.JOB_NAME}][Stage: ${env.BUILD_NUMBER}][Resultado: Success]- (<${env.BUILD_URL}|Open>)"
                }
            failure {
                    slackSend message:"[Grupo 3][Pipeline CI/CD][Rama: ${env.JOB_NAME}][Stage: ${env.BUILD_NUMBER}][Resultado: Failed]- (<${env.BUILD_URL}|Open>)"
                }
    }*/
    
}
