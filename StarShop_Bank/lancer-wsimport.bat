echo %JAVA_HOME%
set WSDL_URL=http://localhost:8080/StarShop_Bank/services/ValiderCarteBancaire?wsdl
cd /d "%~dp0"
"%JAVA_HOME%/bin/wsimport" -d src/main/java/fr/afcepf/al24/bank/service/generated -keep %WSDL_URL%
pause