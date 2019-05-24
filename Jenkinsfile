node {
    stage('Checkout') {
        git 'https://github.com/basilossandon/hotel-back.git'
    }
    
    stage('Compile-Package') {
        def mvnHome = tool name: 'MAVEN 3.6.1', type: 'maven'
        sh "${mvnHome}/bin/mvn dependency:tree"
        sh "${mvnHome}/bin/mvn clean package"
        sh "cp /var/lib/jenkins/workspace/build-backend/target/api.war /opt/tomcat/webapps"
    }
}