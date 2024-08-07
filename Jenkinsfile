pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            steps {
                withSonarQubeEnv('SONAR_LOCAL') {
                    bat '${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=820b811046772485e98a59b8956cfe6a9b3935d9 -Dsonar.java.binries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/scr/test/**,**/model/**,**Application.java'
            
                }
            }
        }
    }
}
