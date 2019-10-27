#!/bin/bash
#description="Automated results from Jenkins for native project"
#j # project id
#e # env 6 # Android
#m #mileStoneId = 40

java -jar Tools/testrail-junit.jar -h https://inquirer.testrail.net -u spham@inquirer.com -p Enclave123 -j 4 -e 6 -m 40 -d ./target/surefire-reports -g junitreports\\*.xml -i "Automated results from Jenkins for project"'