pipeline {
    agent {
        label 'windows-playwright'
    }

    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
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
                bat 'mvn clean test -Psmoke'
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
         echo 'Build and tests completed successfully.'
     }

     failure {
         echo 'Build or tests failed.'
     }
 }
}