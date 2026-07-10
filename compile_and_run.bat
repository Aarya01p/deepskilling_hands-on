@echo off
echo ==================================================
echo Compiling all exercises...
echo ==================================================

if not exist bin mkdir bin

javac -d bin src/exercise1/*.java src/exercise2/*.java src/exercise3/*.java src/exercise4/*.java src/exercise5/*.java src/exercise6/*.java src/exercise7/*.java

if %errorlevel% neq 0 (
    echo Compilation FAILED!
    exit /b %errorlevel%
)
echo Compilation SUCCESSFUL!
echo.

echo ==================================================
echo Running Exercise 1: Inventory Management System
echo ==================================================
java -cp bin exercise1.Main
echo.

echo ==================================================
echo Running Exercise 2: E-commerce Platform Search
echo ==================================================
java -cp bin exercise2.Main
echo.

echo ==================================================
echo Running Exercise 3: Sorting Customer Orders
echo ==================================================
java -cp bin exercise3.Main
echo.

echo ==================================================
echo Running Exercise 4: Employee Management System
echo ==================================================
java -cp bin exercise4.Main
echo.

echo ==================================================
echo Running Exercise 5: Task Management System
echo ==================================================
java -cp bin exercise5.Main
echo.

echo ==================================================
echo Running Exercise 6: Library Management System
echo ==================================================
java -cp bin exercise6.Main
echo.

echo ==================================================
echo Running Exercise 7: Financial Forecasting
echo ==================================================
java -cp bin exercise7.Main
echo.

echo ==================================================
echo Execution completed!
echo ==================================================
