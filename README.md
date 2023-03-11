# Insight App

Insight is an Android native app that allows users to stay up-to-date with the latest news and articles in various categories. The app uses Firebase Firestore as a database and implements the Model-View-Controller (MVC) architecture. The articles are retrieved from the internet using Google's APIs, and a Chat GPT API is used to generate summaries for the articles.

## Features

Insight offers the following features:

- Realtime updates: The app retrieves information from the database hosted on the cloud and updates in real-time using Firebase SnapshotListeners.
- Personalized categories: Users can customize the categories that the app uses to find articles.
- Latest articles feed: The app presents a list of the latest articles in the selected category.
- Chat GPT summary: The app generates a summary of the hottest article in the selected category using a Chat GPT API.
- Intuitive UI: The app's user interface was designed and fully implemented by our team to provide a seamless and enjoyable experience.

## How it works

Insight has three main fragments:

1. List of articles: This fragment displays a feed with the latest articles in the selected category. The app retrieves this information from the database and updates it in real-time using Firebase SnapshotListeners.
2. Menu of categories: This fragment allows users to select or deselect categories. The app synchronizes these changes with the database, and the server generates articles based on the selected categories.
3. Article fragment: This fragment presents a Chat GPT summary of the hottest article in the selected category. The app retrieves this information from the database and generates the summary using the Chat GPT API.

## Technologies used

Insight uses the following technologies:

- Firebase Firestore: A NoSQL cloud-based database that enables real-time data synchronization.
- Google APIs: The app uses Google's APIs to find the latest articles that match the selected categories.
- Chat GPT API: The app generates summaries of articles using the Chat GPT API.
- MVC architecture: The app follows the Model-View-Controller architecture to maintain a separation of concerns between the different components of the app.

## Conclusion

Insight is an Android native app that provides users with the latest news and articles in various categories. The app uses cutting-edge technologies like Firebase Firestore and Chat GPT to deliver personalized and real-time updates. Insight's intuitive UI makes it easy to use and provides a seamless experience for users.




