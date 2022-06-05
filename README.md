# currencySerivce


# Инструкция для запуска #
## 1. Скопируйте репозиторий и перейдите к нему в папку ##

    git clone git@github.com:holydrug/currencySerivce.git
    cd currencySerivce

## 2. В папке resources содержится параметры, ##

    настройте в блоке openexchange symbols
    (ваши желаемые валюты для получения отношения к доллору)
    
    настройте в блоке openexchange to_compare
    (валюта, отношение которой будет влиять на гифку, которая покажется)
   
## 3. Вернитесь в корневой раздел папки и соберите проект в jar ##

    ./gradlew build
   
## 4. Запустите приложение (у вас должна быть установлена 8 джава) ##

    java -jar build/libs/alfabank-test-wallet-course-0.0.1-SNAPSHOT.jar

## 5. Попробуйте достучатся по адрессу http://localhost:8080/check ##
    Если вы все сделали правильно, вы получите 3 варианта гифки:
     1)Курс не изменился (nothing)
     2)Курс повысился    (rich)
     3)Курс понизился    (broke)

