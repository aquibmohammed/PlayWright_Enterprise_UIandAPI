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

            junit(
                testResults: '**/target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            archiveArtifacts(
                artifacts: 'target/test-artifacts/**',
                allowEmptyArchive: true,
                fingerprint: true
            )

            echo 'Pipeline execution completed.'
        }

        success {

            echo "Test suite '${params.TEST_SUITE}' completed successfully."
        }

        failure {

            echo "Test suite '${params.TEST_SUITE}' failed."
        }
    }
}