Run locally using: mvn quarkus dev

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

get product by category name:   
/prod/getBy/"categoryName"    

to-do: docker
