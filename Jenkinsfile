pipeline {
    agent any
    stages {

        stage("Build")
        {
            steps
            {
                script {
                        echo "INFO: Build Stage"
                        sh "docker build -t docker-app:latest ."
                        echo "INFO: docker image built"
                    }
            }
        }
        stage("Deploy")
        {
            steps
            {
                script {
                            echo "INFO: Deploy Stage"
                            sh "docker rm -f docker-app || true"
                            sh "docker run --restart always -p 8079:8079 -d name docker-app docker-app:latest"
                    }
            }
        }
    }
}
