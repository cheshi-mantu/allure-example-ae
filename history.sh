# I need this for I have defined a custom command to execute allure2 and allure3 in my .zshrc file.

#alias allure2='/opt/homebrew/Cellar/allure/2.34.1/bin/allure'
#alias allure3='/Users/something/.nvm/versions/node/v21.7.3/bin/allure'

source ~/.zshrc


rm -rf build/
rm -rf allure-report/

./gradlew clean test
allure2 generate ./build/allure-results

./gradlew clean test
cp -r ./allure-report/history ./build/allure-results/
rm -rf allure-report

./gradlew clean test
allure2 generate ./build/allure-results

./gradlew clean test
cp -r ./allure-report/history ./build/allure-results/
rm -rf allure-report

allure2 generate ./build/allure-results
allure2 serve ./allure-report