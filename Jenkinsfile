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

        stage('Parallel Stages Test') {
            parallel {
                stage('Parallel API Test') {
                    steps {
                        echo 'Parallel Stage 1'
                    }
                }
                stage('Parallel Test Coverage Analisy') {
                    steps {
                        echo 'Parallel Stage 2'
                    }
                }
            }
        }
        stage ('Build Front') {
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

        stage('User Input Approval') {
            input {
                message 'Do you want to proceed?'
                ok 'Yes'
            }
            steps {
                echo 'User chose to proceed'
            }
        }

        stage ('Deploy QAA') {
            steps {
                echo 'Deploy in environment QAA'
            }
        }

        stage ('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Parallel Stages Test') {
            parallel {
                stage('Parallel API Test') {
                    steps {
                        echo 'Parallel Stage 1'
                    }
                }
                stage('Parallel Test Coverage Analisy') {
                    steps {
                        echo 'Parallel Stage 2'
                    }
                }
            }
        }
        stage ('Build Front') {
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

        stage('User Input Approval') {
            input {
                message 'Do you want to proceed?'
                ok 'Yes'
            }
            steps {
                echo 'User chose to proceed'
            }
        }
        
        stage ('Deploy CERT') {
            steps {
                echo 'Deploy in environment CERT'
            }
        }

        stage ('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Parallel Stages Test') {
            parallel {
                stage('Parallel API Test') {
                    steps {
                        echo 'Parallel Stage 1'
                    }
                }
                stage('Parallel Test Coverage Analisy') {
                    steps {
                        echo 'Parallel Stage 2'
                    }
                }
            }
        }
        stage ('Build Front') {
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

        stage('User Input Approval') {
            input {
                message 'Do you want to proceed?'
                ok 'Yes'
            }
            steps {
                echo 'User chose to proceed'
            }
        }
        
        stage ('Deploy PROD') {
            steps {
                echo 'Deploy in environment PROD'
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
