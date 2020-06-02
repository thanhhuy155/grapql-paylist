def execSuites = ""
def platform = ""

pipeline{
	agent any
	parameters {
    			string(name: "MilestoneId", defaultValue: "", description: "Input Milestone")
    			string(name: "HashedAppId", defaultValue: "", description: "Input Hashed App Id")
    			choice(name: "ExecutionOS", choices: ["ANDROID_BROWSERSTACK", "IOS_BROWSERSTACK"], description: "Select environment")
            }
	tools {
        maven 'Maven3'
        jdk 'JDK8'
    }
	stages{
    		stage ('Test'){
    			steps{
    				node ('android'){
    					git branch: 'regression',
    						credentialsId: 'b4006acc-b754-4381-9c27-c1c5d9c1629b',
    						url: 'https://HeraNguyen@bitbucket.org/HeraNguyen/mobile-test-pcom.git'

                       script{

                            if(params.ExecutionOS == "ANDROID_BROWSERSTACK"){
                                execSuites = "MasterSuite_AndroidAllTests.xml" //"Suite_HomeTab.xml";
                                platform = "Android"
                            }else{
                                execSuites = "MasterSuite_iOSAllTests.xml" //"Suite_iOSHomeTab.xml";
                                platform = "iOS"
                            }
                            if(params.HashedAppId != ""){
                                // Run test suites
                                bat "mvn clean test -DexecOS=${params.ExecutionOS} -DappId=${params.HashedAppId} -DsuiteXmlFile=$execSuites"
                            }
                        }
                    }
    			}
    		}
    }
	post{
		always{
            node('android')
            {
                script{
                    if(params.MilestoneId != ""){
                        //Upload results to TestRail
                        bat "java -jar Tools/testrail-junit.jar -h https://inquirer.testrail.net -u spham@inquirer.com -p Enclave123 -j 4 -e 6 -m %MilestoneId% -d ./target/surefire-reports -g junitreports\\*.xml -i \"Automated results from Jenkins for project: ${BUILD_URL}\""
                   }
                }
                bat 'C:\\Users\\Administrator\\.jenkins\\tools\\allure2.6.0\\allure-2.6.0\\bin\\allure.bat generate C:\\agents\\android\\workspace\\NativeApp\\allure-results -c -o C:\\agents\\android\\workspace\\NativeApp\\allure-report'
                allure([
        			includeProperties: false,
        			jdk: '',
        			properties: [],
        			reportBuildPolicy: 'ALWAYS',
        			results: [[path: '**/allure-result']],
      			])

            }
            emailext attachLog: true,
                body: '''${SCRIPT, template="/groovy-html-test.template"}
                    <br/>
                    <b/>
                    <p><font font="Verdana" size="2" color="navy">Please click the link to see the detail report: </font>
                    &QUOT;<a href='http://100.26.222.41:8080/view/TestExampleProjects/job/$JOB_NAME/$BUILD_NUMBER/allure/'>Allure Report link</a>&QUOT;</p>
                    <b/>
                    <p><font font="Verdana" size="2" color="navy">BrowserStack build '''+ "$platform" +''': </font>
                    &QUOT;<a href='https://app-automate.browserstack.com/'>BrowserStack link</a>&QUOT;</p>

                    <br/>''',
                postsendScript: '$DEFAULT_POSTSEND_SCRIPT',
                presendScript: '$DEFAULT_PRESEND_SCRIPT',
                subject: '$DEFAULT_SUBJECT - '+ "$platform",
               to: 'spham@inquirer.com'
		}
	}

}