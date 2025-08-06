pipeline {
    agent {
        label 'jenkins-agent'
    }

    environment {
        SERVICE_REPO='https://gitlab.com/altyapistaj-group/demoservice.git'
        BRANCH_NAME='library-dependency'
    }

    stages {
        stage('Checkout demo-service') {
            steps {
                sshagent(credentials: ['gitlab-ssh-key']){
                echo 'Cloning demo-service repository'
                sh 'rm -rf demo-service && git clone --branch $BRANCH_NAME $SERVICE_REPO demo-service'
                }
            }
        }
        stage('Build demo-library'){
            steps{
                build job: 'demo-library-pipeline', wait: true, propagate: true
                }
            }

        stage('Build demo-service'){
            steps{
                dir('demo-service'){
                    sh 'mvn clean install'
                }
            }
        }

        stage('Extract demo-service'){
            steps{
                dir('demo-service'){
                    sh '''
                    rm -rf docker/layers
                    mkdir -p docker/layers
                    JAR_NAME=$(ls target/*.jar |head -n 1)
                    java -Djarmode=layertools -jar $JAR_NAME extract --destination docker/layers
                    '''
                }
            }
        }

        stage('Build Docker'){
            steps{
                dir('demo-service'){
                        sh 'docker build -f Dockerfile . --tag localhost:5000/demo-service:latest'

                }
            }
        }

        stage('Push to Zot'){
            steps{
                    sh 'docker push localhost:5000/demo-service:latest'
            }
        }
    }
}