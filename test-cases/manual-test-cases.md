# Manual Test Cases - Login Module
**App:** OrangeHRM Demo (https://demo.orangehrm.com)  
**Module:** Login  
**Tester:** Manjunath  

---

| TC ID | Test Description | Steps | Expected Result | Priority |
|-------|-----------------|-------|-----------------|----------|
| TC_01 | Login with valid username and password | 1. Go to https://demo.orangehrm.com <br> 2. Enter username as Admin <br> 3. Enter password as admin123 <br> 4. Click Login | User should land on Dashboard page | High |
| TC_02 | Verify page title after successful login | 1. Login with valid credentials <br> 2. Check the page heading after redirect | Dashboard heading should be visible on screen | High |
| TC_03 | Login with wrong password | 1. Enter username Admin <br> 2. Enter wrong password like admin999 <br> 3. Click Login | Should show error - "Invalid credentials" | High |
| TC_04 | Login with empty username | 1. Keep username blank <br> 2. Enter valid password <br> 3. Click Login | Should show "Required" below username field | High |
| TC_05 | Login with empty password | 1. Enter valid username <br> 2. Keep password blank <br> 3. Click Login | Should show "Required" below password field | High |
| TC_06 | Submit form with both fields empty | 1. Don't enter anything <br> 2. Directly click Login button | Both fields should show Required error | Medium |
| TC_07 | Username with 1 character only (boundary) | 1. Enter just one letter in username like "A" <br> 2. Enter any password <br> 3. Click Login | Should fail with invalid credentials error | Medium |
| TC_08 | Check if user can access dashboard without login | 1. Without logging in, try to open https://demo.orangehrm.com/web/index.php/dashboard/index directly | Should redirect back to login page | High |
