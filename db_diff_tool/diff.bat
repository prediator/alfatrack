@set OutFile=..\src\main\resources\liquibase\changelog_new.xml
@set old_db=alfatrack_test
@set new_db=alfatrack_

REM *****************************************************************
REM *   creating database changelog file:
REM *   %OutFile%
REM *****************************************************************

libs\liquibase.bat ^
    --classpath=libs/mysql-connector-java-5.1.14.jar ^
    --driver=com.mysql.jdbc.Driver ^
    --url=jdbc:mysql://localhost:3306/%old_db% ^
    --username=root ^
    --password=join0db ^
    diffChangeLog ^
    --referenceUrl=jdbc:mysql://localhost:3306/%new_db% ^
    --referenceUsername=root ^
    --referencePassword=join0db ^
    > %OutFile%