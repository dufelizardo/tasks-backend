pipeline {
    agent any
    environment {
        MY_VAR = 'some_value'
    }
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
    }
}
