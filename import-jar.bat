:: Description Import dependency jars
:: Author jinzhencheng at 2017/03/07 

@echo off
mvn dependency:copy-dependencies -DoutputDirectory=e:\lib  -DincludeScope=runtime

echo "----It has imported jars to e:\lib directory-----"
