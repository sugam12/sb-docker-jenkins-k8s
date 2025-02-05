pipeline{
    agent any
            tools{
                maven 'Maven_3.9.9'
            }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sugam12/sb-docker-jenkins-k8s']])
                sh  'mvn clean install'
            }
        }
        stage('test docker'){
            steps{
                echo '--------------------Listing images on docker----------------'
                sh 'docker images'
                script{
                    sh  'docker build -t sugam0912/department .'
                }
            }
        }
        stage('------------push image to docker hub------------------'){
            steps{
                script{
                    sh 'docker login -u sugam0912 -p P@ssw0rd!'
                    //todo password in vault
                    sh 'docker push sugam0912/department'
                }
            }
        }
    }
}