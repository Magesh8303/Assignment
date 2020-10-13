# Assignment

##Steps

### configuration changes

1.we should chnage the log file folder path in "src/main/resouce/log4j2.xml".
Colon D: is a defalut path in our demo application.

2.Once the build is succeed.Application runs in 8086 port.
URL:http://localhost:8086/demo/test

3.If Application started succsfully, then we should type the above url in browser.
"Application Started" is defalut message will appear in browser.


## Passing data to api

Here I mentioned api end points name and url and http methods and sample input and  output.

### 1.Adding person information

URL: http://localhost:8086/demo/addperson 
Http method :Post
Data format :json
smaple datta: [
    {
        "id":"1",
        "firstName":"Magesh",
        "lastName":"Kumar"
    },
    {
        "id":2,
        "firstName":"Magesh",
        "lastName":"Kumar"
    }
]

** output **: {
    "code": 201,
    "message": "Person Added Sucessfully"
}

### 2.Editing Person information

URL: http://localhost:8086/demo/editperson
Http method :PUT
Data format :json
smaple datta: [
    {
        "id":"1",
        "firstName":"Magesh",
        "lastName":"Kumar"
    },
    {
        "id":2,
        "firstName":"MageshTest",
        "lastName":"Kumartest"
    }
]

**output**:{
    "code": 200,
    "message": "Person Edited Sucessfully"
}

### 3.Deleting Person information

URL: http://localhost:8086/demo/deleteperson/2
Http method :DELTE
**output**:{
    "code": 200,
    "message": "Person Deleted Sucessfully"
}

### 4.Listing Person information
URL:http://localhost:8086/demo/listperson
Http method :GET
**output**:{
    "code": 200,
    "message": "[{\"id\":1,\"firstName\":\"Magesh\",\"lastName\":\"Kumar\"}]"
}

### 5.Adding Address information
URL: http://localhost:8086/demo/addaddress 
Http method :Post
Data format :json
smaple datta: [
    {
        "id":1,
        "street":"74B",
        "city":"Chennai",
        "state":"TamilNadu",
        "postalCode":"641659"
    },
    {
        "id":2,
        "street":"74-B",
        "city":"Coimbatore",
        "state":"TamilNadu",
        "postalCode":"641659"
    }
]

output: {
    "code": 201,
    "message": "Address Added Sucessfully"
}

### 6.Editing Address information

URL: http://localhost:8086/demo/editaddress
Http method :PUT
Data format :json
smaple datta: [
    {
        "id":1,
        "street":"74B",
        "city":"Chennai",
        "state":"TamilNadu",
        "postalCode":"641659"
    },
    {
        "id":2,
        "street":"74-B",
        "city":"Coimbatore",
        "state":"TamilNadu",
        "postalCode":"641659"
    }
]

output: {
    "code": 200,
    "message": "Address Edited Sucessfully"
}

### 6.Deleting Address information

URL:http://localhost:8086/demo/deleteaddress/2
Http method :DELTE
output:{
    "code": 200,
    "message": "Address Deleted Sucessfully"
}


