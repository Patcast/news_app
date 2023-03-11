# Insight App
## Main fetures:

Our App is a fully functional android native App. All the information that is present is actual data that was retrive by our programs and API's usage. 


### General
- Uses firebase firestore for it's db (non-sql)
- Realtime updates on the app from remore changes on the server
- The database is hosted on the cloud
- All articles are retrive from the db and generated via our API
- Use of MVC arquitecthure


### List Of articles Fragment
- Topic and Title are retive form the db and updated in realtime via firebase SnapshotListeners
- Images hardcoded
- The whole UI was designed and fully implemented by our team

### Menu of Categories Fragment
- Categories can be selectes or deselected and the changes are updated in the db
- State of the categories are syncronize with our realtime db
- Server generates articlesm that later uppdates to the db, based on the category selection of this section in realtime. 
- The whole UI was designed and fully implemented by our team
  
### Article Fragment
- All the infomation, besides the picture, belong to a real examples that were withdrawed by our API, that runs in our servers, from the internet. 
- State of the categories are syncronize with our realtime db
- The whole UI was designed and fully implemented by our team




