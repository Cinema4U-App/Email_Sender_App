This app is used to send emails to users that register or reserve/buy tickets in the main app. It has a synchronous rest method for sending an email that is called by the main app when a user 
registers into the system, and an asynchronous method of sending emails when a user buys a ticket by using a rabbitmq queue to receive the requests. The emails are sent to mailtrap.io (add the
info of your account to application.properties file).
