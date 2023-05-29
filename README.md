# Итоговая контрольная работа
## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
![final1](./img/final1.png)
2. Создать директорию, переместить файл туда.
![final2](./img/final2.png)
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
![final3-1](./img/final3-1.png)
![final3-2](./img/final3-2.png)
4. Установить и удалить deb-пакет с помощью dpkg.
![final4-1](./img/final4-1.png)
![final4-2](./img/final4-2.png)
5. Выложить историю команд в терминале ubuntu

        mkdir final_work
        cd final_work/
        echo "кошки собаки хомяки" | cat > home-animal
        echo "лошадь верблюд осел" | cat > pack-animal
        cat home-animal pack-animal > all-animals
        cat all-animals
        mv all-animals human-friends
        ls -l
        mkdir animals
        mv human-friends animals/
        cd animals/
        ls -l
        sudo wget https://dev.mysql.com/get/mysql-apt-confug_0.8.25-1_all.deb
        sudo dpkg -i mysql-apt-confug_0.8.25-1_all.deb
        sudo apt update
        sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_23.0.6-1~ubuntu.22.04~jammy_amd64.deb
        sudo dpkg -i docker-ce-cli_23.0.6-1~ubuntu.22.04~jammy_amd64.deb
        sudo dpkg -r docker-ce-cli