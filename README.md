# Cloud_vision_image_recognition

Project made for image recognition - recognises basic object that are on image.


# Requirements for backend part
Backend was implemented with Java Spring boot framework 
* Netbeans, Inteliij or other capable compiler
* Maven 3.5+
* Java 8/11

# Requirements for frontend part
Frontend was implemented with Javascript Vue.js 
* Node.js

# Project launch (Inteliij enviroment)
## sequence
1. Open project in Inteliij and make sure all dependencies are downoloaded. Click on pom.xml->Maven->Downoload Sources.
2. In application.properties check spring.cloud.gcp.credentials.encoded-key and if needed change port.
3. Run te project. (After you can check it "responsivnes" by oppening http://localhost:2222/getLabelDetection?imageURL=https://storage.googleapis.com/bucketusss/demo-img.jpg ).
4. To run Frontend part in terminal go to frontend folder (cd frontend) and paste - npm run serve.

# About the project
Project works with 1 request created in backend part where we passing image URL as parameter and gettig in response:
* Backend - json list of objects ("labels")
  * after we cast our request (http://localhost:2222/getLabelDetection) we get nicely formated json response in our browser, it's because of the parser class.
  * Parser class was used to pretty print json, because the initial answer from used API was plain text, that was not parsing by basic json functions.
* Frontend - json object where we grab "desription" atribute.
After launching frontend (more details in vue.config.js file) we see main page:
* input field 
* image placeholder
* button 
* table with response (after submitting button)
Frontend workflow is simple, we paste image URL and get in response recognized objects on that image. Moreover after every refresh in browser, if we open console we see 5 objects that come from different URLs (axio.all was used to grab all and display only when every URL was passed to request).

# Things that could be done better
1. Those 5 (could be more) object in console should be displayed. Problem occured with getting data out of them.
2. In this type of scenario Docker would be ideal to simplify launch. Problem occured with setting up Docker and (((time))).
3. CSS and overal template that was created by me could be better, the whole idea of displaying response could be more creative. Aimed to use this template and put responses after hovering over image (https://codepen.io/vladracoare/pen/WNQGZxy).

# What I have learned 
1. Vue.js basics (never used frontend that seriuosly and vue used for the first time).
2. Understood how google cloud API work, how to use them.
3. Finally saw how frontend is dealing with backend, how it is connected etc.





