# Express Recipes Filter

The request to the route `/recipes/shopping-list?ids` returns a list of all the aggregated ingredients contained in the matching IDs. The query parameter that can be used to set the recipe id is:

- `ids:` A comma-separated list of IDs for which the ingredients have to be aggregated. [STRING]

_Note: The ingredients should only be aggregated for the IDs that match any of the recipe IDs present in the Recipe list, which is contained in the recipes.json file. All the non-matching IDs can be ignored entirely from the response._

Each Recipe object has a list of ingredients stored in the ingredients property of the object, as can be seen here:
```json
{
    "id" : 1,
    "name": "Pot Roast",
    "ingredients": [
        {
            "quantity": "1",
            "name": " beef roast",
            "type": "Meat"
        },
        {
            "quantity": "1 package",
            "name": "brown gravy mix",
            "type": "Baking"
        }
    ]
}
```
     
### Routes
- `/recipes/shopping-list?ids` - The route to fetch all the aggregated ingredients for the matching recipes. The query parameter ids is mandatory, and the server should send a status code 400 if the query parameter ids is blank or not present. If none of the IDs passed match with the IDs present in the data-store, the server should send a status code 404 with `NOT_FOUND` in the body of the response.  

### Examples
- `/recipes/shopping-list`
```text
Response

Status Code - 400
```

- `/recipes/shopping-list?ids=asdasd`
```text
Response

Status Code - 404
Body - NOT_FOUND
```

- `/recipes/shopping-list?ids=3`
```json
[
  {
    "quantity":"1 quart",
    "name":"beef broth",
    "type":"Misc"
  },
  {
    "quantity":"1 cup",
    "name":"dried green lentils",
    "type":"Misc"
  }
]
```

### Project Specifications

**Read-Only Paths**
- test
- bin
- recipes.json

**Commands**
- run: `npm start`
- install: `npm install`
- test: `npm test`
