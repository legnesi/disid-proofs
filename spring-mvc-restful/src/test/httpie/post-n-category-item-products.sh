#!/bin/bash

http POST localhost:8080/categories/1/products < category-item-products/n-weapon-products.json
http POST localhost:8080/categories/2/products < category-item-products/n-protection-products.json
http POST localhost:8080/categories/3/products < category-item-products/n-creature-products.json
http POST localhost:8080/categories/4/products < category-item-products/n-machine-products.json

