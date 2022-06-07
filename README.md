# currency-service

## Overview ## 
 - Main purpose of project is to handle rate of currency to USD for different time
 - Program will show Gif visualization of rate after handling it.

## Logic ##
##### Receiving data overview  #### 
    
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

# Building #
##### 1. Copy repo to local and move to dir #####

    git clone git@github.com:holydrug/currencyService.git
    cd currencySerivce

##### 2. In resources dir you should setup params #####

    set up in openexchange unit symbols in application-dev.yml
    (prefered currency to be shown as rates to USD)
    
    set up in openexchange unit to_compare in application-dev.yml
    (primary rate which will be compared to USD to show gif)

##### 3. Go to root and build app #####

    ./gradlew build

##### 4. Run built jar #####

    java -jar build/libs/alfabank-test-wallet-course-0.0.1-SNAPSHOT.jar

##### 5. Try to http://localhost:8080/check #####
    There will be 3 options:
     - Rate has not changed
     - Rate has grown
     - Rate has broken    
