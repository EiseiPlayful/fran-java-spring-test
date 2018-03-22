pipeline {
    agent any

	environment {
        SONAR_SCANNER_HOME = tool 'SQS';
    }
    
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
        			withSonarQubeEnv('SQ') {
          			sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner"
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