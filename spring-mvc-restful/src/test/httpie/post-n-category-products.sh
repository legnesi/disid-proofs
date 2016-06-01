#!/bin/bash

http PUT localhost:8080/categories/1/products [1,2,3,4,5,6,7,8,9,14,15,16]
http PUT localhost:8080/categories/2/products [12,13]
http PUT localhost:8080/categories/3/products [9,14,15,16]
http PUT localhost:8080/categories/4/products [10,11]

