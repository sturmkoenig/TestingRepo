pipeline {  { docker { image 'maven:3.3.3' } }
    stages {
    	stage('clean') {
    		steps {
    	   		sh 'mvn clean'
    		}

    	}

        stage('build') {
            steps {
                sh 'mvn install'
            }
        }
    }
}