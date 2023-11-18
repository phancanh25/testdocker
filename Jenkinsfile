pipeline {
  environment {
    dockerimagename = "250122/testdocker"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps {
        git 'https://github.com/phancanh25/testdocker.git'
      }
    }
    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }
    stage('Pushing Image') {
      environment {
               registryCredential = 'dckr_pat_pa6YV_ytqkAMJ-OChAx8tjRqc28'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("1.0")
          }
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