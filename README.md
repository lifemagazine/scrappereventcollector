# scrappereventcollector
Scrapper event collector


This system is made up of logstash, spring boot and rabbitmq.<br>

The sequency of operation<br>
0. Logstach read log files of crawler, then send data to the scrapper event collector by rest.<br>
1. The other crawler send data to the scrapper event collector by rest directly.<br>
2. The scrapper event collector save the received data from crawler and then status data of the crawler send to rabbitmq.
