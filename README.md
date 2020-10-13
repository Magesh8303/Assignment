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

Mentioned api end points name and url and http methods and sample input and  output.

### 1.Adding person information

URL: http://localhost:8086/demo/addperson<br /> 
Http method :POST<br />
Data format :json<br />
sample data: [
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
]<br />
**output **: {
    "code": 201,
    "message": "Person Added Sucessfully"
}<br />

### 2.Editing Person information

URL: http://localhost:8086/demo/editperson<br />
Http method :PUT<br />
Data format :json<br />
sample data: [
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
]<br />

**output**:{
    "code": 200,
    "message": "Person Edited Sucessfully"
}<br />

### 3.Deleting Person information

URL: http://localhost:8086/demo/deleteperson/2<br />
Http method :DELTE<br />
**output**:{
    "code": 200,
    "message": "Person Deleted Sucessfully"
}<br />

### 4.Listing Person information
URL:http://localhost:8086/demo/listperson<br />
Http method :GET<br />
**output**:{
    "code": 200,
    "message": "[{\"id\":1,\"firstName\":\"Magesh\",\"lastName\":\"Kumar\"}]"
}<br />

### 5.Adding Address information
URL: http://localhost:8086/demo/addaddress <br />
Http method :Post<br />
Data format :json<br />
sample data: [
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
]<br />
**output**: {
    "code": 201,
    "message": "Address Added Sucessfully"
}<br />

### 6.Editing Address information

URL: http://localhost:8086/demo/editaddress<br />
Http method :PUT<br />
Data format :json<br />
sample data: [
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
]<br />
**output**: {
    "code": 200,
    "message": "Address Edited Sucessfully"
}<br />

### 6.Deleting Address information

URL:http://localhost:8086/demo/deleteaddress/2<br />
Http method :DELTE<br />
**output**:{
    "code": 200,
    "message": "Address Deleted Sucessfully"
}<br />


