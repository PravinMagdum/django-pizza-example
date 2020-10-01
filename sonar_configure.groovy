import hudson.model.*
import jenkins.model.*
import hudson.tools.*;
import hudson.plugins.sonar.*;
import hudson.plugins.sonar.model.TriggersConfig;
import hudson.util.Secret;

import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl;


  

  def sonar_name = "sonar-pm1"
  
  def sonar_server_url = "http://3.7.154.171:9000"
  def sonar_auth_token = "global-sonartoken"
def sonar_triggers = new TriggersConfig()

  def instance = Jenkins.getInstance()

  println("Configuring SonarQube...")

    // Get the GlobalConfiguration descriptor of SonarQube plugin.
    def SonarGlobalConfiguration sonar_conf = instance.getDescriptor(SonarGlobalConfiguration.class)
    
   def webhooks = Secret.fromString('sdfsdfs')
   
     
    def sonar_inst = new SonarInstallation(
        sonar_name,
        sonar_server_url
        ,sonar_auth_token,webhooks,
        
        '',
        '',
        '','',
      sonar_triggers
    )
    
    def sonar_installations = sonar_conf.getInstallations()
    sonar_installations += sonar_inst
    sonar_conf.setInstallations((SonarInstallation[]) sonar_installations)
    sonar_conf.save()
    
    instance.save()
  
