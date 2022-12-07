# yardman

<b>Заметки по оформлению кода , скриптов</b>

<p>1) Liquibase скрипты кладем в каталог src/main/resources/db/changelog/мажор номер релиза/фио разраба/
В changelog-master.yaml добавлять запись вида   - include:  file: src/main/resources/db/changelog/свой скрипт, т.е. includeAll не делаем</p>

<p>2) Git: Постараемся реализовать полную схему : master, develop, feature_N, release <br>
<ol>
<li>master - основной рабочий код</li>
<li>develop - разработка</li>
<li>feature_N - баги + таски</li>
<li>release - сборка</li>
</ol>
</p>


