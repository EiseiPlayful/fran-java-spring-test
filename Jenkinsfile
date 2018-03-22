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
                withSonarQubeEnv('SQ') {
                    sh 'mvn clean package sonar:sonar'
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