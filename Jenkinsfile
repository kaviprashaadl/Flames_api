pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = "flames-api" 
        DOCKER_IMAGE_TAG = "latest"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/kaviprashaadl/Flames_api.git', branch: 'main'
            }
        }
        
        stage('Build Java Application') {
            steps {
                script {
                    // Check if it's a Maven project
                    if (fileExists('pom.xml')) {
                        bat 'mvn clean package'
                    } 
                    // Check if it's a Gradle project
                    else if (fileExists('build.gradle')) {
                        bat './gradlew build'
                    } else {
                        error 'Could not detect Maven or Gradle project'
                    }
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    bat '''
                        docker build -t %DOCKER_IMAGE_NAME%:%DOCKER_IMAGE_TAG% .
                    '''
                }
            }
        }
        
        stage('Run Docker Container') {
            steps {
                script {
                    // Stop any existing container with the same name to avoid conflicts
                    bat '''
                        docker stop %DOCKER_IMAGE_NAME% 2>nul || echo Container not running
                        docker rm %DOCKER_IMAGE_NAME% 2>nul || echo No container to remove
                        docker run -d -p 8080:80 --name %DOCKER_IMAGE_NAME% %DOCKER_IMAGE_NAME%:%DOCKER_IMAGE_TAG%
                    '''
                }
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}
