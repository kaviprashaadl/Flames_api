pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = "flames-api" // Change to your image name
        DOCKER_IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                git https://github.com/kaviprashaadl/Flames_api.git
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    sh '''
                        docker build -t $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG .
                    '''
                }
            }
        }
        
        stage('Push Docker Image') {
            steps {
                script {
                    // Run the Docker image locally on the machine
                    sh '''
                        docker run -d -p 8080:80 $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG
                    '''
                }
            }
        }
        }
    }

    post {
        always {
            cleanWs() // Clean up the workspace after the build
        }
    }
}
