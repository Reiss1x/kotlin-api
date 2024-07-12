Run locally using: docker-compose up --build  
All requests are made in: http://localhost:8080  

create product:  
POST: /prod  
```json
{  
    "prices": 9.99,  
    "name": "Product",  
    "categories": [  
        {  
            "id": 1,  
            "name": "Category1"  
        },  
        {    
            "id": 2,  
            "name": "Category2"  
        }  
    ]  
}  
```
create category:  
POST: /cat
```json
{  
    "name": "Category"  
}
```

get all products:  
/prod  

get product by name:
/prod/"name"  

get product by category name:   
/prod/getBy/"categoryName"    

get all categories:     
/cat

