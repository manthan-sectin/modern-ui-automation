pipeline {
    agent any

    stages {

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t cucumbertestcaseimage .'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                bat 'docker-compose up -d selenium-hub chrome firefox'
            }
        }

        stage('Parallel Test Execution') {
            parallel {

                stage('Chrome Execution') {
                    steps {
                        bat 'docker-compose up --abort-on-container-exit cucumber-testcase-chrome'
                    }
                    post {
                        always {
                            emailext(
                                attachLog: true,
                                attachmentsPattern: 'dockerreportchrome/index.html',
                                subject: '$PROJECT_NAME - Chrome - Build #$BUILD_NUMBER - $BUILD_STATUS',
                                to: 'malimanthan56@gmail.com',
                                body: '''
                                <h2>🚀 Chrome Automation Execution</h2>
                                <p>Execution completed on Chrome browser.</p>
                                <p>Please find the attached report.</p>
                                '''
                            )
                        }
                    }
                }

                stage('Firefox Execution') {
                    steps {
                        bat 'docker-compose up --abort-on-container-exit cucumber-testcase-firefox'
                    }
                    post {
                        always {
                            emailext(
                                attachLog: true,
                                attachmentsPattern: 'dockerreportfirefox/index.html',
                                subject: '$PROJECT_NAME - Firefox - Build #$BUILD_NUMBER - $BUILD_STATUS',
                                to: 'malimanthan56@gmail.com manthan60@gmail.com',
                                body: '''
                                <h2>🚀 Firefox Automation Execution</h2>
                                <p>Execution completed on Firefox browser.</p>
                                <p>Please find the attached report.</p>
                                '''
                            )
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            bat 'docker-compose down'
        }
    }
}
