pipeline {

    agent {
        label 'windows-playwright'
    }

    parameters {
        choice(
            name: 'TEST_SUITE',
            choices: ['smoke', 'ui', 'regression'],
            description: 'Select the TestNG/Maven test suite to execute'
        )
    }

    options {
        timestamps()

        timeout(
            time: 30,
            unit: 'MINUTES'
        )

        disableConcurrentBuilds()

        buildDiscarder(
            logRotator(
                numToKeepStr: '20',
                artifactNumToKeepStr: '10'
            )
        )
    }

    stages {

        stage('Verify Environment') {

            steps {

                bat 'java -version'

                bat 'mvn -version'

                bat 'git --version'
            }
        }

        stage('Build & Test') {

            steps {

                echo "Executing test suite: ${params.TEST_SUITE}"

                bat "mvn clean test -P${params.TEST_SUITE}"
            }
        }
    }

post {
    always {
        emailext(
            to: 'YOUR_GMAIL_ADDRESS@gmail.com',
            subject: "Jenkins SMTP Test - Build #${env.BUILD_NUMBER}",
            body: """
Jenkins Gmail SMTP test.

Job: ${env.JOB_NAME}
Build: #${env.BUILD_NUMBER}
Status: ${currentBuild.currentResult}
URL: ${env.BUILD_URL}
"""
        )
    }
}
}