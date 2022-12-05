# yardman

Заметки по оформлению кода , скриптов
Liquibase скрипты кладем в каталог src/main/resources/db/changelog/мажор номер релиза/фио разраба/
В changelog-master.yaml добавлять запись вида   - include:  file: src/main/resources/db/changelog/свой скрипт, т.е. includeAll не делаем
