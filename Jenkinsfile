pipeline {
  agent any
  tools {
      maven 'Maven 3.5.0'
  }
  stages {
    stage('Build Maven'){
      steps{
          checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/phancanh25/testdocker']]])
          sh 'mvn clean install'
      }
    }
    stage('Build docker image'){
        steps{
            script{
                sh 'docker build -t 250122/testdocker .'
            }
        }
    }

    stage('Push image to Hub'){
        steps{
            script{
               sh 'docker login -u 250122 -p Unlock12321@'
               sh 'docker push 250122/testdocker'
            }
        }
    }
    stage('Deploy Java Spring boot app to K8s') {
      steps {
        script {
          kubernetesDeploy(configs: "app-deployment.yaml", "application.yml", "mysql-configmap.yml", "mysql-deployment.yml", "secrets.yaml")
        }
      }
    }
  }
}