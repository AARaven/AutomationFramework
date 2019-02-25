node {

    def mvnHome = tool name: 'Maven-3.6.0', type: 'maven'

    stage('SCM checkout stage') {
        git: 'https://github.com/AARaven/AutomationFramework.git'
    }

    stage('Compilation stage') {
        bat "${mvnHome}\\bin\\mvn compile"
    }

    stage('Test stage') {
        bat "${mvnHome}\\bin/\\mvn test"
    }
}