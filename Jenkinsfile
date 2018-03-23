pipeline {
    agent any

	environment {
        SONAR_SCANNER_HOME = tool 'SQS';
        OPENSHIFT_CLI = tool 'OSCT';
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

        stage ('Push Nexus Stage') {
            steps {
                withMaven(maven : 'M3') {
                    sh 'mvn package -DskipTests=true'
                }
            }
        }
        
        stage ('Deploy on OpenShift Stage') {  
        		steps {
         		sh '${OPENSHIFT_CLI}/oc login -u developer --certificate-authority=/Users/eiseidf/Documents/workspace/ca.crt'
           	 	sh '${OPENSHIFT_CLI}/oc project java-app'
            		sh '${OPENSHIFT_CLI}/oc start-build java-app -n java-app'
        		}
        }
    }
}