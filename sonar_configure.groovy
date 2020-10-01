import hudson.model.*;
import jenkins.model.*;
import hudson.tools.*;
import hudson.plugins.sonar.*;
// import hudson.plugins.sonar.model.TriggersConfig

  

  def sonar_name = "sonar-pm"
  
  def sonar_server_url = "http://3.7.154.171:9000"
  def sonar_auth_token = "testtoken"

  def instance = Jenkins.getInstance()
def jenkins1 =jenkins.model.Jenkins.get();


 def test= Jenkins.getDescriptor(SonarGlobalConfiguration)
 

    sleep(1000)
    println("Configuring SonarQube...")

    // Get the GlobalConfiguration descriptor of SonarQube plugin.
    def SonarGlobalConfiguration sonar_conf = instance.getDescriptor(SonarGlobalConfiguration.class)
   
     
    def sonar_inst = new SonarInstallation(
        sonar_name,
        sonar_server_url,
      '',
        sonar_auth_token,
      '',
        '',
        '',
        '',
        ''
    )
    
    def sonar_installations = sonar_conf.getInstallations()
    sonar_installations += sonar_inst
    sonar_conf.setInstallations((SonarInstallation[]) sonar_installations)
    sonar_conf.save()
    
    instance.save()
  
    
