node {
    stage('Checkout') {
        git 'https://github.com/basilossandon/hotelback.git'
    }
    
    stage('Compile-Package') {
        def mvnHome = tool name: 'MAVEN 3.6.1', type: 'maven'
        sh "${mvnHome}/bin/mvn dependency:tree"
        sh "${mvnHome}/bin/mvn clean package"
        sh "cp /var/lib/jenkins/workspace/build-backend/target/hotelback-0.0.1-SNAPSHOT.war /opt/tomcat/webapps"
    }
}