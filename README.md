# currency-service

## Overview ## 
 - Main purpose of project is to handle rate of currency to USD for different time
 - Program will show Gif visualization of rate after handling it.

## Logic ##
##### Receiving data overview  #### 
    
    There are two classes: RatesApi и GifApi.
    GifApi and RatesApi uses Feign for access to sites api from ethernet and receive JsonNode data.

##### RatesApi #### 

    Receive data from request by Feign client and cut it to rates only.
    Return map NameOfCurrency-Rate or <String, Double>.

##### 3. GifApi ####

    Receive data from request by Feign client and cut it to url of image only.
    Url gif will be converted to byte[]

##### 4. GifServiceImpl #####
    
    There are 3 methods that discribes rate of currency to USD in gif by query
    
##### 5. CurrencyServiceImpl #####

    compareRates() method return -1 or 0 or 1
    That digits will be discribe how is USD rate has changed

##### 6. DistributionServiceImpl #####

    Distribution links services and depends on compareRates() 
    response return proper gif

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
