pipeline{
  agent any

  environment{
    EMAIL_RECIPIENTS = "subhashdasamnmnew@gmail.com, madvidreo@gmail.com"
    GIT_URL = "https://github.com/dasamnm/twentytwo.git"
    GIT_BRANCH = "master"
  }

  stages{
    stage('checkout'){
      steps{
        git url : "${GIT_URL}", branch : "${GIT_BRANCH}"
      }
    }
    stage('Test')
    {
      steps{
         sh 'mvn test'
      }
    }
    
  }
  post{
    success{
      emailext(
        subject : "Test passed - JOB ${env.JOB_NAME} ${env.BUILD_NUMBER}"
        body : """\
         Hello Team,
         All Automation tests have successfully executed.
         You can review the details here: ${env.BUILD_URL}

         Best Regards,
          Jenkins CI
        """,
        to: "${EMAIL_RECIPIENTS}"
        
      )
    }
    failure{
      emailext(
      subject : "Test Failed - JOB ${env.JOB_NAME} ${env.BUILD_NUMBER}"
      body : """\
      Hello Team,
      Test has been failed.

      Please review the details here : ${env.BUILD_URL}
      
      """,
        to: "${EMAIL_RECIPIENTS}"
    )
      }
        
  }
}
