pipeline 
{
    agent any
    
    stages 
    {
        stage('Build') 
        {
            steps 
            {
                echo 'Build App'
            }
        }
        stage('Test') 
        {
            steps 
            {
                echo 'Test App'
            }
        }
        stage('Deploy') 
        {
            steps 
            {
                echo 'Deploy App'
            }
        }
    }
    post
    {
         always 
         {
            emailext body: 'Summary of the pipeline', subject: 'Pipeline Status', to: 'rushikeshrp049@gmail.com'
         }
    }
}
