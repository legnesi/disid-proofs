#!/bin/bash

http POST localhost:8080/customerorders/1/details/batch < customerorder-item-details/n-order1-details.json
http PUT localhost:8080/customerorders/1/details/0 < customerorder-item-details/n-order1-detail1-update.json
http POST localhost:8080/customerorders/2/details/batch < customerorder-item-details/n-order2-details.json

