pipeline{
	agent{label "ec2_fleet"}
	options{
		timestamps()
		}
	parameters{
		string(name:'Name')
		}
		stages{
			stage('first stage'){
				agent{label 'master'}
				steps{
					sh 'python first_stage.py'
					}
				}
			stage('second stage'){
				agent{label 'ec2-slave'}
				steps{
					sh "echo everything works great"
					}
				}
			}
		}

					

