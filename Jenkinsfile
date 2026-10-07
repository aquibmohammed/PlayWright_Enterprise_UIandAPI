pipeline {
    agent {
        label 'windows-playwright'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'git --version'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'Build and tests completed successfully.'
        }

        failure {
            echo 'Build or tests failed.'
        }
    }
}