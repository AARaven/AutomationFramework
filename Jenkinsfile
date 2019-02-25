node {

    stage('SCM checkout stage') {
        git: 'https://github.com/AARaven/AutomationFramework.git'
    }

    stage('Compilation stage') {
        def mvnHome = tool name: 'maven-3', type: 'maven'
        bat "#{mvnHome}\\bin\\mvn compile"
    }
}