# patents-restful-api
 Restful API for Patents Repository
 
 Instructions:
 1. Execute patents.sql,user.sql and create tables in Mysql Database.
 2. Edit database.cfg with host, port and database details.
 3. Execute the jar.

API EndPoints:

/authenticate - for authetication 

/test - to the application is up or not

/patents - returns all the patents in db

/patents?size=n - returns 'n' patents from db

/patents/{id}?applicationssn=x&casenumber=y - return Patent object with given patentid,applicationssn and casenumber (these three columns combined to form primary key)
