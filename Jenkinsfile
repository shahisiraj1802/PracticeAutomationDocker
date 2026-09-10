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

    }
}