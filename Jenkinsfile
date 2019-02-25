pipeline {

    agent any

    stages {

        stage('version stage') {
            steps {
                bat 'mvn --version'
            }
        }

        stage('Compilation stage') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Testing stage') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

}