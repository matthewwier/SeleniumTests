# selenium-tests
Web application testing with Selenium 3.141.59 and JUnit 4.10. It's possible to run test suites on Chrome, Firefox and Opera by specifying -Dbrowser parameter.

Commands:

mvn test // run all tests

mvn -Dbrowser=Chrome test // run tests on Chrome 73 browser

mvn -Dbrowser=Firefox test // run tests on Firefox 67 browser

mvn -Dbrowser=Opera test // run tests on Opera 60 browser