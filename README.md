Data-Driven Test Example
=========================

Tools and Java APIs
--------------------
1. Rest-Assured
2. TestNG
3. Jxl to extract data from Excel files

What is Data-Driven framework?
------------------------------
- Framework which runs test case multiple times with different input and validation values. These values should be in external souce file such as Json, Xml, Excel .. etc.

Why Data-Driven framework?
--------------------------
- Reduces the maintainability of the scripts.
- Makes it easy to add new test cases. To add new test cases


Demo
------

 1. Create Maven project 
 2.  Add Rest-Assured, TestNG and Jxl dependencies to the pom.xml file. You can find your dependencies here http://mvnrepository.com/ 
 3. Create DataDrivenTCs class and paste the attached code to it
 4. Add the attached Excel file to the project directory 
 5. Run DataDrivenTCs class as TestNG Test
 6. test-output directory will be generated contains HTML and XML

