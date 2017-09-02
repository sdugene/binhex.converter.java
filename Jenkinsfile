node
{
    checkout scm
    def commit = commitSha1()
    def commitMessage = commitMessage()
    def commitAuthor = commitAuthor()

    try
    {
        stage('ConfigureEnv')
        {
            slackSend channel: '#siteoffice-dev', message: "*Starting * ${env.JOB_NAME} ${env.BUILD_NUMBER} from branch *${env.BRANCH_NAME}* (<${env.BUILD_URL}|Open>).\nCommit `${commit}` by ${commitAuthor} message :\n```${commitMessage}```", teamDomain: 'weprogramit', token: 'moRvDpXIeqK2VLiZTF6MBjgM'

            sh "mvn -v"
            sh "java -version"
        }

        stage('Build')
        {
            sh "mvn compile"
        }

        stage('Test')
        {
            sh "mvn test"
            junit "target/surefire-reports/*.xml"
        }

        stage('Sonar')
        {
            sh "mvn sonar:sonar"
        }

        stage('Package')
        {
            sh "mvn clean package"
            slackSend channel: '#siteoffice-dev', color: 'good', message: "success ${env.JOB_NAME} ${env.BUILD_NUMBER}", teamDomain: 'weprogramit', token: 'moRvDpXIeqK2VLiZTF6MBjgM'
        }
    }
    catch(e)
    {
        slackSend channel: '#siteoffice-dev', color: 'danger', message: "Building job ${env.JOB_NAME} from branch *${env.BRANCH_NAME}* on commit `${commit}` \n Job ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>) *FAILED*.\n", teamDomain: 'weprogramit', token: 'moRvDpXIeqK2VLiZTF6MBjgM'

        buildState = 'FAILURE'
        currentBuild.result = 'FAILURE'
    }
}


def commitSha1() {
    sh 'git rev-parse HEAD > commit'
    def commit = readFile('commit').trim()
    sh 'rm commit'
    commit.substring(0, 7)
}

def commitMessage() {
    sh 'git log --format=%B -n 1 HEAD > commitMessage'
    def commitMessage = readFile('commitMessage')
    sh 'rm commitMessage'
    commitMessage
}

def commitAuthor() {
    sh 'git log --format=%cn -n 1 HEAD | tr -d "\n" > commitAuthor'
    def commitAuthor = readFile('commitAuthor')
    sh 'rm commitAuthor'
    commitAuthor
}
