# patents-restful-api
 Restful API for Patents Repository
 
 Instructions:
 1. Execute patents.sql,user.sql and create tables in Mysql Database.
 2. Edit database.cfg with host, port and database details.
 3. Execute the jar.

API EndPoints:

/authenticate - for authetication (GET)

/test - to the application is up or not (GET)

/patents - returns all the patents in db (GET)

/patents?size=n - returns 'n' patents from db (GET

/patents - adds new patent to db (POST)

/patents - updates existing patent in db (PUT)

/patents - deletes existing patent in db (DELETE)

/patents/{id}?applicationssn=x&casenumber=y (GET) - returns Patent object for given patentid, applicationssn and casenumber (these three columns are part of primary key)
