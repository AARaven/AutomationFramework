node {

    def mvnHome = tool name: 'Maven-3.3.9', type: 'maven'

    stage('SCM checkout stage') {
        git: 'https://github.com/AARaven/AutomationFramework.git'
    }

    stage('Compilation stage') {
        sh "${mvnHome}/bin/mvn compile"
    }

    stage('Test stage') {
        sh "${mvnHome}/bin/mvn test"
    }
}