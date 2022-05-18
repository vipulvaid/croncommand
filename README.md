# croncommand
This is a simple cron command project which only print the cron job scheduled time and dont schedule the task in real.

# Running executable
1. ./gradlew shadowJar
2.  java -jar build/libs/cron.jar "*/15" "0" "1,15" "*" "1-5" "/command"
</br>
minute         0 15 30 45</br>
hour           0</br>
days of month  1 15</br>
month          1 2 3 4 5 6 7 8 9 10 11 12</br>
day of week    1 2 3 4 5</br>
command        /command   </br>           
</br>
# Known Bugs:
All arguments should not be passed as single argument and instead passed as a separate arguments.
No special handling of Feb month and exact days in other months.
