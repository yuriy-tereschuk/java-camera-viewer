@Library('piper-lib-os') _
node() {
    stage('prepare') {
        checkout scm
        setupCommonPipelineEnvironment script:this
    }
	stage('build') {
		gradleBuild script:this
	}
	stage('static code check') {
		sonarExecuteScan script:this
	}
}