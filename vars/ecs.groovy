def dockerBuildAndPush(){
    sh 'rm -f ~/.dockercfg ~/.docker/config.json || true'
            docker.withRegistry('http://707072725274.dkr.ecr.us-east-1.amazonaws.com/node-app', 'ecr:us-east-1:aws') {
            def customImage = docker.build("node-app:${env.BUILD_ID}")
            customImage.push()                        
         }        
}

def updateTaskdef(){
    // This step should not normally be used in your script. Consult the inline help for details.
withDockerRegistry(credentialsId: 'ecr:us-east-1:aws', url: '707072725274.dkr.ecr.us-east-1.amazonaws.com/node-app') {
    def customImage = docker.build("node-app:${env.BUILD_ID}")
    customImage.push()
}

}

def deployEcs(){

}
