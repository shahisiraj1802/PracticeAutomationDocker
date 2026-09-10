pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/shahisiraj1802/PracticeAutomationDocker.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t practiceautomation .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USERNAME',
                    passwordVariable: 'DOCKER_PASSWORD'
                )]) {

                    bat 'echo %DOCKER_PASSWORD% | docker login -u %DOCKER_USERNAME% --password-stdin'

                    bat 'docker tag practiceautomation %DOCKER_USERNAME%/practiceautomation:latest'

                    bat 'docker push %DOCKER_USERNAME%/practiceautomation:latest'
                }
            }
        }

    }
}