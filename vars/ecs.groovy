def dockerBuildAndPush(){
    sh 'rm -f ~/.dockercfg ~/.docker/config.json || true'
        //     docker.withRegistry('https://707072725274.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:aws') {
        //     def customImage = docker.build("node-app:${env.BUILD_ID}")
        //     customImage.push()                        
        //  }    
        withDockerRegistry(credentialsId: 'ecr:us-east-1:aws', url: 'https://707072725274.dkr.ecr.us-east-1.amazonaws.com') {
             def customImage = docker.build("node-app:${env.BUILD_ID}")
             customImage.push()
}    
}

def updateTaskdef(){
    // This step should not normally be used in your script. Consult the inline help for details.
withDockerRegistry(credentialsId: 'ecr:us-east-1:aws', url: 'https://707072725274.dkr.ecr.us-east-1.amazonaws.com') {
    def customImage = docker.build("node-app:${env.BUILD_ID}")
    customImage.push()
}

}

def deployEcs(){

}
