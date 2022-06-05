# currency-service


# Инструкция для запуска #
##### 1. Скопируйте репозиторий и перейдите к нему в папку #####

    git@github.com:holydrug/currency-service.git
    cd currencySerivce

##### 2. В папке resources содержится параметры, #####

    настройте в блоке openexchange symbols
    (ваши желаемые валюты для получения отношения к доллору)
    
    настройте в блоке openexchange to_compare
    (валюта, отношение которой будет влиять на гифку, которая покажется)
   
##### 3. Вернитесь в корневой раздел папки и соберите проект в jar #####

    ./gradlew build
   
##### 4. Запустите приложение (у вас должна быть установлена 8 джава) #####

    java -jar build/libs/alfabank-test-wallet-course-0.0.1-SNAPSHOT.jar

##### 5. Попробуйте достучатся по адрессу http://localhost:8080/check #####
    Если вы все сделали правильно, вы получите 3 варианта гифки:
     - Курс не изменился 
     - Курс повысился    
     - Курс понизился    

## Логика проекта ##
##### 1. Все начинается с того, что я должен получить данные с сайтов, чтобы их обработать #### 
    
    Я создал 2 класса: RatesApi и GifApi
    GifApi и RatesApi использую Feign чтобы достучатся до апи сайта из интернета и получить все данные вида JsonNode.

##### 2. RatesApi #### 

    Получает блок данных, из которых я вычлиняю отношения валют к доллару.
    В конце концов возращаю мапу НазваниеВалюты-Отношение или <String, Double>

##### 3. GifApi ####

    Получает блок данных, из которых я вычлинаю ссылку на одинокую гифку,
    после я конверчу гифку в массив байтов и возвращаю его.

##### 4. GifServiceImpl #####
    
    Имеет 3 основных метода, которые будут описывать отношение валюты к доллару
    
##### 5. CurrencyServiceImpl #####

    Сводится к тому, что метод compareRates() вернет -1 либо 0, либо 1
    Что будет означать отношение валюты.

##### 6. DistributionServiceImpl #####

    Объединяет сервисы и в зависимости от сравнения метода compareRates() 
    покажет гифку, отображающую курс сравниваемой валюты
