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