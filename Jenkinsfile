pipeline {
    agent any

    environment {
        MY_VAR = 'some_value'
    }

    options {
        timeout(time: 1, unit: 'HOURS')
    }

    parameters {
        string(name: 'MY_PARAM', defaultValue: 'default_value', description: 'A parameter')
    }

    triggers {
        cron('H/15 * * * *')
    }

    stages {
        stage('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Parallel Stages Test') {
            parallel {
                stage('Parallel API Test') {
                    steps {
                        echo 'Parallel API Test'
                    }
                }
                stage('Parallel Test Coverage Analysis') {
                    steps {
                        echo 'Parallel Test Coverage Analysis'
                    }
                }
            }
        }

        stage('Build Front') {
            steps {
                echo 'Building Frontend'
            }
        }        

        stage('Matrix') {
            matrix {
                axes {
                    axis {
                        name 'OS'
                        values 'linux', 'windows'
                    }
                    axis {
                        name 'VERSION'
                        values '1.0', '2.0'
                    }
                }
                stages {
                    stage('Matrix Deploy') {
                        steps {
                            echo "Building on ${OS} with version ${VERSION}"
                        }
                    }
                }
            }
        }

        stage('Conditional Stage') {
            when {
                expression { return params.MY_PARAM == 'execute' }
            }
            steps {
                echo 'This stage runs conditionally based on parameter'
            }
        }

        stage('Deploy QAA') {
            steps {
                echo 'Deploying in environment QAA'
            }
        }

        stage('Functional Tests QAA') {
            steps {
                echo 'Running functional tests in QAA'
                // Adicione os comandos para executar os testes funcionais em QAA aqui
            }
        }

        stage('Approval QAA') {
            input {
                message 'Do you want to proceed with the QAA deployment?'
                ok 'Yes'
            }
            steps {
                echo 'User approved QAA deployment'
            }
        }

        stage('Deploy CERT') {
            steps {
                echo 'Deploying in environment CERT'
            }
        }

        stage('Functional Tests CERT') {
            steps {
                echo 'Running functional tests in CERT'
                // Adicione os comandos para executar os testes funcionais em CERT aqui
            }
        }

        stage('Approval CERT') {
            input {
                message 'Do you want to proceed with the CERT deployment?'
                ok 'Yes'
            }
            steps {
                echo 'User approved CERT deployment'
            }
        }

        stage('Deploy PROD') {
            steps {
                echo 'Deploying in environment PROD'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
