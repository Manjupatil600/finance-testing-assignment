# Finance QA Assignment

## App Used

**UI Testing** - OrangeHRM Demo  
https://demo.orangehrm.com  
I picked this because it has a proper login flow with validation messages, which is realistic for a finance/HR app. The module I tested is Login.

**API Testing** - Reqres.in  
https://reqres.in  
OrangeHRM demo doesn't expose any REST endpoints so I used reqres.in instead. It has login and user endpoints which are good enough to cover the required scenarios.

---

## Framework and Language

- UI: Selenium 4 + TestNG + Java 11, POM structure
- API: RestAssured 5 + TestNG + Java 11
- Build: Maven

---

## How to Run

Make sure Java 11 and Maven are installed.

**UI Tests:**
```
cd ui-tests
mvn clean test
```

**API Tests:**
```
cd api-tests
mvn clean test
```

ChromeDriver is handled automatically by WebDriverManager. Tests run headless by default.

---

## Assumptions / Limitations

- OrangeHRM demo credentials are Admin / admin123 - these are public defaults but the demo site resets sometimes so if tests fail please check the site manually first
- I used reqres.in for API testing since the demo app doesn't have APIs available to test against
- TC_07 and TC_08 from manual test cases are not automated - I kept automation focused on the main positive and negative flows
- No Thread.sleep used anywhere, all waits are explicit
