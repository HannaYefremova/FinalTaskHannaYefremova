### Selenium tests for site [Presta Shop](https://demo.prestashop.com/)


1. For executing test run command:

```
mvn clean test
```

2. For viewing allure report command:

```
mvn allure:serve
```

3. For creating allure report command:

```
mvn allure::report
```

4. Starting of the tests can be parametrised by additional parameters:

- for execute custom test suite:

```
-Dsuite="filename"  
```

- for execute test in different count of threads:

```
-Dthreads=number of threads 
```

- for execute in different browser:

```
-Dbrowser=name of browser 
```

-for execute with different window height:

```
-DbrowserHeight=height
```

-for execute with different window width:

```
-DbrowserWidth=width
```




