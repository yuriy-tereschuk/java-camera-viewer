@Library('piper-lib-os') _

pipeline {

  agent any

  stages {
    stage('prepare') {
        checkout scm
        setupCommonPipelineEnvironment script:this
    }
    stage('build') {
		gradleExecuteBuild script:this
    }
    stage('static code check') {
		sonarExecuteScan script:this
    }
  }

  post {
    always {
      archiveArtifacts artifacts: '*.json', fingerprint: true
    }
  }
}

