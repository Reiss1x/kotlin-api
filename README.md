Run locally:  
clone project: ``https://github.com/Reiss1x/kotlin-api.git``  
acces project directory: ``cd .\kotlin-api\``  
run command: ``./mvnw package``  
run docker: ``docker-compose up --build``  

All requests are made in: http://localhost:8080  

create product:  
POST: ``/prod``  
```json
{  
    "prices": 9.99,  
    "name": "Product",  
    "categories": [  
        {   
            "name": "Category1"  
        },  
        {    
            "name": "Category2"  
        }  
    ]  
}  
```
create category:  
POST: ``/cat``
```json
{  
    "name": "Category"  
}
```

get all products:  
``/prod``  
get all categories:     
``/cat``

get product by name:  
``/prod/"name"``  
get product by category name:   
``/prod/getBy/"categoryName"``  



