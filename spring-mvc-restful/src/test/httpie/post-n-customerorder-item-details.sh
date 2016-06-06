#!/bin/bash

http POST localhost:8080/customerorders/1/details < customerorder-item-details/n-order1-details.json
http POST localhost:8080/customerorders/2/details < customerorder-item-details/n-order2-details.json

