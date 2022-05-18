# croncommand
This is a simple cron command project which only print the cron job scheduled time and dont schedule the task in real.

# Running executable</br> 
1. ./gradlew shadowJar
2.  java -jar build/libs/cron.jar "*/15" "0" "1,15" "*" "1-5" "/command"
</br>
<pre>
minute         0 15 30 45
hour           0
days of month  1 15
month          1 2 3 4 5 6 7 8 9 10 11 12
day of week    1 2 3 4 5
command        /command </pre>       

# Known Bugs
</br> All arguments should not be passed as single argument and instead passed as a separate arguments. </br>
No special handling of Feb month and exact days in other months (30/31).
