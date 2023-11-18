pipeline {
  tools{
         maven 'maven_3_5_0'
     }
  agent any
  stages {
    stage('Build Maven'){
      steps{
          checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/phancanh25/testdocker']]])
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
//                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
//                 sh 'docker login -u 250122 -p ${dockerhubpwd}'
//                 }
               sh 'docker login -u 250122 -p Unlock12321@'
               sh 'docker push 250122/testdocker'
            }
        }
    }

//     stage('Pushing Image') {
//       environment {
//                registryCredential = 'dckr_pat_pa6YV_ytqkAMJ-OChAx8tjRqc28'
//            }
//       steps{
//         script {
//           docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
//             dockerImage.push("1.0")
//           }
//         }
//       }
//     }
    stage('Deploy Java Spring boot app to K8s') {
      steps {
        script {
          kubernetesDeploy(configs: "app-deployment.yaml", "application.yml", "mysql-configmap.yml", "mysql-deployment.yml", "secrets.yaml")
        }
      }
    }
  }
}