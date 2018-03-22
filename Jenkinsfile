pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'M3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Junit Testing Stage') {

            steps {
                withMaven(maven : 'M3') {
                    sh 'mvn test'
                }
            }
        }
        
        stage ('SonarQube Analysis Stage') {

            steps {
        			script {
          			scannerHome = tool 'SQS'
        			}
        			withSonarQubeEnv('SQS') {
          			sh '${scannerHome}/bin/sonar-scanner'
        			}
        		}
        }

        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'M3') {
                    sh 'mvn package'
                }
            }
        }
    }
}