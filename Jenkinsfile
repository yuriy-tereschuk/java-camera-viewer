@Library('piper-lib-os') _

pipeline {

  agent any

  stages {
    stage('prepare') {
      steps {
        checkout scm
        setupCommonPipelineEnvironment script:this
      }
    }
    stage('build') {
      steps {
        gradleExecuteBuild script:this
      }
    }
    stage('static code check') {
      steps {
        sonarExecuteScan script:this
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: '*.json', fingerprint: true
    }
  }
}

