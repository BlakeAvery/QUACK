# Qualcomm Universal Alert and Communication Klicker
A medical alert system that texts trusted emergency contacts when you're in trouble.
Made for Hack@CEWIT 2019.

# Inspiration
Everyone's seen the commercial for Life Alert, with their famous, trademarked tagline of "Help, I've fallen and I can't get up!" However, Life Alert is very expensive, and cannot immediately notify your family members that something is wrong. This is where QUACK, or the Qualcomm Universal Alert Communication Klicker comes in.
# What it does
This is meant to be worn as a bracelet on the user's wrist. In the event the user falls or is otherwise hurt and needs help as soon as possible, they would then press the button on the bracelet. When this button is pressed, our server immediately sends a text message to a list of trustworthy people who can be relied on to help the user. This includes relatives as well as caretakers.
# How we built it
We used a DragonBoard 410c as the bracelet board, with a button wired to one of the GPIO pins on the board, and a Python script that monitors the state of the button. As soon as the button state changes, the DragonBoard sends a TCP payload in CSV format to a server written in Java that includes an ID for the bracelet, GPS coordinates, the time the button was pressed, and the type of message (Usually alert). The server then uses the Twilio APIs to send a text message stating that the button has been pressed due to an emergency situation, the GPS coordinates the buttons were pressed at, the time of the button press, and a request to go help the user who pressed the button. The messages are sent to a list of phone numbers that the user would enter into the system when they purchased the service. 
# Challenges we ran into
This was our first time using GPIO on the DragonBoard, as well as our first time using Twilio, and we also ran into a few issues with the DragonBoard itself. However, we were able to get everything working at the end.
# Accomplishments that we're proud of
Just getting everything working feels pretty good!
# What we learned
Twilio turned out to be super simple to use, and so did the DragonBoard's GPIO, once we did a bit more reading on the subject. We also learned a lot about how Gradle works for dependencies and building.
# What's next for QUACK
The next step for QUACK is to add cellular capacity to it, so that users would not be tied down to their homes. We'd also like to get voice calling capability added to QUACK, so that it could act as an emergency telephone as well in the unfortunate event that a user's emergency contacts fail to respond.

