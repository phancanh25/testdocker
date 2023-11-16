pipeline {
	agent any
	stages {
		stage('One') {
			steps {
				echo 'Hi, starting!!!'
			}
		}

		stage('Two') {
			steps {
				input('Do you want to proceed?')
			}
		}

		stage('Five') {
			steps {
				echo 'Finished'
			}
		}
	}
}