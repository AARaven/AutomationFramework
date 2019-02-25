node {

    stage('SCM checkout stage') {
        git: 'https://github.com/AARaven/AutomationFramework.git'
    }

    stage('Compilation stage') {
        def mvnHome = tool name: 'Maven-3.6.0', type: 'maven'
        bat "#{mvnHome}\\bin\\mvn compile"
    }
}